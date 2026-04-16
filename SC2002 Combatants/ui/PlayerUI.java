package ui;

import java.util.ArrayList;
import java.util.Scanner;
import actions.Action;
import core.Enemy;
import items.Item;

public class PlayerUI {
    public static Action chooseAction(ArrayList<Action> actions){
        int length = actions.size();
        while (true) {
            System.out.println();
            System.out.println("Please choose which action you would like to use:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + actions.get(i).getName() + "\n",i+1);
            }
            int choice = HandleInput.readInt(1,length);       
            
            if (1 <= choice && choice <= length){
                return (actions.get(choice - 1)).copy();
            }
            else continue;
        }
    }

    public static Enemy chooseTarget(ArrayList<Enemy> enemies){
        int length = enemies.size();

        while (true) {
            System.out.println();
            System.out.println("Please choose the enemy you would like to target:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + enemies.get(i).getName()
                +" (HP: " + enemies.get(i).getHealthPoints() + "/" + enemies.get(i).getMaxHealthPoints() + ")"
                + "\n",i+1);
            }
            int choice = HandleInput.readInt(1,length);        
            
            if (1 <= choice && choice <= length){
                return enemies.get(choice - 1);
            }
            else continue;
        }
    }

    public static Item chooseItem(Item[] items){
        int length = items.length;

        while (true) {
            System.out.println();
            System.out.println("Please choose the item you would like to use:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + items[i].getType()
                +" (Used: " + Boolean.toString(items[i].isUsed()) + ")"
                + "\n",i+1);
            }
            System.out.println("\n  0. BACK");

            int choice = HandleInput.readInt(0,length);         

            if (0 <= choice && choice <= length){
                if (choice == 0){
                    return null;
                }
                else{
                    Item chosenItem = items[choice-1];
                    if (chosenItem.isUsed() == false){
                        return chosenItem;
                    }
                    else{
                        System.out.println("Item has been used!! Pick another item!!");
                        continue;
                    }
                }
            }
            else continue;
        }
    }
}
