package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static void startGame() {
        // determine the parameters of game
        int attempts = Engine.getGameAttempts();
        final int minGameNumber = -100;
        final int maxGameNumber = 100;
        final String description = "What is the result of the expression?";
        String[] questions = new String[attempts];
        String[] correctAnswers = new String[attempts];

        // generating answers and questions
        for (int i = 0; i < attempts; i++) {
            // generating random numbers and operator for game
            int firstNumber = Util.generateRandomNumber(minGameNumber, maxGameNumber);
            int secondNumber = Util.generateRandomNumber(minGameNumber, maxGameNumber);
            char operator = generateOperator();

            // preparing data for engine
            questions[i] = "Question: " + firstNumber + " " + operator + " " + secondNumber;
            correctAnswers[i] = correctAnswer(firstNumber, secondNumber, operator);
        }
        Engine.game(description, questions, correctAnswers);
    }

    // generating random operator for game
    public static char generateOperator() {
        final int operatorsCount = 2; // count of operators in game

        int number = Util.generateRandomNumber(0, operatorsCount);
        if (number == 0)  {
            return '+';
        } else if (number == 1) {
            return '-';
        } else if (number == 2) {
            return '*';
        }
        return 0;
    }

    // finding correct answer
    public static String correctAnswer(int firstNumber, int secondNumber, char operator) {
        switch (operator) {
            case '+' -> {
                return Integer.toString(firstNumber + secondNumber);
            }
            case '-' -> {
                return Integer.toString(firstNumber - secondNumber);
            }
            case '*' -> {
                return Integer.toString(firstNumber * secondNumber);
            }
            default -> {
                return "0";
            }
        }
    }
}
