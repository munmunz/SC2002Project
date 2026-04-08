package items;

import java.util.ArrayList;
import core.Combatant;
import core.Player;
public class SmokeBomb extends Item {
    public SmokeBomb() {
        super("Smoke Bomb");
    }

    @Override
    public void use(Player player, Combatant target, ArrayList<Combatant> enemies) {
    }
}
