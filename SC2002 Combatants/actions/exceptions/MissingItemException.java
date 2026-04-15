package actions.exceptions;

public class MissingItemException extends RuntimeException {
    public MissingItemException() {
        super("Action needs a item!");
    }
}

