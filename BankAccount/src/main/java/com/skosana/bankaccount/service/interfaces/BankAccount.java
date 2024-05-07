package com.skosana.bankaccount.service.interfaces;

import com.skosana.bankaccount.payload.WithdrawalEvent;

import java.math.BigDecimal;

public interface BankAccount {
    WithdrawalEvent withdraw(Long amount, BigDecimal amountToWithdraw);
}
