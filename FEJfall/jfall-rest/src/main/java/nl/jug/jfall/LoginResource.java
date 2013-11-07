package nl.jug.jfall;

import nl.jug.jfall.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Resource t.b.v. inloggen.
 */
@Path("/login")
public class LoginResource {

    @Context HttpServletRequest request;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        try {
            request.login(user.getUsername(), user.getPassword());
        } catch (ServletException e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        return Response.ok().build();
    }
}
