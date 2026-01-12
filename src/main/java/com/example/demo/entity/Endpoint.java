package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Endpoint")
@Table(name = "endpoints",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "endpoint_slug_unique",
                    columnNames = "slug"
            )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Endpoint {

    @Id
    @SequenceGenerator(
            name = "endpoint_sequence",
            sequenceName = "endpoint_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private Long userId;

    @Column(name = "slug", nullable = false, unique = true, columnDefinition = "TEXT")
    private String slug;

    @Column(name = "secret", nullable = false, columnDefinition = "TEXT")
    private String secret;

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "endpoint", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Destination> destinations;

    @OneToMany(mappedBy = "endpoint", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InboundRequest> inboundRequests;

}
