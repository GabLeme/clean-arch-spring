package com.io.banking.wallet.core.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transaction {
    private final long id;
    private final Wallet recipient;
    private final BigDecimal ammountBefore;
    private final BigDecimal ammountAfter;
}
