public class DefendStatus extends Status {
    private Combatant target;
    private int bonusDefense;

    public DefendStatus(Combatant target) {
        super("DefendStatus", 2); // 2 turns: current + next
        this.target = target;
        this.bonusDefense = 10;
    }

    @Override
    public void apply() {
        target.setDefense(target.getDefense() + bonusDefense);
        applied = true;
    }

    @Override
    public void remove() {
        target.setDefense(target.getDefense() - bonusDefense);
        applied = false;
    }
}
