package ada.tech.exception.mapper;

import ada.tech.dto.ErrorResponseDTO;
import ada.tech.exception.PetNaoEncontradoException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class PetNaoEncontradoHandler implements ExceptionMapper<PetNaoEncontradoException> {
    @Override
    public Response toResponse(PetNaoEncontradoException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(ErrorResponseDTO.builder()
                        .codigoHttp(404)
                        .mensagem(e.getMessage())
                        .build())
                .build();
    }
}