package com.juniorjavaready.domain.NumberReceiver;

import java.util.UUID;

public class HashGenerator {
    public String generateHash() {
        return UUID.randomUUID().toString();
    }
}
