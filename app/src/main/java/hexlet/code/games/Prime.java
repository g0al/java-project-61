package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {
    public static void startGame() {
        int attempts = Engine.GAME_ATTEMPTS;
        final int maxGameNumber = 100;
        final String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] data = new String[attempts][2];

        for (int i = 0; i < attempts; i++) {
            int gameNumber = Util.generateRandomNumber(0, maxGameNumber);
            data[i][0] = String.valueOf(gameNumber);
            data[i][1] = (isPrime(gameNumber)) ? "yes" : "no";
        }
        Engine.runGame(description, data);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
