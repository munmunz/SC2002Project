package ui;

import java.util.Scanner;

public class HandleInput {
    private static final Scanner scanner = new Scanner(System.in);

    protected static int readInt(int min, int max) {
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
