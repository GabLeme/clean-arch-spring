package com.io.banking.wallet.core.usecases.user;

import com.io.banking.wallet.core.domain.User;

import java.util.Optional;

public interface UserRepository {
    User persist(User user);
    Optional<User> findByNome(String nome);
}
