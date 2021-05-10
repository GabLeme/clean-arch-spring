package com.io.banking.wallet.core.usecases.user;

import com.io.banking.wallet.core.domain.NameAlreadyUsedException;
import com.io.banking.wallet.core.domain.User;
import com.io.banking.wallet.core.usecases.UseCase;
import lombok.Value;

import java.util.Optional;

public class CreateUserUseCase extends UseCase<CreateUserUseCase.InputValues, CreateUserUseCase.OutputValues>{

    private UserRepository repository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        Optional<User> userWasFound = this.repository.findByNome(input.name);
        if(userWasFound.isPresent()) throw new NameAlreadyUsedException("Name is already in use!");

        User userToBeSaved = new User(Long.MIN_VALUE, input.name);

        return new OutputValues(repository.persist(userToBeSaved));
    }

    @Value
    public static class InputValues implements UseCase.InputValues{
        private final String name;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        private final User user;
    }
}
