import java.util.ArrayList;

public interface Item {
    String getType();
    void use(Player player, Combatant target, ArrayList<Combatant> enemies);
}
