package statuses;

import core.Combatant;

public abstract class Status {
    protected String name;
    protected int cooldown;
    protected boolean applied;
    protected Combatant target;

    public Status(Combatant target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isApplied() {
        return applied;
    }

    public void decrementStatus() {
        if (cooldown > 0) {
            cooldown--;
        }
        if (cooldown == 0) {
            remove();
        }
    }

    public abstract void apply();
    public abstract void remove();
}
