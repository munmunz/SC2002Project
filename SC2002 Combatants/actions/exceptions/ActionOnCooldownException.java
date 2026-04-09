package actions.exceptions;

public class ActionOnCooldownException extends RuntimeException {
    public ActionOnCooldownException() {
        super("Action on cooldown!");
    }

    public ActionOnCooldownException(int duration) {
        super("Action on cooldown for " + duration + "more rounds!");
    }
}
