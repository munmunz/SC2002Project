public class Defend implements Action {
	private Combatant user;
	
	public Defend(Combatant user) {
		this.user = user;
	}

	public boolean isValid(Combatant user) {
		return user != null && user.getHealthPoints() > 0;
	}

	public void execute() {
		// Apply DefendStatus to user
		DefendStatus defendStatus = new DefendStatus(user);
		user.applyStatus(defendStatus);
		System.out.println(user.getName() + " takes a defensive stance! Defense increased by 10 for 2 turns.");
	}
}
