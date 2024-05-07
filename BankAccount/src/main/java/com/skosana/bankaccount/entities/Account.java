package com.skosana.bankaccount.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {

    @Id
    @Column(name = "accountid")
    private int accountid;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "active")
    private Boolean active;
}
