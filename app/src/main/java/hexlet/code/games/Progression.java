package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {

    public static void startGame() {

        Scanner scanner = new Scanner(System.in);

        // determine the parameters of the progression
        final int minNumbersInProgression = 5;
        final int maxNumbersInProgression = 10;

        final int minFirstNumber = 1;
        final int maxFirstNumber = 10;

        final int minStep = 2;
        final int maxStep = 5;

        // greeting and asking user
        Engine.userGreeting();
        System.out.println("What number is missing in the progression?");

        // the mechanism of the game
        for (int i = 0; i < Engine.getGameAttempts(); i++) {

            // progression parameters
            int numbersInProgression = Engine.generateRandomNumber(minNumbersInProgression,
                    maxNumbersInProgression);
            int firstNumber = Engine.generateRandomNumber(minFirstNumber, maxFirstNumber);
            int step = Engine.generateRandomNumber(minStep, maxStep);
            int missingNumberIndex = Engine.generateRandomNumber(0, numbersInProgression - 1);

            // creating and filling array with numbers
            int[] numbers = new int[numbersInProgression];
            numbers[0] = firstNumber;
            for (int k = 1; k < numbers.length; k++) {
                numbers[k] = numbers[k - 1] + step;
            }

            // making a string for user
            System.out.print("Question: ");
            for (int j = 0; j < numbers.length; j++) {
                if (j != missingNumberIndex) {
                    System.out.print(numbers[j] + " ");
                } else {
                    System.out.print(".. ");
                }
            }
            System.out.println();

            // getting answer from user
            String userAnswer = scanner.nextLine();
            System.out.println("Your answer: " + userAnswer);

            // correct answer
            var correctAnswer = Integer.toString(numbers[missingNumberIndex]);

            // checking answer
            Engine.checkAnswer(userAnswer, correctAnswer);
        }
        System.out.println("Congratulations, " + Engine.getUserName() + "!");
    }
}
