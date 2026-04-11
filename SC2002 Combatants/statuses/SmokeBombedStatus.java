package statuses;

import core.Combatant;
public class SmokeBombedStatus extends Status {
    private Combatant target;
    private int attackReduction;

    public SmokeBombedStatus(Combatant target) {
        super("SmokeBombedStatus", 2); // lasts for 2 enemy actions
        this.target = target;
        this.attackReduction = 0;
    }

    @Override
    public void apply() {
        attackReduction = Math.max(0, target.getAttack());
        target.setAttack(target.getAttack() - attackReduction);
        applied = true;
    }

    @Override
    public void remove() {
        target.setAttack(target.getAttack() + attackReduction);
        applied = false;
    }
}



