package actions;

import java.util.ArrayList;
import core.Combatant;
import core.Player;
public class ArcaneBlast implements Action {
    private Combatant user;
    private ArrayList<Combatant> enemies;

    public ArcaneBlast(Combatant user, ArrayList<Combatant> enemies) {
        this.user = user;
        this.enemies = enemies;
    }

    public boolean isValid(Combatant user) {
        if (!(user instanceof Player)) {
            return false;
        }

        Player player = (Player) user;

        if (player.getSkillCooldown() > 0) {
            System.out.println("Arcane Blast is on cooldown! (" + player.getSkillCooldown() + " turns remaining)");
            return false;
        }

        for (int i = 0; i < enemies.size(); i++) {
            Combatant enemy = enemies.get(i);
            if (enemy.getHealthPoints() > 0) {
                return true;
            }
        }
        return false;
    }

    public void execute() {
        for (int i = 0; i < enemies.size(); i++) {
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
                System.out.println(enemy.getName() + " was defeated by Arcane Blast!");
            }
        }

        ((Player) user).setSkillCooldown(3);
    }
}
