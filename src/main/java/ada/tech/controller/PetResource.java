package ada.tech.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/pet")
@Tag(name = "Pet", description = "Endpoints utilizado para a gerenciar Pets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PetResource {
    @GET
    @Operation(summary = "Lista pets", description = "Lista todos os pets cadastrados no petshop")
    public Response getPets() {
        return Response.status(Response.Status.OK)
                .entity(null)
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar pet por ID", description = "Retorna os dados de um pet específico pelo seu identificador")
    public Response getPetsById() {
        return Response.status(Response.Status.OK)
                .entity(null)
                .build();
    }

    @POST
    @Operation(summary = "Cria Pet", description = "Adiciona o Pet no cadastro do Petshop")
    public Response addPet() {
        return Response.status(Response.Status.OK)
                .entity(null)
                .build();
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Atualiza Pet", description = "Atualiza o Pet no cadastro do Petshop por ID")
    public Response updatePet() {
        return Response.status(Response.Status.OK)
                .entity(null)
                .build();
    }

    @PATCH
    @Path("{id}")
    @Operation(summary = "Atualiza Parcialmente o Pet", description = "Atualiza o Pet no cadastro do Petshop por ID de forma parcial")
    public Response partialUpdatePet() {
        return Response.status(Response.Status.OK)
                .entity(null)
                .build();
    }
}
