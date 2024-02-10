package com.sprigboot.bankingapp.mapper;

import com.sprigboot.bankingapp.dto.AccountDto;
import com.sprigboot.bankingapp.model.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account=new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                accountDto.getAccountType()
                );
        return account;
    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getAccountType()
        );
        return accountDto;
    }
}
