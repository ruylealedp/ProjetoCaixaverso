package ada.tech.exception;

public class PetNaoEncontradoException extends RuntimeException{
    public PetNaoEncontradoException(String message) {
        super(message);
    }
}
