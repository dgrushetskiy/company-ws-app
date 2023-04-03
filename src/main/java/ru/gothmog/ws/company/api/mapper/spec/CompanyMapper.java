package ru.gothmog.ws.company.api.mapper.spec;


import ru.gothmog.ws.company.api.dto.spec.CompanyDto;
import ru.gothmog.ws.company.api.mapper.AbstractMapper;
import ru.gothmog.ws.company.api.mapper.MapperConverter;
import ru.gothmog.ws.company.core.model.spec.Company;

@MapperConverter
public class CompanyMapper extends AbstractMapper<Company, CompanyDto> {

    public CompanyMapper() {
        super(Company.class, CompanyDto.class);
    }
}
