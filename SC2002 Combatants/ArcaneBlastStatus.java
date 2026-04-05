public class ArcaneBlastStatus extends Status {
    private Combatant target;
    private int bonusDamage;

    public ArcaneBlastStatus(Combatant target, int bonusDamage) {
        super("ArcaneBlastStatus", 0);
        this.target = target;
        this.bonusDamage = bonusDamage;
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
