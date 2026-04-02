public class Potion extends Item {
    int healAmount;

    Potion(){
        super("Potion");
        this.healAmount = 100;
    }

    @Override
    public void use(Player player, Combatant target){
        int newHealthPoints = player.getHealthPoints() + healAmount;
        if(newHealthPoints > player.getMaxHealthPoints()){
            newHealthPoints = player.getMaxHealthPoints();
        }
        player.setHealthPoints(newHealthPoints);
    }
}


