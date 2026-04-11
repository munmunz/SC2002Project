package statuses;

import core.Combatant;
public class SmokeBombedStatus extends Status {
    private int orginalAttack;
    public SmokeBombedStatus(Combatant target) {
        super(target);
        this.name = "Smoke Bombed";
        this.cooldown = 2; // This round and next round        
    }

    @Override
    public void apply() {
        orginalAttack = target.getAttack();
        target.setAttack(-99999); // Actions account for negative attack, and will instead deal 0 damage
        applied = true;
    }

    @Override
    public void remove() {
        target.setAttack(orginalAttack); // Restore original attack
        applied = false;
    }
}



