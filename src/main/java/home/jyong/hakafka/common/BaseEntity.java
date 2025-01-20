package home.jyong.hakafka.common;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.YesNoConverter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(name = "SEQ_NO")
    private long seqNo = 1;

    @Column(name = "USE_YN")
    @Convert(converter = YesNoConverter.class)
    private boolean useYn = true;

    @CreatedBy
    @Column(name = "FRST_RGST_ID", updatable = false)
    private String frstRgstId;

    @CreationTimestamp
    @Column(name = "FRST_RGST_DT", updatable = false)
    private LocalDateTime frstRgstDt;

    @LastModifiedBy
    @Column(name = "LAST_MDFY_ID")
    private String lastMdfyId;

    @UpdateTimestamp
    @Column(name = "LAST_MDFY_DT")
    private LocalDateTime lastMdfyDt;

    public void enable() {
        this.useYn = true;
    }

    public void disable() {
        this.useYn = false;
    }

    public void updateUseYn() {
        this.useYn = !this.useYn;
    }

}
