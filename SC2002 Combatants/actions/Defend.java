package actions;

import core.Combatant;
import statuses.DefendStatus;

public class Defend implements Action {
    private Combatant user;

    public Defend(Combatant user) {
        this.user = user;
    }

    @Override
    public boolean isValid(Combatant user) {   // return True instead 
        return true;
    }

    @Override
    public void execute() {
        DefendStatus defendStatus = new DefendStatus(user);
        user.applyStatus(defendStatus);
        defendStatus.apply();
        System.out.println(user.getName() + " takes a defensive stance! (+" + 10 + " Defense)");
    }
}
