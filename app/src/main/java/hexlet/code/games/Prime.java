package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {
    public static void startGame() {
        // determine the parameters of game
        int attempts = Engine.getGameAttempts();
        final int maxGameNumber = 100;
        final String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[attempts];
        String[] correctAnswers = new String[attempts];

        // generating answers and questions
        for (int i = 0; i < attempts; i++) {
            int gameNumber = Util.generateRandomNumber(0, maxGameNumber);

            // preparing data for engine
            questions[i] = String.valueOf(gameNumber);
            correctAnswers[i] = correctAnswer(gameNumber);
        }
        Engine.game(description, questions, correctAnswers);
    }

    // finding correct answer
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
