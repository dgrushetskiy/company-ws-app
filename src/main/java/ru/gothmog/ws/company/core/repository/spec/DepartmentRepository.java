package ru.gothmog.ws.company.core.repository.spec;

import org.springframework.stereotype.Repository;
import ru.gothmog.ws.company.core.model.spec.Department;
import ru.gothmog.ws.company.core.repository.BaseRepository;

@Repository
public interface DepartmentRepository extends BaseRepository<Department, Long> {}