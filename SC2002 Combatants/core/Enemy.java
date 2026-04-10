package core;

import actions.BasicAttack;
public abstract class Enemy extends Combatant {

    protected Enemy(String name,int healthPoints,int attack,int defense,int speed,int movesAvailable, int maxHealthPoints) {
        super(name, healthPoints, attack, defense, speed, movesAvailable, maxHealthPoints);

        this.actions.add(new BasicAttack());
    }
}
