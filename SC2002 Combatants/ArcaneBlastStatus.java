public class ArcaneBlastStatus extends Status {
    private Combatant target;
    private int bonusDamage;

    /**
     * Creates an ArcaneBlastStatus with a bonus to attack.
     * The bonus persists until end of level (represented by a long duration).
     * 
     * @param target The Wizard receiving the attack bonus
     * @param bonusDamage The amount of attack to add (typically 10 per kill)
     */
    public ArcaneBlastStatus(Combatant target, int bonusDamage) {
        super("ArcaneBlastStatus", 999); // High duration to represent "until end of level"
        this.target = target;
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void apply() {
        target.setAttack(target.getAttack() + bonusDamage);
        applied = true;
    }

    @Override
    public void remove() {
        target.setAttack(target.getAttack() - bonusDamage);
        applied = false;
    }
}