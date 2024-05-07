package com.skosana.bankaccount.repository;

import com.skosana.bankaccount.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAccountsByAccountid(Integer accountid);
    //Boolean updateAccount(Account account);
}
