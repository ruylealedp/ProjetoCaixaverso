package ada.tech.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/petshop")
@Tag(name = "Petshop", description = "Endpoints utilizado para a interação com Petshop")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PethopResource {
    @GET
    public Response listaEstoque() {
        return Response.status(Response.Status.OK)
                .entity(null)
                .build();
    }
}
