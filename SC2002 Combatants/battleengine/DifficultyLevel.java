package battleengine;

import java.util.ArrayList;

import characters.Goblin;
import characters.Wolf;
import core.Enemy;

public class DifficultyLevel {

    public ArrayList<Enemy> getInitial(int difficulty) {
        ArrayList<Enemy> enemies = new ArrayList<>();

        switch (difficulty) {
            case 1:
                enemies.add(new Goblin());
                enemies.add(new Goblin());
                enemies.add(new Goblin());
                break;
            case 2:
                enemies.add(new Goblin());
                enemies.add(new Wolf());
                break;
            case 3:
                enemies.add(new Goblin());
                enemies.add(new Goblin());
                break;
            default:
                break;
        }

        return enemies;
    }

    public ArrayList<Enemy> getBackup(int difficulty) {
        ArrayList<Enemy> enemies = new ArrayList<>();

        switch (difficulty) {
            case 2:
                enemies.add(new Wolf());
                enemies.add(new Wolf());
                break;
            case 3:
                enemies.add(new Goblin());
                enemies.add(new Wolf());
                enemies.add(new Wolf());
                break;
            default:
                break;
        }

        return enemies;
    }
}