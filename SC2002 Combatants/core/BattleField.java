package core;

import java.util.ArrayList;

public class BattleField {
    private static ArrayList<Enemy> enemies = new ArrayList<>();
    private static Player player;

    public static void setEnemies(ArrayList<Enemy> enemies) {
        if (enemies == null) {
            BattleField.enemies = new ArrayList<>();
            return;
        }
        BattleField.enemies = new ArrayList<>(enemies);
    }

    public static void setPlayer(Player player) {
        BattleField.player = player;
    }

    public static ArrayList<Enemy> getAliveEnemies() {
        ArrayList<Enemy> aliveEnemies = new ArrayList<>();

        if (enemies == null) {
            return aliveEnemies;
        }

        for (Enemy enemy : enemies) {
            if (enemy != null && enemy.getHealthPoints() > 0) {
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

    public static Player getPlayer(){
        return player;
    }
}
