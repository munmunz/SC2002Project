package items;

import core.Player;
public class Potion extends Item {
    private final int healAmount;
    public Potion() {
        super("Potion");
        this.healAmount = 100;
    }

    @Override
    public void use(Player player) {
        int newHealthPoints = player.getHealthPoints() + healAmount;
        if (newHealthPoints > player.getMaxHealthPoints()) {
            newHealthPoints = player.getMaxHealthPoints();
        }
        player.setHealthPoints(newHealthPoints);

        used = true;
    }

    public Item copy(){
        return new Potion();
    }
}
