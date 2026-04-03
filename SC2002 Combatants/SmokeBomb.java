<<<<<<< Updated upstream
import java.util.ArrayList;

=======
>>>>>>> Stashed changes
public class SmokeBomb implements Item {
    private final String type;

    SmokeBomb() {
        this.type = "Smoke Bomb";
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
    }
}
