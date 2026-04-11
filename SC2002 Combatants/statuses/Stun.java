package statuses;

import core.Combatant;

public class Stun extends Status {
    public Stun(Combatant target) {
        super(target);
        this.name = "Stun";
        this.cooldown = 2; // This round and next round
    }

    @Override
    public void apply() {
        // Set movesAvailable to negaive so adding 1 won't allow them to move
        target.setMovesAvailable(-99);
        applied = true;
    }

    @Override
    public void remove() {
        target.setMovesAvailable(0); // Start of next round will add 1
        applied = false;
    }
}
