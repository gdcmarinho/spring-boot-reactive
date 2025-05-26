package org.gabrielmarinho.springbootreactive.repository;

import org.gabrielmarinho.springbootreactive.model.QueueItem;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends ReactiveCrudRepository<QueueItem, Long> { }
