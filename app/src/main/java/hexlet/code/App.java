package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        // choosing a game
        String userChoice = scanner.nextLine();
        System.out.println("Your choice: " + userChoice);

        switch (userChoice) {
            case "1" -> {
                System.out.println("Welcome to the Brain Games!");
                Cli.getUserName();
            }
            case "2" -> Even.startGame();
            case "3" -> Calc.startGame();
            case "4" -> Gcd.startGame();
            case "5" -> Progression.startGame();
            case "6" -> Prime.startGame();
            case null, default -> System.exit(0);
        }
    }
}
