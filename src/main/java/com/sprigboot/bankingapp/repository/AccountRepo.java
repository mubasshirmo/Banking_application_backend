package com.sprigboot.bankingapp.repository;

import com.sprigboot.bankingapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
