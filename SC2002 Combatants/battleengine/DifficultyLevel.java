package battleengine;

import java.util.ArrayList;

import characters.Goblin;
import characters.Wolf;
import core.Enemy;

public class DifficultyLevel {

    public static final int DIFFICULTY_COUNT = 3;
    public static final String[] DIFFICULTY_NAMES = {"Easy", "Medium", "Hard"};

    /**
     * This the specific wave of enemies based on the chosen difficulty.
     * Instead of hardcoding 'getInitial()' and 'getBackup()', we use a single 
     * 'getWave(index)' method. If game designers want a 5-wave boss fight later, 
     * the architecture already supports it without needing to rewrite the BattleEngine.
     *
     * Parameters:
     * difficulty is the chosen difficulty level (1=Easy, 2=Medium, 3=Hard).
     * waveIndex  is the current wave number (0 = Initial Spawn, 1 = First Backup, etc.).
     * return an ArrayList of Enemies for that wave. Returns an empty list if no more waves exist.
     */
    public static ArrayList<Enemy> getWave(int difficulty, int waveIndex) {
        ArrayList<Enemy> enemies = new ArrayList<>();

        switch (difficulty) {
            case 1: // Easy
                if (waveIndex == 0) { // Initial Spawn
                    enemies.add(new Goblin());
                    enemies.add(new Goblin());
                    enemies.add(new Goblin());
                }
                break;

            case 2: // Medium
                if (waveIndex == 0) { // Initial Spawn
                    enemies.add(new Goblin());
                    enemies.add(new Wolf());
                } else if (waveIndex == 1) { // Backup Spawn
                    enemies.add(new Wolf());
                    enemies.add(new Wolf());
                }
                break;

            case 3: // Hard
                if (waveIndex == 0) { // Initial spawn
                    enemies.add(new Goblin());
                    enemies.add(new Goblin());
                } else if (waveIndex == 1) { // Backup Spawn
                    enemies.add(new Goblin());
                    enemies.add(new Wolf());
                    enemies.add(new Wolf());
                }
                break;
                
            default:
                break;
        }

        return enemies;
    }
}