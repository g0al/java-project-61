package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;
    private static final int GAME_ATTEMPTS = 3;
    static Scanner scanner = new Scanner(System.in);

    public static int getGameAttempts() {
        return GAME_ATTEMPTS;
    }

    public static void game(String description, String[] questions, String[] correctAnswers) {
        userGreeting(description);
        for (int i = 0; i < GAME_ATTEMPTS; i++) {
            System.out.println("Question: " + questions[i]);
            String answer = scanner.nextLine();
            System.out.println("Your answer: " + answer);
            checkAnswer(answer, correctAnswers[i]);
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void userGreeting(String description) {
        System.out.println("""
        Welcome to the Brain Games!
        May I have your name?""");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println(description);
    }

    public static void checkAnswer(String userAnswer, String correctAnswer) {
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
            System.exit(0);
        }
    }
}
