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
	
	public void execute() throws MissingTargetException, ActionOnCooldownException{
		if (this.cooldown > 0){
			throw new ActionOnCooldownException(this.cooldown);
		}

		if (target == null){
			throw new MissingTargetException();
		}

        // Deal BasicAttack damage
        int damage = Math.max(0, user.getAttack() - target.getDefense());
        int newHp = Math.max(0, target.getHealthPoints() - damage);
        target.setHealthPoints(newHp);
        System.out.println(user.getName() + " uses Shield Bash on " + target.getName()  //placeholder for battle engine dialogue
                + " for " + damage + " damage!");

       
        if (newHp > 0) {
            Stun stun = new Stun(target);
            target.applyStatus(stun);
            
            System.out.println(target.getName() + " is stunned!");
        
        }
    

        // Set cooldown (3 turns including current)
        this.cooldown = 3;
        
    }

	public Action copy(){
		this.target = null;
		this.user = null;
        return this; // Pass by reference
    }

	public void setTarget(Combatant target){
        this.target = target;
    }

	public int getCooldown(){
		return this.cooldown;
	}

	public void setCooldown(int i){
		this.cooldown = i;
	}
}








