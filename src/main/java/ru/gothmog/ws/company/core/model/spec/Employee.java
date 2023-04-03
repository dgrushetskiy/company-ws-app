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
@Table(name = "employees", schema = "spec", indexes = {@Index(name = "idx_employee_uuid_unq", columnList = "public_id", unique = true)})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employee extends AbstractEntity {

    @Column(name = "public_id", nullable = false, unique = true)
    private UUID publicId;

    @Column(name = "first_name", length = 250)
    private String firstName;

    @Column(name = "last_name", length = 250)
    private String lastName;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "username", length = 250)
    private String username;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "department_id", nullable = false, foreignKey = @ForeignKey(name = "fk_employees_department"))
    private Department department;
}
