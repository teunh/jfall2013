package nl.jug.jfall;

import nl.jug.jfall.dto.TaakDto;
import nl.jug.jfall.dto.Urgentie;

import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public interface TaakResource {

    /**
     * GET: /task/{id}.
     *
     * @param id het unieke kenmerk van de taak.
     * @return een taak instantie.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    TaakDto getTaakById(@PathParam("id") long id);

    /**
     * GET: /task?process={proces}&assignedTo={toegewezenAanPersoon}&urgency={urgentie}.
     *
     * @param proces        het proces waartoe de taak moet behoren.
     * @param toegewezenAan de persoon waaraan de taak is toegewezen.
     * @param urgentie      de urgentie van de taak.
     * @return een verzameling taken.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Collection<TaakDto> searchTaken(@QueryParam("process") String proces,
                                    @QueryParam("assignedTo") String toegewezenAan,
                                    @QueryParam("urgency") Urgentie urgentie);


}
