package ui;

import java.util.ArrayList;
import java.util.Scanner;

import actions.Action;
import core.Enemy;
import items.Item;

public class PlayerUI {
    public static Action chooseAction(ArrayList<Action> actions){
        int length = actions.size();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose which action you would like to use:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + actions.get(i).getName() + "\n",i+1);
            }
            int choice = sc.nextInt();        
            
            if (1 <= choice && choice <= length){
                sc.close();
                return (actions.get(choice - 1)).copy();
            }
            else continue;
        }
    }

    public static Enemy chooseTarget(ArrayList<Enemy> enemies){
        int length = enemies.size();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose the enemy you would like to target:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + enemies.get(i).getName()
                +" (HP: " + enemies.get(i).getHealthPoints() + "/" + enemies.get(i).getMaxHealthPoints() + ")"
                + "\n",i+1);
            }
            int choice = sc.nextInt();        
            
            if (1 <= choice && choice <= length){
                sc.close();
                return enemies.get(choice - 1);
            }
            else continue;
        }
    }

    public static Item chooseItem(ArrayList<Item> items){
        int length = items.size();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose the item you would like to use:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + items.get(i).getType()
                +" (Used: " + Boolean.toString(items.get(i).isUsed()) + ")"
                + "\n",i+1);
            }
            int choice = sc.nextInt();        
            
            if (1 <= choice && choice <= length){
                if (items.get(choice - 1).isUsed() == false){
                    sc.close();
                    return items.get(choice - 1);
                }
                else{
                    System.out.println("Item has been used!! Pick another item!!");
                    continue;
                }
            }
            else continue;
        }
    }    
}
