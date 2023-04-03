package ru.gothmog.ws.company.api.dto.spec;

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
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonRootName(value = "department")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentDto extends AbstractDto {

    @JsonProperty(value = "publicId", access = JsonProperty.Access.READ_ONLY)
    private UUID publicId = UUID.randomUUID();
    @Size(max = 250, message = "больше 255 символов")
    @JsonProperty(value = "fullName")
    private String fullName;
    @Size(max = 50, message = "больше 50 символов")
    @JsonProperty(value = "smallName")
    private String smallName;
    @JsonProperty(value = "description")
    private String description;
    @NotNull(message = "Поле companyId должно быть задано")
    @JsonProperty(value = "companyId")
    private Long companyId;
    @JsonProperty(value = "employees", access = JsonProperty.Access.READ_ONLY)
    private List<EmployeeDto> employees;
}
