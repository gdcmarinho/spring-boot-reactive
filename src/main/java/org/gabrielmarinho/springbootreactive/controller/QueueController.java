package org.gabrielmarinho.springbootreactive.controller;

import org.gabrielmarinho.springbootreactive.model.QueueItem;
import org.gabrielmarinho.springbootreactive.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController()
public class QueueController {
    @Autowired
    private QueueService queueService;

    @GetMapping(value = "/join")
    public Mono<QueueItem> joinQueue() {
        return queueService.joinQueue();
    }

    @GetMapping(value = "/status")
    public Mono<String> getQueueStatus() {
        return Mono.just("OK STATUS");
    }
}
