package nl.jug.jfall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import nl.jug.jfall.dto.TaakDto;
import nl.jug.jfall.dto.TaakactieDto;
import nl.jug.jfall.dto.Urgentie;
import org.joda.time.DateTime;

public enum TakenDatabaseFake implements TakenRepository {

    /**
     * Methode om een singleton van deze Enum te maken.
     */
    INSTANCE();
    private long newTaakId = 0L;
    private List<TaakDto> taken;

    private TakenDatabaseFake() {

        TaakactieDto toewijsTaakActie = new TaakactieDto("Toewijzen");
        toewijsTaakActie.setBehandelaars(Arrays.asList("Tim", "Peter", "Kim"));

        TaakactieDto gereedMeldenTaakActie = new TaakactieDto("Toewijzen");
        gereedMeldenTaakActie.setBehandelaars(Arrays.asList("Ander persoon", "Nog een ander persoon"));

        taken = new ArrayList<>(
                Arrays.asList(
                        new TaakDto(getNewId(),
                                "Interessante Java artikelen lezen",
                                DateTime.now().minusDays(6).toDate(),
                                "Peter",
                                "Lezen",
                                "In Behandeling",
                                Urgentie.Hoog,
                                toewijsTaakActie),
                        new TaakDto(getNewId(),
                                "Demo voorbereiden JFall",
                                DateTime.now().minusDays(5).toDate(),
                                null,
                                "Demo",
                                "In behandeling",
                                Urgentie.Middel,
                                null),
                        new TaakDto(getNewId(),
                                "Nieuwe features Java EE 8 doornemen",
                                DateTime.now().minusDays(3).toDate(),
                                "Teun",
                                "Java EE",
                                "Open",
                                Urgentie.Laag,
                                gereedMeldenTaakActie)
                ));
    }

    /**
     * Zoekt taken op basis van zoekcriteria.
     *
     * @param criteria de zoekcriteria.
     * @return een collectie met gevonden taken; anders een lege lijst.
     */
    @Override
    public Collection<TaakDto> search(final TaakSearchCriteria criteria) {
        return getByCriteria(criteria);
    }

    /**
     * Get een taak op basis van id.
     *
     * @param id het id van de taak.
     * @return de taak indien gevonden; anders null.
     */
    @Override
    public TaakDto getById(final long id) {
        TaakSearchCriteria criteria = new TaakSearchCriteria();
        criteria.setId(id);

        Collection<TaakDto> takenFound = getByCriteria(criteria);
        if (takenFound.isEmpty()) {
            // Genoeg voor deze fake. De echte implementatie moet een Exception throwen.
            return null;
        }

        return takenFound.iterator().next();
    }

    private Collection<TaakDto> getByCriteria(final TaakSearchCriteria criteria) {
        List<TaakDto> results = new ArrayList<>();
        for (TaakDto taakDto : taken) {
            if (criteria.includes(taakDto)) {
                results.add(taakDto);
            }
        }
        return results;
    }


    private long getNewId() {
        return newTaakId++;
    }

}
