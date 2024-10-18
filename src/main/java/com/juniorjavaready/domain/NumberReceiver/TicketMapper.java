package com.juniorjavaready.domain.NumberReceiver;

import com.juniorjavaready.domain.NumberReceiver.dto.TicketDto;

public class TicketMapper {
    public static TicketDto toDto(Ticket ticket) {
        return TicketDto.builder()
                .ticketId(ticket.ticketId())
                .drawDate(ticket.drawDate())
                .numbersFromUser(ticket.numbersFromUser())
                .build();
    }
}
