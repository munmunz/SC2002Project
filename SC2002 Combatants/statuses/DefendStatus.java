package statuses;

import core.Combatant;

public class DefendStatus extends Status {
    private int bonusDefense;

    public DefendStatus(Combatant target) {
        super(target);
        this.name = "Defending";
        this.cooldown = 2; // This round and next round
        this.bonusDefense = 10; // As per defend ability
    }

    @Override
    public void apply() {
        target.setDefense(target.getDefense() + bonusDefense);
        applied = true;
    }

    @Override
    public void remove() {
        target.setDefense(target.getDefense() - bonusDefense);
        applied = false;
    }
}
