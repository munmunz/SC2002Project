package actions;

import statuses.Stun;
import core.Combatant;
import actions.exceptions.*;

public class ShieldBash extends SpecialAction implements Targetable{
	private Combatant target;
	private int cooldown;
	
    private static final String NAME = "Shield Bash (Special)";
	public ShieldBash() {
		super(NAME);
		target = null;
	}
	
	public String execute() throws MissingTargetException, ActionOnCooldownException{
		if (this.cooldown > 0){
			throw new ActionOnCooldownException(this.cooldown);
		}

		if (target == null){
			throw new MissingTargetException();
		}

        // Deal BasicAttack damage
		int originalHP = target.getHealthPoints();
        int damage = Math.max(0, user.getAttack() - target.getDefense());
        int newHP = Math.max(0, originalHP - damage);
        target.setHealthPoints(newHP);

       
        if (newHP > 0) {
            Stun stun = new Stun(target);
            target.applyStatus(stun);
        }
    

        // Set cooldown (3 turns including current)
        this.cooldown = 3;

        return user.getName() + " used Shield Bash on " + target.getName() + " (HP: " + originalHP + " -> " + newHP + ")" + "\n" + target.getName() + "is stunned";
    }

	public Action copy(){
		this.target = null;
		this.user = null;
        return this; // Pass by reference
    }

	public void setTarget(Combatant target){
        this.target = target;
    }

	public Combatant getTarget(){
		return this.target;
	}

	public int getCooldown(){
		return this.cooldown;
	}

	public void setCooldown(int i){
		this.cooldown = i;
	}
}








