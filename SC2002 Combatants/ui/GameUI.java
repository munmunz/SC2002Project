package ui;

import java.util.stream.Collectors;

import actions.*;
import core.BattleField;
import core.Combatant;
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

    public static void displayAction(Action action){
        String message;

        if (action instanceof Targetable){
            Combatant target = ((Targetable) action).getTarget();
            message = action.getUser().getName() + " used " + action.getName() + " on " + target.getName();
        }
        else if (action instanceof UseItem){
            Item item = ((UseItem) action).getItem();
            message = action.getUser().getName() + " used " + item.getType();
        }
        else message = action.getUser().getName() + " used " + action.getName();

        System.out.println();
        System.out.printf(message + "%n");
    }
                                                                     
}
