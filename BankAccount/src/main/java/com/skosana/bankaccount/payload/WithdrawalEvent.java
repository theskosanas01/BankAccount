package com.skosana.bankaccount.payload;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WithdrawalEvent {
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("accountId")
    private Long accountId;
    @JsonProperty("status")
    private String status;
}
