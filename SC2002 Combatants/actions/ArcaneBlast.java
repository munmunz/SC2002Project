package actions;

import actions.exceptions.ActionOnCooldownException;
import core.BattleField;
import core.Combatant;
import core.Enemy;
import statuses.ArcaneBlastStatus;



public class ArcaneBlast extends SpecialAction{
    private static final String NAME = "Arcane Blast (Special)";
	public ArcaneBlast() {
		super(NAME);
	}

    public void execute() throws ActionOnCooldownException{
		if (this.cooldown > 0){
			throw new ActionOnCooldownException(this.cooldown);
		}
        int killCount = 0;


        for (Enemy enemy : BattleField.getAliveEnemies()) {
            int damage = Math.max(0, user.getAttack() - enemy.getDefense());
            int newHp = Math.max(0, enemy.getHealthPoints() - damage);
            enemy.setHealthPoints(newHp);
		
            if (newHp == 0) {
            	killCount += 1;
            }
		}

        for (int i = 0; i < killCount;i++) {
            ArcaneBlastStatus blastStatus = new ArcaneBlastStatus(user);
            user.applyStatus(blastStatus);
        }

        this.cooldown = 3;
       
	}
      
    public Action copy(){
        this.user = null;
        return this; // Pass by reference
    }
}
