package actions;

import core.Combatant;
public class Defend implements Action {
	private Combatant user;
	
	public Defend(Combatant user) {
		this.user = user;
	}

	public boolean isValid(Combatant user) {
		return user != null && user.getHealthPoints() > 0;
	}
		
	public void execute() {
		// Defend status application will be added once the status system exists.
	}
}
