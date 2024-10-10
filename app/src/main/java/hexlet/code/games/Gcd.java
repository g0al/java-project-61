package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Gcd {
    public static void startGame() {
        int attempts = Engine.GAME_ATTEMPTS;
        final int maxGameNumber = 100;
        final String description = "Find the greatest common divisor of given numbers.";
        String[][] data = new String[attempts][2];

        for (int i = 0; i < attempts; i++) {
            int firstNumber = Util.generateRandomNumber(0, maxGameNumber);
            int secondNumber = Util.generateRandomNumber(0, maxGameNumber);
            data[i][0] = firstNumber + " " + secondNumber;
            data[i][1] = Integer.toString(calculate(firstNumber, secondNumber));
        }
        Engine.runGame(description, data);
    }

    private static int calculate(int a, int b) {
        while (a > 0 && b > 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return Math.max(a, b);
    }
}
