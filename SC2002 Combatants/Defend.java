import java.util.ArrayList;
public class Defend implements Action {
	private Combatant user;
	
	public Defend(Combatant user) {
		this.user = user;
	}
	@Override
	public boolean isValid(Combatant user){
		// cannot defend again if defend status is still active during that round? unless its accumulative?
		ArrayList<Status> statusList = user.getStatus();
		for (int i = 0; i < statusList.size(); i++) {
			Status s = statusList.get(i);
			if (s instanceof DefendStatus) {
				return false;
			
			}
		}
		return true;

	}
		
	public void execute() {
		DefendStatus defendStatus = new DefendStatus(user);
		user.applyStatus(defendStatus);
	}


}
