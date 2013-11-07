package nl.jug.jfall;

import nl.jug.jfall.dto.TaakDto;

import java.util.Collection;

public interface TakenRepository {
    Collection<TaakDto> search(TaakSearchCriteria criteria);

    TaakDto getById(long id);

}
