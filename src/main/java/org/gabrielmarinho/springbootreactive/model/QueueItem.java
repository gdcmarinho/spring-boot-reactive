package org.gabrielmarinho.springbootreactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Table("queue")
public class QueueItem {
    @Id
    private Long id;
    private UUID queueUuid;
    private Timestamp timestamp;
}
