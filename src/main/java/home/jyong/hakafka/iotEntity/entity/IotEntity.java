package home.jyong.hakafka.iotEntity.entity;

import home.jyong.hakafka.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import lombok.NonNull;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "IOT_ENTITY")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class IotEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_id", nullable = false)
    private String entityId;

    @Column(name = "state", nullable = false)
    private String state;

    @Embedded
    private Attributes attributes;

    @Column(name = "last_changed", nullable = false)
    private LocalDateTime lastChanged;

    @Column(name = "last_reported", nullable = false)
    private LocalDateTime lastReported;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @Column(name = "throttling_status")
    private String throttlingStatus;

    @Embedded
    private Context context;

    @Data
    @Embeddable
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Attributes {
        @Column(name = "friendly_name")
        private String friendlyName;
    }

    @Data
    @Embeddable
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Context {
        @Column(name = "context_id")
        private String id;

        @Column(name = "parent_id")
        private String parentId;

        @Column(name = "user_id")
        private String userId;
    }
}
