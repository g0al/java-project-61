package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {
    public static void startGame() {
        // determine the parameters of game
        int attempts = Engine.getGameAttempts();
        final int minNumbersInProgression = 5;
        final int maxNumbersInProgression = 10;
        final int minFirstNumber = 1;
        final int maxFirstNumber = 10;
        final int minStep = 2;
        final int maxStep = 5;
        final String description = "What number is missing in the progression?";
        String[] questions = new String[attempts];
        String[] correctAnswers = new String[attempts];

        // generating answers and questions
        for (int i = 0; i < attempts; i++) {
            // progression parameters
            int numbersInProgression = Util.generateRandomNumber(minNumbersInProgression,
                    maxNumbersInProgression);
            int firstNumber = Util.generateRandomNumber(minFirstNumber, maxFirstNumber);
            int step = Util.generateRandomNumber(minStep, maxStep);
            int missingNumberIndex = Util.generateRandomNumber(0, numbersInProgression - 1);

            // creating and filling array with numbers
            int[] numbers = new int[numbersInProgression];
            numbers[0] = firstNumber;
            for (int k = 1; k < numbers.length; k++) {
                numbers[k] = numbers[k - 1] + step;
            }

            // creating string for progression
            StringBuilder question = new StringBuilder("Question: ");
            for (int j = 0; j < numbers.length; j++) {
                if (j != missingNumberIndex) {
                    question.append(numbers[j]).append(" ");
                } else {
                    question.append(".. ");
                }
            }

            // preparing data for engine
            questions[i] = String.valueOf(question);
            correctAnswers[i] = Integer.toString(numbers[missingNumberIndex]);
        }
        Engine.game(description, questions, correctAnswers);
    }
}
