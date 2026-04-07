public class SmokeBombedStatus extends Status {
    private Combatant target;

    public SmokeBombedStatus(Combatant target) {
        super("SmokeBombedStatus", 2); // 2 turns: current + next
        this.target = target;
    }

    @Override
    public void apply() {
        // Could reduce accuracy, or mark as smoke bombed
        target.setSmokeBombed(true);
        applied = true;
    }

    @Override
    public void remove() {
        target.setSmokeBombed(false);
        applied = false;
    }
}
