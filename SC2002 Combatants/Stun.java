public class Stun extends Status {
    private Combatant target;

    public Stun(Combatant target) {
        super("Stun", 1); // 1 turn stun by default
        this.target = target;
    }

    @Override
    public void apply() {
        // Example: Set movesAvailable to 0 for the turn
        target.setMovesAvailable(0);
        applied = true;
    }

    @Override
    public void remove() {
        // Example: Restore movesAvailable (if you track the original value, restore it)
        // For now, just mark as not applied
        applied = false;
    }
}