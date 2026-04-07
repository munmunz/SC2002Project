public abstract class Status {
    protected String name;
    protected int duration;
    protected boolean applied;

    public Status(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.applied = false;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isApplied() {
        return applied;
    }

    public boolean isExpired() {
        return duration <= 0;
    }

    public void decrementDuration() {
        if (duration > 0) {
            duration--;
        }
    }

    public abstract void apply();
    public abstract void remove();
}
