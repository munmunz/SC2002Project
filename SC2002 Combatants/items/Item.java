package items;

import java.util.ArrayList;
import core.Combatant;
import core.Player;
public abstract class Item {
    private final String type;

    public Item(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void use(Player player, Combatant target, ArrayList<Combatant> enemies);
}
