package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {
    public static void startGame() {
        int attempts = Engine.GAME_ATTEMPTS;
        final int minNumbersInProgression = 5;
        final int maxNumbersInProgression = 10;
        final int minFirstNumber = 1;
        final int maxFirstNumber = 10;
        final int minStep = 2;
        final int maxStep = 5;
        final String description = "What number is missing in the progression?";
        String[][] data = new String[attempts][2];

        for (int i = 0; i < attempts; i++) {
            int[] numbers = generateProgression(minNumbersInProgression,
                    maxNumbersInProgression,
                    minFirstNumber, maxFirstNumber,
                    minStep, maxStep);
            int missingNumberIndex = Util.generateRandomNumber(0, numbers.length - 1);

            StringBuilder question = new StringBuilder("Question: ");
            for (int j = 0; j < numbers.length; j++) {
                if (j != missingNumberIndex) {
                    question.append(numbers[j]).append(" ");
                } else {
                    question.append(".. ");
                }
            }

            data[i][0] = String.valueOf(question);
            data[i][1] = String.valueOf(numbers[missingNumberIndex]);
        }
        Engine.runGame(description, data);
    }

    private static int[] generateProgression(int minNumbersInProgression,
                                            int maxNumbersInProgression,
                                            int minFirstNumber, int maxFirstNumber,
                                            int minStep, int maxStep) {
        int numbersInProgression = Util.generateRandomNumber(minNumbersInProgression,
                maxNumbersInProgression);
        int firstNumber = Util.generateRandomNumber(minFirstNumber, maxFirstNumber);
        int step = Util.generateRandomNumber(minStep, maxStep);

        int[] numbers = new int[numbersInProgression];
        numbers[0] = firstNumber;
        for (int k = 0; k < numbers.length; k++) {
            numbers[k] = firstNumber + k * step;
        }
        return numbers;
    }
}
