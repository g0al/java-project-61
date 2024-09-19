package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {

    public static void startGame() {

        Scanner scanner = new Scanner(System.in);

        // determine the parameters of number
        final int minGameNumber = -100;
        final int maxGameNumber = 100;

        // greeting and asking user
        Engine.userGreeting();
        System.out.println("What is the result of the expression?");

        // the mechanism of the game
        for (int i = 0; i < Engine.getGameAttempts(); i++) {

            // generating random numbers and operator for game
            int firstNumber = Engine.generateRandomNumber(minGameNumber, maxGameNumber);
            int secondNumber = Engine.generateRandomNumber(minGameNumber, maxGameNumber);
            char operator = generateOperator();

            // build a question and answer for user
            System.out.println("Question: " + firstNumber + " " + operator + " " + secondNumber);
            int userAnswer = scanner.nextInt();
            System.out.println("Your answer: " + userAnswer);

            // correct answer
            int correctAnswer = correctAnswer(firstNumber, secondNumber, operator);

            // checking answer
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + Engine.getUserName() + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + Engine.getUserName() + "!");

    }

    // generating random operator for game
    public static char generateOperator() {

        // count of operators in game
        final int operatorsCount = 2;

        int number = Engine.generateRandomNumber(0, operatorsCount);
        if (number == 0)  {
            return '+';
        } else if (number == 1) {
            return '-';
        } else if (number == 2) {
            return '*';
        }
        return 0;
    }

    // correct answer
    public static int correctAnswer(int firstNumber, int secondNumber, char operator) {
        switch (operator) {
            case '+' -> {
                return firstNumber + secondNumber;
            }
            case '-' -> {
                return firstNumber - secondNumber;
            }
            case '*' -> {
                return firstNumber * secondNumber;
            }
            default -> {
                return 0;
            }
        }
    }
}
