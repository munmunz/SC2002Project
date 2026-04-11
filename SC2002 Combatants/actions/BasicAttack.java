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

    public void execute() throws MissingTargetException{
        if (target == null){
            throw new MissingTargetException();
        }

        int damage = Math.max(0, user.getAttack() - target.getDefense());
        int newHp = Math.max(0, target.getHealthPoints() - damage);

        target.setHealthPoints(newHp);
        System.out.println(user.getName() + " attacks " + target.getName() + " for " + damage + " damage!");
        System.out.println(target.getName() + " HP: " + newHp);
    }

    public Action copy(){
        Action copy = new BasicAttack();
        return copy;
    }

    public void setTarget(Combatant target){
        this.target = target;
    }
}
