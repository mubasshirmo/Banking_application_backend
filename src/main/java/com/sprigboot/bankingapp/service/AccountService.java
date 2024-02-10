package com.sprigboot.bankingapp.service;

import com.sprigboot.bankingapp.dto.AccountDto;

import java.util.List;


public interface AccountService {

    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id,double amount);

    AccountDto withDraw(Long id,double amount);

    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);
}
