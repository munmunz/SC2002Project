package core;

import java.util.ArrayList;
import items.Item;
import statuses.Status;
import actions.*;
import java.util.Iterator;

public abstract class Player extends Combatant {
    private Item[] items;

    protected Player(String name,int healthPoints,int attack,int defense,int speed, int maxHealthPoints, int skillCooldown) {
        super(name, healthPoints, attack, defense, speed, maxHealthPoints);
        this.items = new Item[2];

        this.actions.add(new BasicAttack());
        this.actions.add(new Defend());
        this.actions.add(new UseItem());
    }

    public Item[] getItems(){
        return items;
    }
    public void setItems(Item[] items) {
        this.items = items;
    }

    public void decrement() {
        super.decrement(); // Decrement Statuses

        Iterator<Action> iterator2 = this.getActions().iterator(); // Decrement special skill cooldown
        while (iterator2.hasNext()) {
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
