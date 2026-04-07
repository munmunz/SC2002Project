public class ArcaneBlastStatus extends Status {
    private Combatant target;
    private int bonusDamage;

    public ArcaneBlastStatus(Combatant target, int bonusDamage) {
        super("ArcaneBlastStatus", Integer.MAX_VALUE); // lasts until end of level
        this.target = target;
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void apply() {
        // Increase attack for the target (Wizard)
        target.setAttack(target.getAttack() + bonusDamage);
        applied = true;
    }

    @Override
    public void remove() {
        // Remove the bonus at end of level
        target.setAttack(target.getAttack() - bonusDamage);
        applied = false;
    }
}
