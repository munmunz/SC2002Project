package actions;

import core.Combatant;
public interface Action {
    boolean isValid(Combatant user);
    void execute();
}
