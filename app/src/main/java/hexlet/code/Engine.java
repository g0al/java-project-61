package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;
    private static final int GAME_ATTEMPTS = 3;

    // greeting user
    public static void userGreeting() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + getUserName() + "!");
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static String getUserName() {
        return userName;
    }

    public static int getGameAttempts() {
        return GAME_ATTEMPTS;
    }

    public static void checkAnswer(String userAnswer, String correctAnswer) {

        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.");
            System.out.println("Let's try again, " + getUserName() + "!");
            System.exit(0);
        }
    }
}
