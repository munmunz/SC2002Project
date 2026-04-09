package actions;

import core.Combatant;
import statuses.DefendStatus;

public class Defend extends Action {

    private static final String NAME = "Defend";
	public Defend() {
		super(NAME);
	}

    @Override
    public boolean isValid(Combatant user) {   // return True instead 
        return true;
    }

    @Override
    public void execute() {
        DefendStatus defendStatus = new DefendStatus(user);
        user.applyStatus(defendStatus);
        System.out.println(user.getName() + " takes a defensive stance! (+" + 10 + " Defense)");
    }

    public Action copy(){
        Action copy = new Defend();
        return copy;
    }
}
