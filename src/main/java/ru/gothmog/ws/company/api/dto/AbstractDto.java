package ru.gothmog.ws.company.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import static ru.gothmog.ws.company.core.utils.DatePatternUtils.DATE_FORMAT_RU;


@Data
public abstract class AbstractDto implements Serializable {

    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @JsonProperty(value = "createdAt", access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_RU)
    private LocalDateTime createdAt;
    @JsonProperty(value = "updatedAt", access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_RU)
    private LocalDateTime updatedAt;
    @JsonProperty(value = "active", access = JsonProperty.Access.READ_ONLY)
    private Boolean active = true;
}
