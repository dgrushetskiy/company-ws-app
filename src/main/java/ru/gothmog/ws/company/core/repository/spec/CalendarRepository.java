package ru.gothmog.ws.company.core.repository.spec;

import org.springframework.stereotype.Repository;
import ru.gothmog.ws.company.core.model.spec.Calendar;
import ru.gothmog.ws.company.core.repository.BaseRepository;

@Repository
public interface CalendarRepository extends BaseRepository<Calendar, Long> {}