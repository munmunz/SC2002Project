package app;

import ui.InitiationUI;
import core.Enemy;
import core.Player;
import items.*;

// import java.util.ArrayList;
import java.util.List;

import characters.*;

import battleengine.BattleEngine;

public class GameApp {


private static List<Player> ListofPlayableCharacters = List.of(new Warrior(), new Wizard()); 

private static List<Enemy> ListofEnemies = List.of(new Wolf(), new Goblin());

private static List<Item> ListofItems = List.of(new Potion(), new Powerstone(), new SmokeBomb());



// players, enemies, items (call into UI) 

    
    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            int menuChoice = InitiationUI.showMainMenu();
            System.out.println();

            switch (menuChoice) {
                case 1:
                    InitiationUI.ListPlayers(ListofPlayableCharacters);
                    break;
                case 2:
                    InitiationUI.ListPlayerAttributes(ListofPlayableCharacters);
                    break;
                case 3:
                    InitiationUI.ListDifficulty();
                    break;
                case 4:
                    InitiationUI.ListCombatantsDifficulty();
                    break;
                case 5:
                    InitiationUI.ListEnemies(ListofEnemies);
                    break;
                case 6:
                    InitiationUI.ListEnemyAttributes(ListofEnemies);
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
        Player player = InitiationUI.getCharacter(ListofPlayableCharacters);
        player.setItems(InitiationUI.getItems(ListofItems));
        int difficulty = InitiationUI.getDifficulty();

        // create BattleEngine , pass in difficulty level


        InitiationUI.showLoadingScreen(player, player.getItems(), difficulty);

    }
}
