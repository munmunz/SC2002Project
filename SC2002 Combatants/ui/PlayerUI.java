package ui;

import actions.Action;
import core.Enemy;
import items.Item;
import java.util.ArrayList;
import java.util.Scanner;


public class PlayerUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static Action chooseAction(ArrayList<Action> actions){
        int length = actions.size();

        while (true) {
            System.out.println("Please choose which action you would like to use:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + actions.get(i).getName() + "\n",i+1);
            }
            System.out.print("Please enter input: ");
            int choice = readInt(1, length);
            
            if (1 <= choice && choice <= length){
                return (actions.get(choice - 1)).copy();
            }
        }
    }

    public static Enemy chooseTarget(ArrayList<Enemy> enemies){
        int length = enemies.size();

        while (true) {
            System.out.println("Please choose the enemy you would like to target:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + enemies.get(i).getName()
                +" (HP: " + enemies.get(i).getHealthPoints() + "/" + enemies.get(i).getMaxHealthPoints() + ")"
                + "\n",i+1);
            }
            System.out.print("Please enter input: ");
            int choice = readInt(1, length);
            
            if (1 <= choice && choice <= length){
                return enemies.get(choice - 1);
            }
        }
    }

    public static Item chooseItem(ArrayList<Item> items){
        int length = items.size();

        while (true) {
            System.out.println("Please choose the item you would like to use:");
            for (int i = 0; i < length; i++){
                System.out.printf("  %d. " + items.get(i).getType()
                +" (Used: " + Boolean.toString(items.get(i).isUsed()) + ")"
                + "\n",i+1);
            }
            System.out.print("Please enter input: ");
            int choice = readInt(1, length);
            
            if (1 <= choice && choice <= length){
                if (items.get(choice - 1).isUsed() == false){
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

    private static int readInt(int min, int max) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
        }
    }
}
