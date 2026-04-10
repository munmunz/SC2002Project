package core;

import java.util.ArrayList;

public class BattleField {
    private static ArrayList<Enemy> enemies = new ArrayList<>();
    private static Player player;

    public static ArrayList<Enemy> getAliveEnemies() {
        ArrayList<Enemy> aliveEnemies = new ArrayList<>();

        for (Enemy enemy : enemies) {
            if (enemy.getHealthPoints() > 0) {
                aliveEnemies.add(enemy);
            }
        }

        return aliveEnemies;
    }

    public static ArrayList<Combatant> getAliveCombatants() {
        ArrayList<Combatant> aliveCombatants = new ArrayList<>();

        if (player != null && player.getHealthPoints() > 0) {
            aliveCombatants.add(player);
        }

        aliveCombatants.addAll(getAliveEnemies());
        return aliveCombatants;
    }
}
