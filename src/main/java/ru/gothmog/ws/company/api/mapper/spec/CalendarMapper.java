package ru.gothmog.ws.company.api.mapper.spec;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import ru.gothmog.ws.company.api.dto.spec.CalendarDto;
import ru.gothmog.ws.company.api.mapper.AbstractMapper;
import ru.gothmog.ws.company.api.mapper.MapperConverter;
import ru.gothmog.ws.company.core.model.spec.Calendar;
import ru.gothmog.ws.company.core.repository.spec.CompanyRepository;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@MapperConverter
public class CalendarMapper extends AbstractMapper<Calendar, CalendarDto> {

    private final ModelMapper mapper;
    private final CompanyRepository companyRepository;

    public CalendarMapper(ModelMapper mapper, CompanyRepository companyRepository) {
        super(Calendar.class, CalendarDto.class);
        this.mapper = mapper;
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Calendar.class, CalendarDto.class)
                .addMappings(m -> m.skip(CalendarDto::setCompanyId))
                .addMappings(m -> m.skip(CalendarDto::setBeginPeriod))
                .addMappings(m -> m.skip(CalendarDto::setEndPeriod))
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(CalendarDto.class, Calendar.class)
                .addMappings(m -> m.skip(Calendar::setCompany))
                .addMappings(m -> m.skip(Calendar::setBeginPeriod))
                .addMappings(m -> m.skip(Calendar::setEndPeriod))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(@NotNull Calendar source, @NotNull CalendarDto destination) {
        destination.setCompanyId(getCompanyId(source));
        destination.setBeginPeriod(getLocalDateBeginPeriodToDto(source));
        destination.setEndPeriod(getLocalDateEndPeriodToDto(source));
    }

    @Override
    protected void mapSpecificFields(@NotNull CalendarDto source, @NotNull Calendar destination) {
        destination.setCompany(companyRepository.findById(source.getCompanyId())
                .orElse(null));
        destination.setBeginPeriod(getLocalDateTimeDateBeginPeriodToEntity(source));
        destination.setEndPeriod(getLocalDateTimeDateEndPeriodToEntity(source));
    }


    private Long getCompanyId(Calendar source) {
        return Objects.isNull(source) || Objects.isNull(source.getId())
                ? null
                : source.getCompany()
                .getId();
    }

    private LocalDate getLocalDateBeginPeriodToDto(Calendar source) {
        return Objects.isNull(source) || Objects.isNull(source.getBeginPeriod())
                ? null
                : source.getBeginPeriod()
                .toLocalDate();
    }

    private LocalDate getLocalDateEndPeriodToDto(Calendar source) {
        return Objects.isNull(source) || Objects.isNull(source.getEndPeriod())
                ? null
                : source.getEndPeriod()
                .toLocalDate();
    }

    private LocalDateTime getLocalDateTimeDateBeginPeriodToEntity(CalendarDto source) {

        return Objects.isNull(source) || Objects.isNull(source.getBeginPeriod())
                ? null
                : source.getBeginPeriod()
                .atStartOfDay();
    }

    private LocalDateTime getLocalDateTimeDateEndPeriodToEntity(CalendarDto source) {

        return Objects.isNull(source) || Objects.isNull(source.getEndPeriod())
                ? null
                : source.getEndPeriod()
                .atStartOfDay();
    }
}
