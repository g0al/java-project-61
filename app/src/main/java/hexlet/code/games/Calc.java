package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static void startGame() {
        int attempts = Engine.GAME_ATTEMPTS;
        final int minGameNumber = -10;
        final int maxGameNumber = 10;
        Character[] operators = new Character[] {'+', '-', '*'};
        final String description = "What is the result of the expression?";
        String[][] data = new String[attempts][2];

        for (int i = 0; i < attempts; i++) {
            int firstNumber = Util.generateRandomNumber(minGameNumber, maxGameNumber);
            int secondNumber = Util.generateRandomNumber(minGameNumber, maxGameNumber);
            char operator = operators[Util.generateRandomNumber(0, operators.length - 1)];

            data[i][0] = "Question: " + firstNumber + " " + operator + " " + secondNumber;
            data[i][1] = Integer.toString(calculate(firstNumber, secondNumber, operator));
        }
        Engine.runGame(description, data);
    }

    private static int calculate(int firstNumber, int secondNumber, char operator) {
        return switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> 0;
        };
    }
}
