package actions;

import core.Combatant;

public interface Targetable {
    public void setTarget(Combatant target);
    public Combatant getTarget();
}