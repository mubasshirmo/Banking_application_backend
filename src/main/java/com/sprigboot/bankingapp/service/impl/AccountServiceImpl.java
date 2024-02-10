package com.sprigboot.bankingapp.service.impl;

import com.sprigboot.bankingapp.dto.AccountDto;
import com.sprigboot.bankingapp.mapper.AccountMapper;
import com.sprigboot.bankingapp.model.Account;
import com.sprigboot.bankingapp.repository.AccountRepo;
import com.sprigboot.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
       Account savedAccount= accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

       Account existingAccount= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
       double total=existingAccount.getBalance()+amount;
      existingAccount.setBalance(total);
    Account saved= accountRepo.save(existingAccount);
       return AccountMapper.mapToAccountDto(saved);
    }

    @Override
    public AccountDto withDraw(Long id, double amount) {
        Account existingAccount=accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        if(existingAccount.getBalance()<amount){
            throw new RuntimeException("Insufficient amount");
        }
        double total=existingAccount.getBalance()-amount;

        existingAccount.setBalance(total);
        Account savedAccount=accountRepo.save(existingAccount);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepo.findAll();
        return accounts.stream().map((account -> AccountMapper.mapToAccountDto(account))).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        accountRepo.deleteById(id);
    }
}
