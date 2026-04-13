package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// import actions.BasicAttack;
import core.Enemy;
import core.Player;
// import characters.*;
import items.Item;
// import items.*;
import actions.*;


public class InitiationUI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void ListPlayers(List<Player> ListofPlayableCharacters) {
      System.out.println("=== Players ===");
        for (Player player : ListofPlayableCharacters) {
            System.out.println("  - " + player.getName());
        }
        System.out.println();
    }


    public static void ListPlayerAttributes(List<Player> ListofPlayableCharacters) {
    for (Player player : ListofPlayableCharacters) {
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
        System.out.println("  1. Easy");
        System.out.println("  2. Medium");
        System.out.println("  3. Hard");
    }

    public static void ListCombatantsDifficulty() {
        System.out.println("=== Enemy Combatants by Difficulty ===");
        System.out.println("  Level 1 - Easy  : Initial Spawn: 3 Goblins");
        System.out.println("  Level 2 - Medium: Initial Spawn: 1 Goblin, 1 Wolf  | Backup Spawn: 2 Wolves");
        System.out.println("  Level 3 - Hard  : Initial Spawn: 2 Goblins         | Backup Spawn: 1 Goblin, 2 Wolves");
    }

    public static void ListEnemies(List<Enemy> ListofEnemies) {
    System.out.println("=== Enemies ===");
    for (Enemy enemy : ListofEnemies) {
        System.out.println("  - " + enemy.getName());
    }
    System.out.println();
}

    public static void ListEnemyAttributes(List<Enemy> ListofEnemies) {
        for (Enemy enemy : ListofEnemies) {
            System.out.println("=== " + enemy.getName() + " ===");
            System.out.println("  HP: " + enemy.getHealthPoints() +
                            " | Attack: " + enemy.getAttack() +
                            " | Defense: " + enemy.getDefense() +
                            " | Speed: " + enemy.getSpeed());

            System.out.println("Action(s):");
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


// private static List<Item> ListofItems = List.of(new Potion(), new Powerstone(), new SmokeBomb()); for reference 

    public static ArrayList<Item> getItems(List<Item> listOfItems) {
    ArrayList<Item> chosenItems = new ArrayList<>();

    System.out.println("Available items:");
    for (int i = 0; i < listOfItems.size(); i++) {
        Item item = listOfItems.get(i);
        System.out.println("  " + (i + 1) + ". " + item.getType());  // leave out item descriptions 
    }
    System.out.println("You may pick 2 items (duplicates allowed).\n");

    for (int i = 1; i <= 2; i++) {
        System.out.print("Choose item " + i + ": ");
        int choice = readInt(1, listOfItems.size());

        Item chosen = listOfItems.get(choice - 1);
        chosenItems.add(chosen);
        System.out.println("  Added: " + chosen.getType() + "\n");
    }

    return chosenItems;
}


    public static int getDifficulty() {
        System.out.println("Choose difficulty:");
        System.out.println("  1. Easy");
        System.out.println("  2. Medium");
        System.out.println("  3. Hard");
        System.out.print("Please enter input: ");

        int choice = readInt(1, 3);
        switch (choice) {
            case 1:
                System.out.println("You chose: Easy\n");
                break;
            case 2:
                System.out.println("You chose: Medium\n");
                break;
            case 3:
                System.out.println("You chose: Hard\n");
                break;
            default:
                break;
        }
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
        String diffLabel;
        String initialSpawn;
        String backupSpawn;

        switch (difficulty) {
            case 1:
                diffLabel = "Easy";
                initialSpawn = "3 Goblins - Goblin A + Goblin B + Goblin C";
                backupSpawn = null;
                break;
            case 2:
                diffLabel = "Medium";
                initialSpawn = "1 Goblin + 1 Wolf";
                backupSpawn = "Wolf A + Wolf B";
                break;
            case 3:
                diffLabel = "Hard";
                initialSpawn = "2 Goblins - Goblin A + Goblin B";
                backupSpawn = "Goblin A + Wolf A + Wolf B";
                break;
            default:
                diffLabel = "Unknown";
                initialSpawn = "Unknown";
                backupSpawn = null;
        }

        String itemSummary = items.get(0).getType() + " + " + items.get(1).getType();

        System.out.println("============================================");
        System.out.println("Difficulty Level (" + diffLabel + ")");
        System.out.println("Player: " + player.getName() + ", Player Stats: HP: " + player.getHealthPoints()
                + ", ATK: " + player.getAttack()
                + ", DEF: " + player.getDefense()
                + ", SPD: " + player.getSpeed());
        System.out.println("Items: " + itemSummary);

        if (backupSpawn != null) {
            System.out.println("Level: " + diffLabel + " - " + initialSpawn + " | Backup: " + backupSpawn);
        } else {
            System.out.println("Level: " + diffLabel + " - " + initialSpawn);
        }

        System.out.println("Goblin Stats: HP: 55, ATK: 35, DEF: 15, SPD: 25");

        if (difficulty == 2 || difficulty == 3) {
            System.out.println("Wolf Stats: HP: 40, ATK: 45, DEF: 5, SPD: 35");
        }
        System.out.println("============================================\n");
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
