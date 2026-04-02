import java.util.ArrayList;

public class ArcaneBlast implements Action {
	private Combatant user;   // should be a Wizard 
	private ArrayList<Combatant> enemies;  // all alive enemies (not sure if implemented yet)
	
	public ArcaneBlast(Combatant user, ArrayList<Combatant> enemies) {
		this.user = user;
		this.enemies = enemies; 
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
        
     // At least one enemy must be alive
      for (int i = 0; i < enemies.size(); i++) {
    	  if (e.getHealthPoints()> 0)
    		  return true;
      }
      return false;
	}
	
	public void execute() {
		int killCount = 0;
		
		for (int i = 0; i < enemies.size(); i++) {
		    Combatant enemy = enemies.get(i);
			if (enemy.getHealthPoints() <= 0)
				continue  // if already dead, skip
				
			int damage = Math.max(0, user.getAttack() - enemy.getDefense());
            int newHp = Math.max(0, enemy.getHealthPoints() - damage);
            enemy.setHealthPoints(newHp);
            System.out.println(user.getName() + " blasts " + enemy.getName()
                    + " for " + damage + " damage! (HP: " + newHp + ")");
		
            if (newHp == 0) {
            	killCount ++ 
            	System.out.println(enemy.getName() + " was defeated by Arcane Blast!")
        
            }
		}
		
		if (killCount > 0) {
		    ArcaneBlastStatus arcaneStatus = new ArcaneBlastStatus(user, killCount);
		    user.applyStatus(arcaneStatus);
		}
		
		  // Set cooldown (3 turns including current)
        ((Player) user).setSkillCooldown(3);
       
	}
      
       
}