package battleengine;

import core.Player;
import core.Enemy;
import items.Item;
import actions.*;
import actions.exceptions.*;
import ui.PlayerUI;

public class PlayerControl {
    public static void getPlayerMove(Player player){
        while (true){
            Action choice = PlayerUI.chooseAction(player.getActions());
            if (choice instanceof UseItem){
                Item targetItem = PlayerUI.chooseItem(player.getItems());
                ((UseItem) choice).setItem(targetItem);
            }

            choice.setUser(player);

            boolean success = doAction(player,choice);
            if (success){
                return;
            }else continue;
        }
    }

    public static boolean doAction(Player player, Action action){
        // Return true if action done successfully, false if action is not possible to be done
        while (true){
            try{
                action.execute();
                return true;
            } 
            catch (MissingTargetException e){
                Enemy target = PlayerUI.chooseTarget(BattleField.getAliveEnemies());
                ((Targetable) action).setTarget(target);
            }
            catch (ActionOnCooldownException e){
                System.out.println("Error for " + action.getName() + ": " + e.getMessage());
                return false;
            }

        }
        return false;
    }
}
