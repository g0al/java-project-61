package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int GAME_ATTEMPTS = 3;

    public static void runGame(String description, String[][] data) {
        Scanner scanner = new Scanner(System.in);
        String userName;

        System.out.println("""
        Welcome to the Brain Games!
        May I have your name?""");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println(description);

        for (int i = 0; i < GAME_ATTEMPTS; i++) {
            System.out.println("Question: " + data[i][0]);
            String answer = scanner.nextLine();
            System.out.println("Your answer: " + answer);

            if (answer.equals(data[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + data[i][1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
