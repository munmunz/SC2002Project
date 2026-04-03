<<<<<<< Updated upstream
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
<<<<<<< Updated upstream
    public void use(Player player, Combatant target, ArrayList<Combatant> enemies) {
=======
    public void use(Player player, Combatant target) {
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            player.setSkillCooldown(0);
            Action freeSkill = new ArcaneBlast(player, enemies);
=======
            ArrayList<Combatant> singleTargetList = new ArrayList<>();
            if (target != null) {
                singleTargetList.add(target);
            }

            player.setSkillCooldown(0);
            Action freeSkill = new ArcaneBlast(player, singleTargetList);
>>>>>>> Stashed changes
            if (freeSkill.isValid(player)) {
                freeSkill.execute();
            }
            player.setSkillCooldown(originalCooldown);
        }
=======
public class Powerstone extends Item {

    Powerstone() {
        super("Powerstone");
    }

    @Override
    public void use(Player player, Combatant target) {
        
>>>>>>> Stashed changes
    }
}
