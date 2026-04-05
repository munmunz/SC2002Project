public class SmokeBombedStatus extends Status {
    private Combatant target;

    public SmokeBombedStatus(Combatant target) {
        super("SmokeBombedStatus", 1); // 1 turn by default
        this.target = target;
    }

    @Override
    public void apply() {
        // Example: Could reduce accuracy, or mark as smoke bombed
        applied = true;
    }

    @Override
    public void remove() {
        // Remove smoke bomb effect
        applied = false;
    }
}
