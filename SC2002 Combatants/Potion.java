<<<<<<< Updated upstream
import java.util.ArrayList;

public class Potion implements Item {
    private final String type;
    private final int healAmount;

    Potion() {
        this.type = "Potion";
=======
public class Potion extends Item {
    int healAmount;

    Potion(){
        super("Potion");
>>>>>>> Stashed changes
        this.healAmount = 100;
    }

    @Override
<<<<<<< Updated upstream
    public String getType() {
        return type;
    }

    @Override
    public void use(Player player, Combatant target, ArrayList<Combatant> enemies) {
        int newHealthPoints = player.getHealthPoints() + healAmount;
        if (newHealthPoints > player.getMaxHealthPoints()) {
=======
    public void use(Player player, Combatant target){
        int newHealthPoints = player.getHealthPoints() + healAmount;
        if(newHealthPoints > player.getMaxHealthPoints()){
>>>>>>> Stashed changes
            newHealthPoints = player.getMaxHealthPoints();
        }
        player.setHealthPoints(newHealthPoints);
    }
}

