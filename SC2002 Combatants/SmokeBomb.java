import java.util.ArrayList;

public class SmokeBomb extends Item {

    SmokeBomb() {
        super("Smoke Bomb");
    }

    @Override
    public void use(Player player, Combatant target, ArrayList<Combatant> enemies) {
        // Apply SmokeBombInvulnerability to the player
        SmokeBombInvulnerability smokeEffect = new SmokeBombInvulnerability(player);
        player.applyStatus(smokeEffect);
        System.out.println(player.getName() + " is protected by smoke! Enemy attacks will deal 0 damage for 2 turns.");
    }
}
