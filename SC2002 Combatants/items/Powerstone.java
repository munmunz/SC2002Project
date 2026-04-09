package items;

import java.util.ArrayList;
import actions.Action;
import actions.ArcaneBlast;
import actions.ShieldBash;
import characters.Warrior;
import characters.Wizard;
import core.Combatant;
import core.Player;
public class Powerstone extends Item {
    public Powerstone() {
        super("Power Stone");
    }

    @Override
    public void use(Player player, Combatant target, ArrayList<Combatant> enemies) {
        int originalCooldown = player.getSkillCooldown();

        if (player instanceof Warrior) {
            player.setSkillCooldown(0);
            Action freeSkill = new ShieldBash(player, target);
            if (freeSkill.isValid(player)) {
                freeSkill.execute();
            }
            player.setSkillCooldown(originalCooldown);
            return;
        }

        if (player instanceof Wizard) {
            player.setSkillCooldown(0);
            Action freeSkill = new ArcaneBlast(player, enemies);
            if (freeSkill.isValid(player)) {
                freeSkill.execute();
            }
            player.setSkillCooldown(originalCooldown);
        }

        used = true;
    }
}
