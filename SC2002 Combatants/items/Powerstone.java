package items;

import actions.ArcaneBlast;
import actions.ShieldBash;
import core.BattleField;
import core.Enemy;
import characters.Warrior;
import characters.Wizard;
import core.Player;
import ui.PlayerUI;
public class Powerstone extends Item {
    public Powerstone() {
        super("Power Stone");
    }

    @Override
    public void use(Player player) {
        int originalCooldown = player.getSkillCooldown();
        player.setSkillCooldown(0);

        if (player instanceof Warrior) {
            ShieldBash freeSkill = new ShieldBash();
            freeSkill.setUser(player);

            if (BattleField.getAliveEnemies().isEmpty()) {
                player.setSkillCooldown(originalCooldown);
                used = true;
                return;
            }

            Enemy target = PlayerUI.chooseTarget(BattleField.getAliveEnemies());
            freeSkill.setTarget(target);
            if (freeSkill.isValid(player)) {
                freeSkill.execute();
            }
            player.setSkillCooldown(originalCooldown);
        } else if (player instanceof Wizard) {
            ArcaneBlast freeSkill = new ArcaneBlast();
            freeSkill.setUser(player);
            if (freeSkill.isValid(player)) {
                freeSkill.execute();
            }
            player.setSkillCooldown(originalCooldown);
        }

        used = true;
    }
}
