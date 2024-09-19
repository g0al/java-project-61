package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {

    public static void startGame() {

        Scanner scanner = new Scanner(System.in);

        // greeting and asking user
        Engine.userGreeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        // the mechanism of the game
        for (int i = 0; i < Engine.getGameAttempts(); i++) {

            // determine the parameters of number
            final int maxGameNumber = 100;

            // generating random number for game
            int gameNumber = Engine.generateRandomNumber(0, maxGameNumber);

            // build a question and answer for user
            System.out.println("Question: " + gameNumber);
            String userAnswer = scanner.nextLine();
            System.out.println("Your answer: " + userAnswer);

            // correct answer
            String correctAnswer = correctAnswer(gameNumber);

            // checking answer
            Engine.checkAnswer(userAnswer, correctAnswer);
        }
        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }

    // correct answer
    public static String correctAnswer(int number) {

        if (number < 2) {
            return "no";
        }
        for (int j = 2; j <= Math.sqrt(number); j++) {
            if (number % j == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
