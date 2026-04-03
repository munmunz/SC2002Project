import java.util.ArrayList;

public class Powerstone implements Item {
    private final String type;

    Powerstone() {
        this.type = "Power Stone";
    }

    @Override
    public String getType() {
        return type;
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
    }
}

