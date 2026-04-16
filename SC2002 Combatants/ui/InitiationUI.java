package ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import core.Enemy;
import core.Player;
import items.Item;
import actions.*;
import battleengine.DifficultyLevel;

public class InitiationUI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void ListPlayers(List<Player> listOfPlayableCharacters) {
        System.out.println("=== Players ===");
        for (Player player : listOfPlayableCharacters) {
            System.out.println("  - " + player.getName());
        }
        System.out.println();
    }

    public static void ListPlayerAttributes(List<Player> listOfPlayableCharacters) {
        for (Player player : listOfPlayableCharacters) {
            System.out.println("=== " + player.getName() + " ===");
            System.out.println("  HP: " + player.getHealthPoints() +
                               " | Attack: " + player.getAttack() +
                               " | Defense: " + player.getDefense() +
                               " | Speed: " + player.getSpeed());

            System.out.println("  Special Skill(s):");
            for (Action action : player.getActions()) {
                if (action instanceof SpecialAction) {
                    SpecialAction special = (SpecialAction) action;
                    System.out.println("    - " + special.getName());
                }
            }
            System.out.println();
        }
    }

    public static void ListDifficulty() {
        System.out.println("Difficulty Levels:");
        for (int i = 0; i < DifficultyLevel.DIFFICULTY_COUNT; i++) {
            System.out.println("  " + (i + 1) + ". " + DifficultyLevel.DIFFICULTY_NAMES[i]);
        }
    }

    public static void ListCombatantsDifficulty() {
        System.out.println("=== Enemy Combatants by Difficulty ===");
        for (int diff = 1; diff <= DifficultyLevel.DIFFICULTY_COUNT; diff++) {
            String label = DifficultyLevel.DIFFICULTY_NAMES[diff - 1];
            System.out.print("  Level " + diff + " - " + label + ": ");

            int waveIndex = 0;
            ArrayList<Enemy> wave = DifficultyLevel.getWave(diff, waveIndex);
            while (!wave.isEmpty()) {
                System.out.print((waveIndex == 0 ? "Initial Spawn: " : " | Backup Spawn: ")
                    + describeWave(wave));
                waveIndex++;
                wave = DifficultyLevel.getWave(diff, waveIndex);
            }
            System.out.println();
        }
    }

    public static void ListEnemies(List<Enemy> listOfEnemies) {
        System.out.println("=== Enemies ===");
        for (Enemy enemy : listOfEnemies) {
            System.out.println("  - " + enemy.getName());
        }
        System.out.println();
    }

    public static void ListEnemyAttributes(List<Enemy> listOfEnemies) {
        for (Enemy enemy : listOfEnemies) {
            System.out.println("=== " + enemy.getName() + " ===");
            System.out.println("  HP: " + enemy.getHealthPoints() +
                            " | Attack: " + enemy.getAttack() +
                            " | Defense: " + enemy.getDefense() +
                            " | Speed: " + enemy.getSpeed());
            System.out.println("  Action(s):");
            for (Action action : enemy.getActions()) {
                System.out.println("    - " + action.getName());
            }
            System.out.println();
        }
    }

    public static Player getCharacter(List<Player> listOfPlayableCharacters) {
        System.out.println("Choose your character:");
        for (int i = 0; i < listOfPlayableCharacters.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + listOfPlayableCharacters.get(i).getName());
        }
        System.out.print("Please enter input: ");
        int choice = readInt(1, listOfPlayableCharacters.size());
        Player chosen = listOfPlayableCharacters.get(choice - 1);
        System.out.println("You chose: " + chosen.getName() + "\n");
        return chosen;
    }

    public static ArrayList<Item> getItems(List<Item> listOfItems) {
        ArrayList<Item> chosenItems = new ArrayList<>();

        System.out.println("Available items:");
        for (int i = 0; i < listOfItems.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + listOfItems.get(i).getType());
        }
        System.out.println("You may pick 2 items (duplicates allowed).\n");

        for (int i = 1; i <= 2; i++) {
            System.out.print("Choose item " + i + ": ");
            int choice = readInt(1, listOfItems.size());
            Item chosen = listOfItems.get(choice - 1).copy();
            chosenItems.add(chosen);
            System.out.println("  Added: " + chosen.getType() + "\n");
        }

        return chosenItems;
    }

    public static int getDifficulty() {
        System.out.println("Choose difficulty:");
        for (int i = 0; i < DifficultyLevel.DIFFICULTY_COUNT; i++) {
            System.out.println("  " + (i + 1) + ". " + DifficultyLevel.DIFFICULTY_NAMES[i]);
        }
        System.out.print("Please enter input: ");
        int choice = readInt(1, DifficultyLevel.DIFFICULTY_COUNT);
        System.out.println("You chose: " + DifficultyLevel.DIFFICULTY_NAMES[choice - 1] + "\n");
        return choice;
    }

    public static int showMainMenu() {
        System.out.println("Welcome to our game!!");
        System.out.println("  1. List Players (Warrior and Wizard)");
        System.out.println("  2. List Players' Attributes");
        System.out.println("  3. List levels of difficulty - Easy, Medium, Hard");
        System.out.println("  4. List number of enemy combatants by levels of difficulty");
        System.out.println("  5. List Enemies (Goblin, Wolf)");
        System.out.println("  6. List Enemies' Attributes");
        System.out.println("  7. Start Game");
        System.out.print("Please enter input: ");
        return readInt(1, 7);
    }

    public static void showLoadingScreen(Player player, ArrayList<Item> items, int difficulty) {
        String diffLabel = DifficultyLevel.DIFFICULTY_NAMES[difficulty - 1];

        ArrayList<Enemy> initialWave = DifficultyLevel.getWave(difficulty, 0);
        ArrayList<Enemy> backupWave  = DifficultyLevel.getWave(difficulty, 1);

        String itemSummary = items.get(0).getType() + " + " + items.get(1).getType();

        System.out.println("============================================");
        System.out.println("Difficulty Level (" + diffLabel + ")");
        System.out.println("Player: " + player.getName()
                + ", Player Stats: HP: " + player.getHealthPoints()
                + ", ATK: " + player.getAttack()
                + ", DEF: " + player.getDefense()
                + ", SPD: " + player.getSpeed());
        System.out.println("Items: " + itemSummary);

        String spawnLine = "Level: " + diffLabel + " - " + describeWave(initialWave);
        if (!backupWave.isEmpty()) {
            spawnLine += " | Backup: " + describeWave(backupWave);
        }
        System.out.println(spawnLine);

        // Print stats for each unique enemy type appearing in this difficulty
        Set<String> printed = new HashSet<>();
        for (Enemy e : initialWave) {
            if (printed.add(e.getName())) {
                System.out.println(e.getName() + " Stats: HP: " + e.getHealthPoints()
                        + ", ATK: " + e.getAttack()
                        + ", DEF: " + e.getDefense()
                        + ", SPD: " + e.getSpeed());
            }
        }
        for (Enemy e : backupWave) {
            if (printed.add(e.getName())) {
                System.out.println(e.getName() + " Stats: HP: " + e.getHealthPoints()
                        + ", ATK: " + e.getAttack()
                        + ", DEF: " + e.getDefense()
                        + ", SPD: " + e.getSpeed());
            }
        }
        System.out.println("============================================\n");
    }

    // Helper: turns a wave list into a readable string e.g. "2x Goblin, 1x Wolf"
    private static String describeWave(ArrayList<Enemy> wave) {
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();
        for (Enemy e : wave) {
            counts.merge(e.getName(), 1, Integer::sum);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(entry.getValue()).append("x ").append(entry.getKey());
        }
        return sb.toString();
    }

    private static int readInt(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.print("Invalid input. Enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number between " + min + " and " + max + ": ");
            }
        }
    }
}
