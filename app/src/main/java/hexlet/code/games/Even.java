package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {
    public static void startGame() {
        int attempts = Engine.GAME_ATTEMPTS;
        final int minGameNumber = 0;
        final int maxGameNumber = 100;
        final String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] data = new String[attempts][2];

        for (int i = 0; i < attempts; i++) {
            int gameNumber = Util.generateRandomNumber(minGameNumber, maxGameNumber);
            data[i][0] = String.valueOf(gameNumber);
            data[i][1] = (isEven(gameNumber)) ? "yes" : "no";
        }
        Engine.runGame(description, data);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
