package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "DeliveryAttempt")
@Table(name = "delivery_attempts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DeliveryAttempt {

    @Id
    @SequenceGenerator(
            name = "delivery_attempt_sequence",
            sequenceName = "delivery_attempt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "inbound_request_id", nullable = false, insertable = false, updatable = false)
    private Long inboundRequestId;

    @Column(name = "destination_id", nullable = false, insertable = false, updatable = false)
    private Long destinationId;

    @Column(name = "status", nullable = false, columnDefinition = "TEXT")
    private String status;

    @Column(name = "response_code")
    private Integer responseCode;

    @Column(name = "attempt_number", nullable = false)
    private Integer attemptNumber;

    @Column(name = "next_retry_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime nextRetryAt;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inbound_request_id", nullable = false)
    private InboundRequest inboundRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

}
