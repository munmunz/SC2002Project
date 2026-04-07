import java.util.ArrayList;

public abstract class Combatant{
    private String name;
    private int healthPoints;
    private int attack;
    private int defense;
    private int speed;
    private ArrayList<Status> status;
    private ArrayList<Action> actions;
    private int movesAvailable;
    private int maxHealthPoints;

    // Status effect flags
    private boolean stunned;
    private boolean smokeBombed;
    private boolean invulnerable;

    Combatant(String name, int healthPoints, int attack, int defense, int speed, int movesAvailable, int maxHealthPoints){
        this.name = name;
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.status = new ArrayList<>();
        this.movesAvailable = movesAvailable;
        this.actions = new ArrayList<>();
        this.maxHealthPoints = maxHealthPoints;
        this.stunned = false;
        this.smokeBombed = false;
        this.invulnerable = false;
    }
    // Status effect getters and setters
    public boolean isStunned() {
        return stunned;
    }
    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public boolean isSmokeBombed() {
        return smokeBombed;
    }
    public void setSmokeBombed(boolean smokeBombed) {
        this.smokeBombed = smokeBombed;
    }

    public boolean isInvulnerable() {
        return invulnerable;
    }
    public void setInvulnerable(boolean invulnerable) {
        this.invulnerable = invulnerable;
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

    public void decrementStatus(){

    }

    public void performActions(Action action,Combatant target){
    		if (action.isValid(this)) {
    			action.execute();
    		}
    		else {
    			System.out.println(getName() + " cannot perform that action!")
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

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
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