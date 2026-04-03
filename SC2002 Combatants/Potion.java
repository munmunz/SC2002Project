import java.util.ArrayList;

public class Potion implements Item {
    private final String type;
    private final int healAmount;

    Potion() {
        this.type = "Potion";
        this.healAmount = 100;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void use(Player player, Combatant target, ArrayList<Combatant> enemies) {
        int newHealthPoints = player.getHealthPoints() + healAmount;
        if (newHealthPoints > player.getMaxHealthPoints()) {
            newHealthPoints = player.getMaxHealthPoints();
        }
        player.setHealthPoints(newHealthPoints);
    }
}

