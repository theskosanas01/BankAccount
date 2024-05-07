package com.skosana.bankaccount.controller;

import com.skosana.bankaccount.configs.Publish;
import com.skosana.bankaccount.payload.WithdrawalEvent;
import com.skosana.bankaccount.service.impl.BankAccountImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/bank")
public class BankAccountController {

    @Autowired
    private BankAccountImpl bankAccount;

    private Publish publish;

    // change it to put since we are updating not adding.
    @PutMapping("/withdraw")
    public String withdraw(@RequestParam("accountId") Long accountId, @RequestParam("amount") BigDecimal amount) {
        log.info("calling the service to withdraw monies");
        WithdrawalEvent event = bankAccount.withdraw(accountId, amount);
        publish = new Publish();
        publish.publish("topic", event.toString());

        return event.getStatus();
    }
}
