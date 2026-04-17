package actions;

import actions.exceptions.MissingTargetException;
import core.Combatant;

public class BasicAttack extends Action implements Targetable {
    private Combatant target;

    private static final String NAME = "Basic Attack";
	public BasicAttack() {
		super(NAME);
        target = null;
	}

    public String execute() throws MissingTargetException{
        if (target == null){
            throw new MissingTargetException();
        }

        int originalHP = target.getHealthPoints();
        int damage = Math.max(0, user.getAttack() - target.getDefense());
        int newHP = Math.max(0, originalHP - damage);

        target.setHealthPoints(newHP);

        return user.getName() + " used Basic Attack on " + target.getName() + " (HP: " + originalHP + " → " + newHP + ")";
    }

    public Action copy(){
        Action copy = new BasicAttack();
        return copy;
    }

    public void setTarget(Combatant target){
        this.target = target;
    }

	public Combatant getTarget(){
		return this.target;
	}
}
