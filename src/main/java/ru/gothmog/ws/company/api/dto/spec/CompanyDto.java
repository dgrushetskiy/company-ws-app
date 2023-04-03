package ru.gothmog.ws.company.api.dto.spec;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.gothmog.ws.company.api.dto.AbstractDto;


import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonRootName(value = "company")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto extends AbstractDto {

    @JsonProperty(value = "publicId", access = JsonProperty.Access.READ_ONLY)
    private UUID publicId = UUID.randomUUID();
    @Size(max = 255, message = "больше 255 символов")
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "departments", access = JsonProperty.Access.READ_ONLY)
    private List<DepartmentDto> departments;
    @JsonProperty(value = "calendars", access = JsonProperty.Access.READ_ONLY)
    private List<CalendarDto> calendars;
}
