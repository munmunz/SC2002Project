public class Potion implements Item {
    private String type;
    int healAmount;

    Potion(){
        this.type = "Potion";
        this.healAmount = 100;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public void use(Player player, Combatant target){
        int newHealthPoints = player.getHealthPoints() + 100;
        if(newHealthPoints > player.getMaxHealthPoints()){
            newHealthPoints = player.getMaxHealthPoints();
        }
        player.setHealthPoints(newHealthPoints);
    }
}

