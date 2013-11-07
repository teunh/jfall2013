package nl.jug.jfall;

import nl.jug.jfall.dto.TaakDto;
import nl.jug.jfall.dto.Urgentie;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/task")
public final class TaakService implements TaakResource {

    private final TakenRepository taken;

    @Context
    private HttpServletRequest request;

    /**
     * Default constructor voor JAX-RS.
     */
    public TaakService() {
        taken = TakenDatabaseFake.INSTANCE;
    }

    /**
     * Maakt een nieuwe instantie van de taakservice aan.
     *
     * @param taken de repository met taken.
     */
    TaakService(final TakenRepository taken) {
        this.taken = taken;
    }

    /**
     * Get de taak op basis van id.
     *
     * @param id het unieke kenmerk van de taak.
     * @return de taak instantie.
     */
    public TaakDto getTaakById(final long id) {
        System.out.println("getTaakById");

        return taken.getById(id);
    }

    /**
     * Zoekt taken op basis van een aantal zoekvelden.
     *
     * @param proces        het proces waartoe de taak moet behoren.
     * @param behandelaar de persoon waaraan de taak is toegewezen.
     * @param urgentie      de urgentie van de taak.
     * @return een collectie met taken.
     */
    public Collection<TaakDto> searchTaken(final String proces,
                                           final String behandelaar,

                                           final Urgentie urgentie) {

        //if (request.isUserInRole("admin")) {
        TaakSearchCriteria criteria = new TaakSearchCriteria();
        criteria.setProces(proces);
        criteria.setBehandelaar(behandelaar);
        criteria.setUrgentie(urgentie);

        return taken.search(criteria);
        //}
        //throw new WebApplicationException(Response.Status.FORBIDDEN);
    }


}
