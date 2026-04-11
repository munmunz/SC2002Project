package statuses;

import core.Combatant;

public class ArcaneBlastStatus extends Status {
    private int bonusDamage;

    public ArcaneBlastStatus(Combatant target, int bonusDamage) {
        super(target);
        this.name = "Smoke Bombed";
        this.cooldown = Integer.MAX_VALUE; // Largest possible number of rounds
        this.bonusDamage = 10;
    }

    @Override
    public void apply() {
        // Example: Increase attack or damage for the target
        target.setAttack(target.getAttack() + bonusDamage);
        applied = true;
    }

    @Override
    public void remove() {
        // Remove the bonus
        target.setAttack(target.getAttack() - bonusDamage);
        applied = false;
    }
}
