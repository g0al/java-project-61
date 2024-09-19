package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Gcd {

    public static void startGame() {

        Scanner scanner = new Scanner(System.in);

        // greeting and asking user
        Engine.userGreeting();
        System.out.println("Find the greatest common divisor of given numbers.");

        // the mechanism of the game
        for (int i = 0; i < Engine.getGameAttempts(); i++) {

            // determine the parameters of number
            final int maxGameNumber = 100;

            // generating two random numbers for game
            int firstNumber = Engine.generateRandomNumber(0, maxGameNumber);
            int secondNumber = Engine.generateRandomNumber(0, maxGameNumber);

            // build a question and answer for user
            System.out.println("Question: " + firstNumber + " " + secondNumber);
            int userAnswer = scanner.nextInt();
            System.out.println("Your answer: " + userAnswer);

            // correct answer
            int correctAnswer = correctAnswer(firstNumber, secondNumber);

            // checking answer
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + Engine.getUserName() + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }

    // correct answer
    public static int correctAnswer(int firstNumber, int secondNumber) {
        while (firstNumber > 0 && secondNumber > 0) {
            if (firstNumber >= secondNumber) {
                firstNumber = firstNumber % secondNumber;
            } else {
                secondNumber = secondNumber % firstNumber;
            }
        }
        return Math.max(firstNumber, secondNumber);
    }
}
