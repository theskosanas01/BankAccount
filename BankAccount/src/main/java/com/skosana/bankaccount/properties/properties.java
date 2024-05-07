package com.skosana.bankaccount.properties;

import lombok.Data;
import lombok.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class properties {
  //  @Value("${is.sns.config}")
    private String isSnsConfig;
}
