package core;

import actions.BasicAttack;
public abstract class Enemy extends Combatant {

    protected Enemy(String name,int healthPoints,int attack,int defense,int speed, int maxHealthPoints) {
        super(name, healthPoints, attack, defense, speed, maxHealthPoints);

        this.actions.add(new BasicAttack());
    }
}
