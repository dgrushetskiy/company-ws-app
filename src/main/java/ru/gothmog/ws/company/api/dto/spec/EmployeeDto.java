package ru.gothmog.ws.company.api.dto.spec;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.gothmog.ws.company.api.dto.AbstractDto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

import static ru.gothmog.ws.company.core.utils.DatePatternUtils.DATE_FORMAT_RU;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonRootName(value = "employee")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto extends AbstractDto {

    @JsonProperty(value = "publicId", access = JsonProperty.Access.READ_ONLY)
    private UUID publicId = UUID.randomUUID();
    @Size(max = 250, message = "больше 250 символов")
    @JsonProperty(value = "firstName")
    private String firstName;
    @Size(max = 250, message = "больше 250 символов")
    @JsonProperty(value = "lastName")
    private String lastName;
    @Size(max = 250, message = "больше 250 символов")
    @JsonProperty(value = "email")
    private String email;
    @Size(max = 250, message = "больше 250 символов")
    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "description")
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_RU)
    @JsonProperty(value = "birthDate")
    private LocalDate birthDate;
    @NotNull(message = "Поле departmentId должно быть задано")
    @JsonProperty(value = "departmentId")
    private Long departmentId;
}
