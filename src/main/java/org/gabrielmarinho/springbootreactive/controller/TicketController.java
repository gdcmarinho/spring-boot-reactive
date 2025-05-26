package org.gabrielmarinho.springbootreactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/ticket")
public class TicketController {
    @GetMapping("/purchase")
    public Mono<String> purchase() {
        return Mono.just("OK PURCHASE");
    }
}
