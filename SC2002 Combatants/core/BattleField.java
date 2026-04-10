package core;

import java.util.ArrayList;

public class BattleField {

    private final ArrayList<Combatant> combatants;

    public BattleField() {
        this.combatants = new ArrayList<>();
    }

    public BattleField(ArrayList<Combatant> combatants) {
        if(combatants != null){
            this.combatants = combatants;
        }
        else{
            this.combatants = new ArrayList<>();
        }
    }

    public ArrayList<Combatant> getCombatants() {
        return combatants;
    }

    public ArrayList<Enemy> getAliveEnemies() {
        ArrayList<Enemy> alive = new ArrayList<>();
        for (Combatant c : combatants) {
            if (c instanceof Enemy && c.getHealthPoints() > 0) {
                alive.add((Enemy) c);
            }
        }
        return alive;
    }

    public void removeDead() {
        combatants.removeIf(c -> c.getHealthPoints() <= 0);
    }
}
