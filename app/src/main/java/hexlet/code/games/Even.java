package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {
    public static void startGame() {
        // determine the parameters of game
        int attempts = Engine.getGameAttempts();
        final int minGameNumber = 0;
        final int maxGameNumber = 100;
        final String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = new String[attempts];
        String[] correctAnswers = new String[attempts];

        // generating answers and questions
        for (int i = 0; i < attempts; i++) {

            // generating random number for game
            int gameNumber = Util.generateRandomNumber(minGameNumber, maxGameNumber);

            // getting correct answer
            String correctAnswer = correctAnswer(gameNumber);

            // preparing data for engine
            questions[i] = String.valueOf(gameNumber);
            correctAnswers[i] = correctAnswer;
        }
        Engine.game(description, questions, correctAnswers);
    }

    // finding correct answer
    public static String correctAnswer(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
