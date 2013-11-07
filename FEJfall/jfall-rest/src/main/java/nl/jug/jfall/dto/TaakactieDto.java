package nl.jug.jfall.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Taakactie")
public final class TaakactieDto {

    private Collection<String> behandelaars;
    private String taakactieType;

    public TaakactieDto() {
        super();
    }

    public TaakactieDto(final String taakactieType) {
        this.taakactieType = taakactieType;
        this.behandelaars = new ArrayList<>();
    }

    /***
     * Get het type van de taakactie.
     * @return het type.
     */
    public String getTaakactieType() {
        return taakactieType;
    }

    /**
     * Set het type taakactie.
     * @param taakactieType het type taakactie.
     */
    @XmlElement(name = "type")
    public void setTaakactieType(final String taakactieType) {
        this.taakactieType = taakactieType;
    }

    /**
     * Get alle (mogelijke) behandelaars.
     * @return de lijst met behandelaars.
     */
    public Collection<String> getBehandelaars() {
        return behandelaars;
    }

    /**
     * Set de lijst met behandelaars.
     * @param behandelaars de lijst met behandelaars.
     */
    public void setBehandelaars(final Collection<String> behandelaars) {
        this.behandelaars = behandelaars;
    }
}
