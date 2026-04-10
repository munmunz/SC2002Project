package core;

import java.util.ArrayList;
import actions.Action;
import statuses.Status;
import java.util.Iterator;

public abstract class Combatant{
    private String name;
    private int healthPoints;
    private int attack;
    private int defense;
    private int speed;
    private ArrayList<Status> status;
    protected ArrayList<Action> actions;
    private int movesAvailable;
    private int maxHealthPoints;
    
    protected Combatant(String name, int healthPoints, int attack, int defense, int speed, int movesAvailable, int maxHealthPoints){
        this.name = name;
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.status = new ArrayList<>();
        this.movesAvailable = movesAvailable;
        this.actions = new ArrayList<>();
        this.maxHealthPoints = maxHealthPoints;
    }

    public void applyStatus(Status status){
        if(status == null){
            return;
        }
        else{
            this.status.add(status);
            status.apply();
        }
    }

    public void decrement() {
        Iterator<Status> iterator = this.status.iterator();
        
        while (iterator.hasNext()) {
            Status currentStatus = iterator.next();
            
            // This drops the cooldown by 1 and calls currentStatus.remove() if cooldown hits 0
            currentStatus.decrementStatus(); 
            
            // Remove the status object from the ArrayList once its cooldown is 0
            if (currentStatus.getCooldown() == 0) {
                iterator.remove();
            }
        }
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Status> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<Status> status) {
        this.status = status;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public int getMovesAvailable() {
        return movesAvailable;
    }

    public void setMovesAvailable(int movesAvailable) {
        this.movesAvailable = movesAvailable;
    }
    public int getMaxHealthPoints() {
    return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

}
