package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Even {

    public static void startGame() {

        Scanner scanner = new Scanner(System.in);

        // determine the parameters of number
        final int minGameNumber = 0;
        final int maxGameNumber = 100;

        // greeting and asking user
        Engine.userGreeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        // the mechanism of the game
        for (int i = 0; i < Engine.getGameAttempts(); i++) {

            // generating random number for game
            int gameNumber = Engine.generateRandomNumber(minGameNumber, maxGameNumber);

            // build a question and answer for user
            System.out.println("Question: " + gameNumber);
            String userAnswer = scanner.nextLine();
            System.out.println("Your answer: " + userAnswer);

            // checking answer
            if (correctAnswer(gameNumber).equals(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '" + correctAnswer(gameNumber) + "'.");
                System.out.println("Let's try again, " + Engine.getUserName() + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }

    // correct answer
    public static String correctAnswer(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
