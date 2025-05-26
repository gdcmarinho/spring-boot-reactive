package org.gabrielmarinho.springbootreactive.service;

import org.gabrielmarinho.springbootreactive.model.QueueItem;
import org.gabrielmarinho.springbootreactive.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
public class QueueService {
    private final QueueRepository queueRepository;

    @Autowired
    public QueueService(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    public Mono<QueueItem> joinQueue() {
        QueueItem queueItem = new QueueItem();
        queueItem.setQueueUuid(UUID.randomUUID());
        queueItem.setTimestamp(Timestamp.from(Instant.now()));

        return queueRepository.save(queueItem);
    }

}
