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
@JsonRootName(value = "calendar")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalendarDto extends AbstractDto {

    @JsonProperty(value = "publicId", access = JsonProperty.Access.READ_ONLY)
    private UUID publicId = UUID.randomUUID();
    @Size(max = 255, message = "больше 255 символов")
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "description")
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_RU)
    @JsonProperty(value = "beginPeriod")
    private LocalDate beginPeriod;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_RU)
    @JsonProperty(value = "endPeriod")
    private LocalDate endPeriod;
    @NotNull(message = "Поле companyId должно быть задано")
    @JsonProperty(value = "companyId")
    private Long companyId;
}
