package ru.gothmog.ws.company.core.repository.spec;

import org.springframework.stereotype.Repository;
import ru.gothmog.ws.company.core.model.spec.Employee;
import ru.gothmog.ws.company.core.repository.BaseRepository;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Long> {}