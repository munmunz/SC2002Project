import java.util.ArrayList;
public abstract class Player extends Combatant {
    private ArrayList<Item> items;
    private int skillCooldown;

    Player(String name,int healthPoints,int attack,int defense,int speed,int movesAvailable,int maxHealthPoints, int skillCooldown) {
        super(name, healthPoints, attack, defense, speed, movesAvailable, maxHealthPoints);
        this.items = new ArrayList<>();
        this.skillCooldown = skillCooldown;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public int getSkillCooldown() {
        return skillCooldown;
    }
    public void setSkillCooldown(int skillCooldown) {
        this.skillCooldown = skillCooldown;
    }
}
