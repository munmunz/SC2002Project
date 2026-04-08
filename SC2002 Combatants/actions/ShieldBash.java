package actions;

import statuses.Stun;
import core.Combatant;
import core.Player;
public class ShieldBash implements Action {
	private Combatant user; // should be Warrior
	private Combatant target;

	
	
	public ShieldBash(Combatant user, Combatant target) {
		this.user = user;
		this.target = target;
	}
	
	public boolean isValid(Combatant user) {
		if (!(user instanceof Player))
			return false;
		
		Player player = (Player) user;
		
		// Cooldown must be 0 (ready)
		
		if (player.getSkillCooldown() > 0) {
			System.out.println("ShieldBash is on cooldown! (" + player.getSkillCooldown() + " turns remaining)");
			return false;
		}
		
		// Target must be alive
		return target != null && target.getHealthPoints() > 0;
		
	}
	
	 public void execute() {
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
        ((Player) user).setSkillCooldown(3);
        
    }
}








