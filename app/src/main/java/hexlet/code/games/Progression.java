package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {
    public static void startGame() {
        // determine the parameters of game
        int attempts = Engine.GAME_ATTEMPTS;
        final String description = "What number is missing in the progression?";
        String[][] data = new String[attempts][2];

        // generating answers and questions
        for (int i = 0; i < attempts; i++) {
            int[] numbers = generateProgression();
            int missingNumberIndex = Util.generateRandomNumber(0, numbers.length - 1);

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
            data[i][0] = String.valueOf(question);
            data[i][1] = String.valueOf(numbers[missingNumberIndex]);
        }
        Engine.runGame(description, data);
    }

    // creating array of numbers for progression
    public static int[] generateProgression() {
        // progression settings
        final int minNumbersInProgression = 5;
        final int maxNumbersInProgression = 10;
        final int minFirstNumber = 1;
        final int maxFirstNumber = 10;
        final int minStep = 2;
        final int maxStep = 5;

        // calculating parameters for progression
        int numbersInProgression = Util.generateRandomNumber(minNumbersInProgression,
                maxNumbersInProgression);
        int firstNumber = Util.generateRandomNumber(minFirstNumber, maxFirstNumber);
        int step = Util.generateRandomNumber(minStep, maxStep);

        // creating and filling array with numbers
        int[] numbers = new int[numbersInProgression];
        numbers[0] = firstNumber;
        for (int k = 1; k < numbers.length; k++) {
            numbers[k] = numbers[k - 1] + step;
        }
        return numbers;
    }
}
