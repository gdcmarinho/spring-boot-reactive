package org.gabrielmarinho.springbootreactive.controller;

import org.gabrielmarinho.springbootreactive.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/purchase")
    public Mono<String> purchase() {
        return Mono.just("OK PURCHASE");
    }
}
