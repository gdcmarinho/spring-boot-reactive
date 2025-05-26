package org.gabrielmarinho.springbootreactive.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HealthcheckController {
    @GetMapping(value = "/health", produces = MediaType.TEXT_PLAIN_VALUE)
    public Mono<String> healthCheck() {
        return Mono.just("OK");
    }
}
