package actions;

import statuses.DefendStatus;

public class Defend extends Action {

    private static final String NAME = "Defend";
	public Defend() {
		super(NAME);
	}

    @Override
    public String execute() {
        DefendStatus defendStatus = new DefendStatus(user);
        user.applyStatus(defendStatus);

        return user.getName() + " used Defend";
    }

    public Action copy(){
        Action copy = new Defend();
        return copy;
    }
}
