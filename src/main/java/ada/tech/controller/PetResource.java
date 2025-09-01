package ada.tech.controller;

import ada.tech.dto.PetDTO;
import ada.tech.services.PetService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
    @Inject
    PetService petService;

    @GET
    @Operation(summary = "Lista pets", description = "Lista todos os pets cadastrados no petshop")
    public Response getPets() {
        return Response.status(Response.Status.OK)
                .entity(petService.listaPet())
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar pet por ID", description = "Retorna os dados de um pet específico pelo seu identificador")
    public Response getPetsById(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK)
                .entity(petService.buscaPetPorID(id))
                .build();
    }

    @POST
    @Transactional
    @Operation(summary = "Cria Pet", description = "Adiciona o Pet no cadastro do Petshop")
    public Response addPet(PetDTO petDTO) {
        return Response.status(Response.Status.OK)
                .entity(petService.criaPet(petDTO))
                .build();
    }

    @PUT
    @Transactional
    @Path("{id}")
    @Operation(summary = "Atualiza Pet", description = "Atualiza o Pet no cadastro do Petshop por ID")
    public Response updatePet(@PathParam("id") Long id, PetDTO petDTO) {
        return Response.status(Response.Status.OK)
                .entity(petService.updatePet(id,petDTO))
                .build();
    }

    @PATCH
    @Transactional
    @Path("{id}")
    @Operation(summary = "Atualiza Parcialmente o Pet", description = "Atualiza o Pet no cadastro do Petshop por ID de forma parcial")
    public Response partialUpdatePet(@PathParam("id") Long id, PetDTO petDTO) {
        return Response.status(Response.Status.OK)
                .entity(petService.patchPet(id,petDTO))
                .build();
    }
}
