package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "InboundRequest")
@Table(name = "inbound_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class InboundRequest {

    @Id
    @SequenceGenerator(
            name = "inbound_request_sequence",
            sequenceName = "inbound_request_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "endpoint_id", nullable = false, insertable = false, updatable = false)
    private Long endpointId;

    @Column(name = "headers", nullable = false, columnDefinition = "TEXT")
    private String headers;

    @Column(name = "payload", nullable = false, columnDefinition = "TEXT")
    private String payload;

    @Column(name = "received_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime receivedAt;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endpoint_id", nullable = false)
    private Endpoint endpoint;

    @OneToMany(mappedBy = "inboundRequest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DeliveryAttempt> deliveryAttempts;

}
