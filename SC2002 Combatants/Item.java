<<<<<<< Updated upstream
import java.util.ArrayList;

public interface Item {
    String getType();
    void use(Player player, Combatant target, ArrayList<Combatant> enemies);
=======
public abstract class Item {
    private final String type;

    Item(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void use(Player player, Combatant target);
>>>>>>> Stashed changes
}
