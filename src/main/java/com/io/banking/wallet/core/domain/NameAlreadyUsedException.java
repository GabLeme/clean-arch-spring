package com.io.banking.wallet.core.domain;

public class NameAlreadyUsedException extends DomainException {

    public NameAlreadyUsedException(String message) {
        super(message);
    }
}
