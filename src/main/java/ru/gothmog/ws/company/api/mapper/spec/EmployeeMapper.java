package ru.gothmog.ws.company.api.mapper.spec;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import ru.gothmog.ws.company.api.dto.spec.EmployeeDto;
import ru.gothmog.ws.company.api.mapper.AbstractMapper;
import ru.gothmog.ws.company.api.mapper.MapperConverter;
import ru.gothmog.ws.company.core.model.spec.Employee;
import ru.gothmog.ws.company.core.repository.spec.DepartmentRepository;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@MapperConverter
public class EmployeeMapper extends AbstractMapper<Employee, EmployeeDto> {

    private final ModelMapper mapper;
    private final DepartmentRepository departmentRepository;

    public EmployeeMapper(ModelMapper mapper, DepartmentRepository departmentRepository) {
        super(Employee.class, EmployeeDto.class);
        this.mapper = mapper;
        this.departmentRepository = departmentRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Employee.class, EmployeeDto.class)
              .addMappings(m -> m.skip(EmployeeDto::setDepartmentId))
              .addMappings(m -> m.skip(EmployeeDto::setBirthDate))
              .setPostConverter(toDtoConverter());
        mapper.createTypeMap(EmployeeDto.class, Employee.class)
              .addMappings(m -> m.skip(Employee::setDepartment))
              .addMappings(m -> m.skip(Employee::setBirthDate))
              .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(@NotNull Employee source, @NotNull EmployeeDto destination) {
        destination.setDepartmentId(getDepartmentId(source));
        destination.setBirthDate(getLocalDateBirthDateToDto(source));
    }

    @Override
    protected void mapSpecificFields(@NotNull EmployeeDto source, @NotNull Employee destination) {
        destination.setDepartment(departmentRepository.findById(source.getDepartmentId())
                                                      .orElse(null));
        destination.setBirthDate(getLocalDateBirthDateToEntity(source));
    }



    private Long getDepartmentId(Employee source) {
        return Objects.isNull(source) || Objects.isNull(source.getId())
               ? null
               : source.getDepartment()
                       .getId();
    }


    private LocalDate getLocalDateBirthDateToDto(Employee source) {
        return Objects.isNull(source) || Objects.isNull(source.getBirthDate())
               ? null
               : source.getBirthDate()
                       .toLocalDate();
    }

    private LocalDateTime getLocalDateBirthDateToEntity(EmployeeDto source) {

        return Objects.isNull(source) || Objects.isNull(source.getBirthDate())
               ? null
               : source.getBirthDate()
                       .atStartOfDay();
    }
}
