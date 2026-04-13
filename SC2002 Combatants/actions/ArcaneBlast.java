package actions;

import actions.exceptions.ActionOnCooldownException;
import core.Combatant;
import java.util.ArrayList;
import statuses.ArcaneBlastStatus;



public class ArcaneBlast extends SpecialAction{
	private ArrayList<Combatant> enemies;  // all alive enemies (not sure if implemented yet)
	
    private static final String NAME = "Arcane Blast (Special)";
	public ArcaneBlast() {
		super(NAME);
	}

    public void execute() throws ActionOnCooldownException{
		if (this.cooldown > 0){
			throw new ActionOnCooldownException(this.cooldown);
		}
        boolean killedEnemy = false;


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
                killedEnemy = true;
            	System.out.println(enemy.getName() + " was defeated by Arcane Blast!");
        
            }
		}

        if (killedEnemy) {
            ArcaneBlastStatus blastStatus = new ArcaneBlastStatus(user, 10);
            user.applyStatus(blastStatus);
        }

        this.cooldown = 3;
       
	}
      
    public Action copy(){
        this.user = null;
        return this; // Pass by reference
    }
}
