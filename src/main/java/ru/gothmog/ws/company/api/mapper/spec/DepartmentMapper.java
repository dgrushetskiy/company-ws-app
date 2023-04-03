package ru.gothmog.ws.company.api.mapper.spec;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import ru.gothmog.ws.company.api.dto.spec.DepartmentDto;
import ru.gothmog.ws.company.api.mapper.AbstractMapper;
import ru.gothmog.ws.company.api.mapper.MapperConverter;
import ru.gothmog.ws.company.core.model.spec.Department;
import ru.gothmog.ws.company.core.repository.spec.CompanyRepository;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Slf4j
@MapperConverter
public class DepartmentMapper extends AbstractMapper<Department, DepartmentDto> {

    private final ModelMapper mapper;
    private final CompanyRepository companyRepository;

    public DepartmentMapper(ModelMapper mapper, CompanyRepository companyRepository) {
        super(Department.class, DepartmentDto.class);
        this.mapper = mapper;
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Department.class, DepartmentDto.class)
              .addMappings(m -> m.skip(DepartmentDto::setCompanyId))
              .setPostConverter(toDtoConverter());
        mapper.createTypeMap(DepartmentDto.class, Department.class)
              .addMappings(m -> m.skip(Department::setCompany))
              .setPostConverter(toEntityConverter());
    }


    @Override
    protected void mapSpecificFields(@NotNull Department source, @NotNull DepartmentDto destination) {
        destination.setCompanyId(getCompanyId(source));
    }

    @Override
    protected void mapSpecificFields(@NotNull DepartmentDto source, @NotNull Department destination) {
        destination.setCompany(companyRepository.findById(source.getCompanyId()).orElse(null));
    }


    private Long getCompanyId(Department source) {
        return Objects.isNull(source) || Objects.isNull(source.getId())
               ? null
               : source.getCompany()
                       .getId();
    }
}
