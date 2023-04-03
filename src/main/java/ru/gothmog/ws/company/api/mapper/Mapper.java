package ru.gothmog.ws.company.api.mapper;



import ru.gothmog.ws.company.api.dto.AbstractDto;
import ru.gothmog.ws.company.core.model.AbstractEntity;

import java.util.List;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);

    List<D> toArrayListToDto(List<E> inArray);
}
