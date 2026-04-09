package actions.exceptions;

public class MissingTargetException extends RuntimeException {
    public MissingTargetException() {
        super("Action needs a target!");
    }
}
