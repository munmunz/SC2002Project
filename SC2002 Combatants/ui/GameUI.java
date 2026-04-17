package ui;

import java.util.prefs.BackingStoreException;
import java.util.stream.Collectors;

import actions.*;
import core.BattleField;
import core.Combatant;
import core.Player;
import items.Item;
import statuses.Status;

public class GameUI {
    public static void displayRoundInfo(int roundNumber){
        System.out.println();
        System.out.printf("End of Round %d%n",roundNumber);

        System.out.printf("%-10s | %-14s | %-20s%n", "Name", "HP", "Statuses");
        System.out.println("-".repeat(50));

        String format = "%-10s | HP:%4d / %-4d | %-20s%n";
        for (Combatant combatant: BattleField.getAliveCombatants()) {
            String statusString = combatant.getStatus().stream().map(Status::getName).collect(Collectors.joining(", "));
            System.out.printf(format, combatant.getName(), combatant.getHealthPoints(), combatant.getMaxHealthPoints(), statusString);
        }
        System.out.println();
    }

    public static void nextWave(int wave){
        System.out.println();
        System.out.printf("All Enemies Defeated!! Wave %d starts in next round!!%n", wave);
    }

    public static void displayAction(String message){
        System.out.println();
        System.out.println(message);
    }

    public static void gameOverLose(){
        System.out.println();
        System.out.println
            ("""
██████╗  █████╗ ███╗   ███╗███████╗       ██████╗ ██╗   ██╗███████╗██████╗
██╔════╝ ██╔══██╗████╗ ████║██╔════╝      ██╔═══██╗██║   ██║██╔════╝██╔══██╗
██║  ███╗███████║██╔████╔██║█████╗        ██║   ██║██║   ██║█████╗  ██████╔╝
██║   ██║██╔══██║██║╚██╔╝██║██╔══╝        ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗
╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗      ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║
 ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝       ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝
""");
    } 
    
    public static void gameOverWin(int roundNumber){
        System.out.println();
        System.out.println
            ("""
██╗   ██╗ ██████╗ ██╗   ██╗      ██╗    ██╗██╗███╗   ██╗██╗
╚██╗ ██╔╝██╔═══██╗██║   ██║      ██║    ██║██║████╗  ██║██║
 ╚████╔╝ ██║   ██║██║   ██║      ██║ █╗ ██║██║██╔██╗ ██║██║
  ╚██╔╝  ██║   ██║██║   ██║      ██║███╗██║██║██║╚██╗██║╚═╝
   ██║   ╚██████╔╝╚██████╔╝      ╚███╔███╔╝██║██║ ╚████║██╗
   ╚═╝    ╚═════╝  ╚═════╝        ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝                                                       
""");

    Player player = BattleField.getPlayer();

    System.out.println("Player Victory | Remaining HP: " + player.getHealthPoints()
                    + " / " + player.getMaxHealthPoints()
                    + " | Total Rounds: " + roundNumber
                );

    Item[] items = player.getItems();
    System.out.println("Items:");
    for (int i = 0; i < items.length; i++){
        System.out.printf("  %d. " + items[i].getType()
        +" (Used: " + Boolean.toString(items[i].isUsed()) + ")"
        + "\n",i+1);
    }
    
    }
}