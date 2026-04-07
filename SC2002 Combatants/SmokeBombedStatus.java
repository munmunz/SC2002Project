public class SmokeBombedStatus extends Status {
    private Combatant target;

    public SmokeBombedStatus(Combatant target) {
        super("SmokeBombedStatus", 2); // Lasts 2 turns (current + next)
        this.target = target;
    }

    @Override
    public void apply() {
        // Being in the status list means smoke bomb protection is active
        applied = true;
    }

    @Override
    public void remove() {
        applied = false;
    }
}