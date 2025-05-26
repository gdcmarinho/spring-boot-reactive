package org.gabrielmarinho.springbootreactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/queue")
public class QueueController {
    @GetMapping(value = "/join")
    public Mono<String> joinQueue() {
        return Mono.just("OK JOIN");
    }

    @GetMapping(value = "/status")
    public Mono<String> getQueueStatus() {
        return Mono.just("OK STATUS");
    }
}
