package ru.gothmog.ws.company.core.repository.spec;

import org.springframework.stereotype.Repository;
import ru.gothmog.ws.company.core.model.spec.Company;
import ru.gothmog.ws.company.core.repository.BaseRepository;

@Repository
public interface CompanyRepository extends BaseRepository<Company, Long> {}