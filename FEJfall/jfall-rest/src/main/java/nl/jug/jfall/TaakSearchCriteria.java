package nl.jug.jfall;

import nl.jug.jfall.dto.TaakDto;
import nl.jug.jfall.dto.Urgentie;

public final class TaakSearchCriteria {

    private String proces;
    private String behandelaar;
    private Urgentie urgentie;
    private Long id;

    /**
     * Set het id van de taak.
     *
     * @param id het id van de taak.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Set het proces waartoe de taak behoort.
     *
     * @param proces het proces.
     */
    public void setProces(final String proces) {
        this.proces = proces;
    }

    /**
     * Set de persoon waaraan de taak is toegewezen.
     *
     * @param behandelaar de persoon waaraan de taak is toegewezen.
     */
    public void setBehandelaar(final String behandelaar) {
        this.behandelaar = behandelaar;
    }

    /**
     * Set de urgentie van de taak.
     *
     * @param urgentie de urgentie van de taak.
     */
    public void setUrgentie(final Urgentie urgentie) {
        this.urgentie = urgentie;
    }

    /**
     * Contoleert of de criteria velden leeg zijn.
     *
     * @return true als er geen criteria is, anders false.
     */
    private boolean isEmpty() {
        return id == null
                && urgentie == null
                && behandelaar == null
                && proces == null;
    }

    /**
     * Controleert of de taak aan de criteria voldoet.
     *
     * @param taakDto de taak die aan de criteria moet voldoen.
     * @return true als de taak aan de criteria voldoet; anders false.
     */
    public boolean includes(final TaakDto taakDto) {
        if (isEmpty()) {
            return true;
        }

        return isNotExcludedByProces(taakDto)
                && isNotExcludedByBehandelaar(taakDto)
                && isNotExcludedByUrgentie(taakDto)
                && isNotExcludedById(taakDto);
    }

    private boolean isNotExcludedById(final TaakDto taakDto) {
        return id == null || id == taakDto.getId();
    }

    private boolean isNotExcludedByUrgentie(final TaakDto taakDto) {
        return urgentie == null || urgentie == taakDto.getUrgentie();
    }

    private boolean isNotExcludedByBehandelaar(final TaakDto taakDto) {
        return behandelaar == null || (
                taakDto.getBehandelaar() != null
                        && taakDto.getBehandelaar().equalsIgnoreCase(behandelaar)
        );
    }

    private boolean isNotExcludedByProces(final TaakDto taakDto) {
        return proces == null || (
                taakDto.getProces() != null
                        && taakDto.getProces().equalsIgnoreCase(proces)
        );
    }
}
