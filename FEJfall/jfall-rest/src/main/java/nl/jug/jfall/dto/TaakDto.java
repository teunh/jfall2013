package nl.jug.jfall.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Taak")
public final class TaakDto {

    private String titel;
    private TaakactieDto taakactie;
    private Date startDatum;
    private String behandelaar;
    private String proces;
    private String status;
    private Urgentie urgentie;
    private long id = 0;

    /**
     * Default constructor voor JAXB.
     */
    public TaakDto() {

    }

    /**
     * Maakt een nieuwe taak.
     *
     * @param id          de unieke sleutel van de taak.
     * @param titel       de titel van de taak.
     * @param startDatum  de startdatum van de taak.
     * @param behandelaar de persoon die de taak in behandeling heeft.
     * @param proces      het proces waartoe de taak behoort.
     * @param status      de status van de taak.
     * @param urgentie    de urgentie an de taak.
     * @param taakactie   de actie die is uit te voeren op de taak.
     */
    public TaakDto(final long id,
                   final String titel,
                   final Date startDatum,
                   final String behandelaar,
                   final String proces,
                   final String status,
                   final Urgentie urgentie,
                   final TaakactieDto taakactie) {
        this.id = id;
        this.titel = titel;
        this.startDatum = (Date) startDatum.clone();
        this.behandelaar = behandelaar;
        this.proces = proces;
        this.status = status;
        this.urgentie = urgentie;
        this.taakactie = taakactie;
    }

    /**
     * Get het id van de taak.
     *
     * @return het id van de taak.
     */
    public long getId() {
        return id;
    }

    /**
     * Set het id van de taak.
     *
     * @param id het id van de taak
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * Get de titel van de taak.
     *
     * @return de titel van de taak
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Set de titel van de taak.
     *
     * @param titel de titel van de taak.
     */
    public void setTitel(final String titel) {
        this.titel = titel;
    }

    /**
     * Get de titel van de taak.
     *
     * @return de startdatum van de taak.
     */
    public Date getStartDatum() {
        return (Date) startDatum.clone();
    }

    /**
     * Set de startdatum van de taak.
     *
     * @param startDatum de startdatum van de taak.
     */
    public void setStartDatum(final Date startDatum) {
        this.startDatum = (Date) startDatum.clone();
    }

    /**
     * Get de persoon waaraan de taak is toegewezen.
     *
     * @return de toegewezen persoon.
     */
    public String getBehandelaar() {
        return behandelaar;
    }

    /**
     * Set de toegewezen persoon.
     *
     * @param behandelaar de toegewezen persoon.
     */
    public void setBehandelaar(final String behandelaar) {
        this.behandelaar = behandelaar;
    }

    /**
     * Get de naam van het proces.
     * @return de naam van het proces.
     */
    public String getProces() {
        return proces;
    }

    /**
     * Set de naam van het proces.
     *
     * @param proces de naam van het proces.
     */
    public void setProces(final String proces) {
        this.proces = proces;
    }

    /**
     * Get de status van het proces.
     *
     * @return de status van de taak.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set de status van de taak.
     *
     * @param status de status van de taak.
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Get de urgentie van de taak.
     *
     * @return de urgentie van de taak.
     */
    public Urgentie getUrgentie() {
        return urgentie;
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
     * Get de taakactie.
     *
     * @return de taak actie.
     */
    public TaakactieDto getTaakactie() {
        return taakactie;
    }

    /**
     * Set de taakactie.
     *
     * @param taakactie de taakactie.
     */
    public void setTaakactie(final TaakactieDto taakactie) {
        this.taakactie = taakactie;
    }
}
