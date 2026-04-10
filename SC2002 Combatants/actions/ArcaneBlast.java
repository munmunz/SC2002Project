package actions;

import statuses.ArcaneBlastStatus;
import java.util.ArrayList;
import core.Combatant;
import core.Player;
import actions.exceptions.ActionOnCooldownException;



public class ArcaneBlast extends Action {
	private ArrayList<Combatant> enemies;  // all alive enemies (not sure if implemented yet)
	
    private static final String NAME = "Arcane Blast (Special)";
	public ArcaneBlast() {
		super(NAME);
	}
	
	public boolean isValid(Combatant user) {
        if (!(user instanceof Player)) 
        	return false;
        Player player = (Player) user;

        // Cooldown must be 0 (ready)
        if (player.getSkillCooldown() > 0) {
            System.out.println("Arcane Blast is on cooldown! (" + player.getSkillCooldown() + " turns remaining)");
            return false;
        }

        for (int i = 0; i < enemies.size(); i++) {  // will update when logic for 'all enemies alive' logic in battle engine?
            Combatant enemy = enemies.get(i);
            if (enemy.getHealthPoints() > 0) {
                return true;
            }
        }
        return false;
    }

    public void execute() throws ActionOnCooldownException{
		if (((Player) user).getSkillCooldown() > 0){
			throw new ActionOnCooldownException(((Player) user).getSkillCooldown());
		}

        ArcaneBlastStatus blastStatus = new ArcaneBlastStatus(user, 10);
        user.applyStatus(blastStatus);


        for (int i = 0; i < enemies.size(); i++) { // will update when logic for 'all enemies alive' logic in battle engine?
            Combatant enemy = enemies.get(i);
            if (enemy.getHealthPoints() <= 0) {
                continue;
            }

            int damage = Math.max(0, user.getAttack() - enemy.getDefense());
            int newHp = Math.max(0, enemy.getHealthPoints() - damage);
            enemy.setHealthPoints(newHp);
            System.out.println(user.getName() + " blasts " + enemy.getName()
                    + " for " + damage + " damage! (HP: " + newHp + ")");
		
            if (newHp == 0) {
            	// killCount ++;
            	System.out.println(enemy.getName() + " was defeated by Arcane Blast!");
        
            }
		}

        ((Player) user).setSkillCooldown(3);
       
	}
      
    public Action copy(){
        Action copy = new ArcaneBlast();
        return copy;
    }
}