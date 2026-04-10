package core;

import java.util.ArrayList;
import items.Item;
import statuses.Status;
import actions.Action;
import actions.SpecialAction;
import java.util.Iterator;

public abstract class Player extends Combatant {
    private ArrayList<Item> items;

    protected Player(String name,int healthPoints,int attack,int defense,int speed,int movesAvailable,int maxHealthPoints, int skillCooldown) {
        super(name, healthPoints, attack, defense, speed, movesAvailable, maxHealthPoints);
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void decrement() {
        Iterator<Status> iterator = this.getStatus().iterator(); // Decrement Status
        while (iterator.hasNext()) {
            Status currentStatus = iterator.next();
            
            currentStatus.decrementStatus(); 
            
            if (currentStatus.getCooldown() == 0) {
                iterator.remove();
            }
        }

        Iterator<Action> iterator2 = this.getActions().iterator(); // Decrement special skill cooldown
        while (iterator.hasNext()) {
            Action currentAction = iterator2.next();
            
            if (currentAction instanceof SpecialAction){
                SpecialAction action = (SpecialAction) currentAction;
                if (action.getCooldown() > 0){
                    int newCooldown = action.getCooldown() - 1;
                    action.setCooldown(newCooldown);
                }
            }
        }
    }
}
