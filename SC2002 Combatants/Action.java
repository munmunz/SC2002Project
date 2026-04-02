
public interface Action {
    boolean isValid(Combatant user);
    void execute();
}
