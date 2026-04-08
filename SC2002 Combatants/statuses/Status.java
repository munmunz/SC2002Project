package statuses;
public abstract class Status {
    protected String name;
    protected int cooldown;
    protected boolean applied;

    public Status(String name, int cooldown) {
        this.name = name;
        this.cooldown = cooldown;
        this.applied = false;
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

    public abstract void apply();
    public abstract void remove();
}
