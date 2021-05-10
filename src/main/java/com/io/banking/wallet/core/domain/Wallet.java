package com.io.banking.wallet.core.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Wallet {
    private final long id;
    private BigDecimal balance;
    private List<Transaction> transactions;
    private final User user;
}
