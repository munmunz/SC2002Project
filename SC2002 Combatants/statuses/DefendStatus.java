package statuses;

import core.Combatant;
public class DefendStatus extends Status {
    private Combatant target;
    private final int bonusDefense;

    public DefendStatus(Combatant target) {
        super("DefendStatus", 2); // 1 turn defend by default
        this.target = target;
        this.bonusDefense = 10; // As per sticky note in UML
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
