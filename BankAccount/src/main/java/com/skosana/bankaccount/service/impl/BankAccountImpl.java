package com.skosana.bankaccount.service.impl;

import com.skosana.bankaccount.entities.Account;
import com.skosana.bankaccount.payload.WithdrawalEvent;
import com.skosana.bankaccount.repository.AccountRepository;
import com.skosana.bankaccount.service.interfaces.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.skosana.bankaccount.util.mask.maskString;

@Slf4j
@Service
public class BankAccountImpl implements BankAccount {

    @Autowired
    private AccountRepository accountRepository;
    List<Account> accounts;

    @Override
    public WithdrawalEvent withdraw(Long accountid, BigDecimal amountToWithdraw) {
        WithdrawalEvent event = new WithdrawalEvent();
        log.info("withdraw account {} and amountToWithdraw {}", maskString(accountid), amountToWithdraw);
        if (checkBalanceAvialable(accountid, amountToWithdraw)) {
            event.setStatus(updateBalance(accountid, amountToWithdraw));
            event.setAccountId(accountid);
            event.setAmount(amountToWithdraw);
        } else {
            event.setAccountId(accountid);
            event.setAmount(amountToWithdraw);
            event.setStatus("failed");
        }
        return event;
    }

    private Boolean checkBalanceAvialable(Long accountid, BigDecimal amountToWithdraw) {
        accounts = accountRepository.findAccountsByAccountid(accountid.intValue());
        if (!accounts.isEmpty()) {
            BigDecimal balance = accounts.get(0).getBalance();
            if (balance.compareTo(amountToWithdraw) >= 0) {
                log.info("Have enough funds to withdraw account");
                return true;
            }
            {
                log.info("Insufficient funds for withdrawal for account {}", maskString(accountid));
                return false;
            }
        } else {
            log.info("account with id {} not found",maskString(accountid));
            return false;
        }
    }

    private String updateBalance(Long accountid, BigDecimal amountToWithdraw) {

        try {
            if (!accounts.isEmpty()) {
                Account account = accounts.getFirst();
                account.setBalance(account.getBalance().subtract(amountToWithdraw));
                accountRepository.save(account);
                return "success";
            } else {
                log.info("account with id {} not found, cannot update balance", maskString(accountid));
                return "failed";
            }
        } catch (Exception e) {
            log.error("Error updating balance for account {}", maskString(accountid), e);
            return "failed";
        }
    }
}
