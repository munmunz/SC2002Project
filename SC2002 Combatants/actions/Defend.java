package actions;

import statuses.DefendStatus;

public class Defend extends Action {

    private static final String NAME = "Defend";
	public Defend() {
		super(NAME);
	}

    @Override
    public void execute() {
        DefendStatus defendStatus = new DefendStatus(user);
        user.applyStatus(defendStatus);
    }

    public Action copy(){
        Action copy = new Defend();
        return copy;
    }
}
