package app;

import ui.InitiationUI;
import core.Enemy;
import core.Player;
import items.*;

// import java.util.ArrayList;
import java.util.List;

import battleengine.BattleEngine;
import characters.*;

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
                    InitiationUI.listPlayers(ListofPlayableCharacters);
                    break;
                case 2:
                    InitiationUI.listPlayerAttributes(ListofPlayableCharacters);
                    break;
                case 3:
                    InitiationUI.listDifficulty();
                    break;
                case 4:
                    InitiationUI.listCombatantsDifficulty();
                    break;
                case 5:
                    InitiationUI.listEnemies(ListofEnemies);
                    break;
                case 6:
                    InitiationUI.listEnemyAttributes(ListofEnemies);
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
        player.setItems(InitiationUI.getItems(ListofItems,player.getItems().length));
        int difficulty = InitiationUI.getDifficulty();

        InitiationUI.showLoadingScreen(player, player.getItems(), difficulty);

        // create BattleEngine , pass in difficulty level

        BattleEngine BE = new BattleEngine(difficulty);
        BE.StartGame(player);


    }
}
