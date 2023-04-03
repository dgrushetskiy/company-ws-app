package ru.gothmog.ws.company.core.model.spec;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.gothmog.ws.company.core.model.AbstractEntity;

import javax.persistence.Index;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.FetchType;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "calendars", schema = "spec", indexes = {@Index(name = "idx_calendar_uuid_unq", columnList = "public_id", unique = true)})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Calendar extends AbstractEntity {

    @Column(name = "public_id", nullable = false, unique = true)
    private UUID publicId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "begin_period")
    private LocalDateTime beginPeriod;

    @Column(name = "end_period")
    private LocalDateTime endPeriod;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id", nullable = false, foreignKey = @ForeignKey(name = "fk_calendars_company"))
    private Company company;
}
