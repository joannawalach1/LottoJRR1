package com.juniorjavaready.domain.NumberReceiver;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberValidator {
    public Set<Integer> validate(Set<Integer> numbers) {
        return numbers = filteredNumbers(numbers).stream()
                .filter(number -> number >= 0)
                .filter(number -> number <=99)
                .collect(Collectors.toSet());
    }

    public Set<Integer> filteredNumbers(Set<Integer> numbersFromUser) {
       numbersFromUser = new HashSet<>();
        return numbersFromUser;
    }
}

