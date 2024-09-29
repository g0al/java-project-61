package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Gcd {
    public static void startGame() {
        // determine the parameters of game
        final int maxGameNumber = 100;
        final String description = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[3];
        String[] correctAnswers = new String[3];

        // generating answers and questions
        for (int i = 0; i < Engine.getGameAttempts(); i++) {

            // generating two random numbers for game
            int firstNumber = Util.generateRandomNumber(0, maxGameNumber);
            int secondNumber = Util.generateRandomNumber(0, maxGameNumber);

            // getting correct answer
            String correctAnswer = correctAnswer(firstNumber, secondNumber);

            // preparing data for engine
            questions[i] = firstNumber + " " + secondNumber;
            correctAnswers[i] = correctAnswer;
        }
        Engine.game(description, questions, correctAnswers);
    }

    // finding correct answer
    public static String correctAnswer(int firstNumber, int secondNumber) {
        while (firstNumber > 0 && secondNumber > 0) {
            if (firstNumber >= secondNumber) {
                firstNumber = firstNumber % secondNumber;
            } else {
                secondNumber = secondNumber % firstNumber;
            }
        }
        return Integer.toString(Math.max(firstNumber, secondNumber));
    }
}
