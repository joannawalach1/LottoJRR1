package com.juniorjavaready.domain.NumberReceiver;


import com.juniorjavaready.domain.NumberReceiver.dto.InputNumberResultDto;
import com.juniorjavaready.domain.NumberReceiver.dto.TicketDto;
import sun.security.krb5.internal.ccache.MemoryCredentialsCache;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class NumberReceiverFacade {

    private final NumberValidator numberValidator;
    private final Clock clock;
    private final HashGenerator hashGenerator;
    private TicketRepository ticketRepository;

    public NumberReceiverFacade(NumberValidator numberValidator, Clock clock, HashGenerator hashGenerator) {
        this.numberValidator = numberValidator;
        this.clock = clock;
        this.hashGenerator = hashGenerator;
    }


    public com.juniorjavaready.domain.NumberReceiver.dto.InputNumberResultDto inputNumbers(Set<Integer> numbersFromUser) {
        if (!numberValidator.filteredNumbers(numbersFromUser)) {
            return InputNumberResultDto.builder()
                    .message("fail")
                    .build();
        }

        String hash = hashGenerator.generateHash();
        LocalDateTime drawData = LocalDateTime.now(clock);
        Ticket ticket = new Ticket(hash, drawData, numbersFromUser);
        Ticket savedTicket = ticketRepository.save(ticket);

        if (savedTicket != null) {
            return InputNumberResultDto.builder()
                    .message("Success")
                    .ticketId(savedTicket.ticketId())
                    .drawDate(savedTicket.drawDate())
                    .numbersFromUser(savedTicket.numbersFromUser())
                    .build();
        } else {
            return InputNumberResultDto.builder()
                    .message("Fail")
                    .build();
        }
    }

    public List<TicketDto> userNumbers(LocalDateTime drawDate) {
        List<Ticket> allTicketsByDate = numberReceiverRepositoryImpl.findAll();
        return allTicketsByDate.stream()
                .map(TicketMapper::toDto)
                .toList();
    }
}
