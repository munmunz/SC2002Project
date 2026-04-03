import java.util.ArrayList;

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
    public void use(Player player, Combatant target, ArrayList<Combatant> enemies) {
    }
}
