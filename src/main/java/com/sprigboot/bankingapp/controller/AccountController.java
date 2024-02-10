package com.sprigboot.bankingapp.controller;

import com.sprigboot.bankingapp.dto.AccountDto;
import com.sprigboot.bankingapp.service.AccountService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Find by id
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.FOUND);
    }

    //Deposit the money
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositMoney(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return new ResponseEntity<>(accountService.deposit(id, amount), HttpStatus.OK);
    }

//withdraw
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double > request) {
     double amount=request.get("amount");
     AccountDto accountDto=accountService.withDraw(id,amount);
     return ResponseEntity.ok(accountDto);

    }
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll(){
        return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
    }
    //Deleting the account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account deleted succesfuly",HttpStatus.OK);
    }
}