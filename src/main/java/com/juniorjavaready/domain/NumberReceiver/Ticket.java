package com.juniorjavaready.domain.NumberReceiver;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
@Builder
public record Ticket(String ticketId, LocalDateTime drawDate, Set<Integer> numbersFromUser) {
}