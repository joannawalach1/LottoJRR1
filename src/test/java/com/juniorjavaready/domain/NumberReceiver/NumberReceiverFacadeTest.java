package com.juniorjavaready.domain.NumberReceiver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberReceiverFacadeTest {

    private NumberReceiverRepositoryImpl numberReceiverRepositoryImpl;
    private NumberReceiverFacade numberReceiverFacade;
    private NumberValidator validator;
    private Clock clock;
    private HashGenerator hashGenerator;

    @BeforeEach
    public void setUp() {
        numberReceiverRepositoryImpl = new NumberReceiverRepositoryImpl();
        validator = new NumberValidator();
        numberReceiverFacade = new NumberReceiverFacade(validator, numberReceiverRepositoryImpl, clock, hashGenerator);
    }

    @Test
    public void should_return_success_if_user_gave_6_numbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numberReceiverRepositoryImpl.save(numbers);
        List<Integer> result = numberReceiverFacade.inputNumbers(numbers);
        assertEquals(numbers.size(), result.size(), "The size of the returned list should match the input list size.");
    }
}
