package app;

import ui.InitiationUI;
import core.Player;
import items.Item;
import java.util.ArrayList;

public class GameApp {

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            int menuChoice = InitiationUI.showMainMenu();
            System.out.println();

            switch (menuChoice) {
                case 1:
                    InitiationUI.ListPlayers();
                    break;
                case 2:
                    InitiationUI.ListPlayerAttributes();
                    break;
                case 3:
                    InitiationUI.ListDifficulty();
                    break;
                case 4:
                    InitiationUI.ListCombatantsDifficulty();
                    break;
                case 5:
                    InitiationUI.ListEnemies();
                    break;
                case 6:
                    InitiationUI.ListEnemyAttributes();
                    break;
                case 7:
                    startGame();
                    running = false;
                    break;
            }

            System.out.println();
        }
    }

    private static void startGame() {
        Player player = InitiationUI.getCharacter();
        ArrayList<Item> items = InitiationUI.getItems(player);
        int difficulty = InitiationUI.getDifficulty();

        InitiationUI.showLoadingScreen(player, items, difficulty);

        // incomplete
    }
}
