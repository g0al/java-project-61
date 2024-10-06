package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Gcd {
    public static void startGame() {
        // determine the parameters of runGame
        int attempts = Engine.GAME_ATTEMPTS;
        final int maxGameNumber = 100;
        final String description = "Find the greatest common divisor of given numbers.";
        String[][] data = new String[attempts][2];

        // generating answers and questions
        for (int i = 0; i < attempts; i++) {

            // generating two random numbers for game
            int firstNumber = Util.generateRandomNumber(0, maxGameNumber);
            int secondNumber = Util.generateRandomNumber(0, maxGameNumber);

            // preparing data for engine
            data[i][0] = firstNumber + " " + secondNumber;
            data[i][1] = Integer.toString(calculate(firstNumber, secondNumber));
        }
        Engine.runGame(description, data);
    }

    // checking answer
    public static int calculate(int a, int b) {
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
