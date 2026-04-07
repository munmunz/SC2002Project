public class Stun extends Status {
    private Combatant target;

    public Stun(Combatant target) {
        super("Stun", 2); // 2 turns: current + next
        this.target = target;
    }

    @Override
    public void apply() {
        // Prevent target from acting
        target.setStunned(true);
        applied = true;
    }

    @Override
    public void remove() {
        target.setStunned(false);
        applied = false;
    }
}
