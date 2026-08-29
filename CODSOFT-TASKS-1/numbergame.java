import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;   // tracks score across rounds
        boolean playAgain = true;

        while (playAgain) {
            // Step 1: Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1; // nextInt(100) gives 0-99, +1 makes it 1-100

            int maxAttempts = 7;   // Step 5: limit attempts
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Step 4: repeat prompting until correct guess or attempts run out
            while (attemptsUsed < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");

                // Basic input validation so the program doesn't crash on bad input
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid whole number.");
                    scanner.next(); // discard the invalid token
                    continue;       // go back to top of loop without using an attempt
                }

                int guess = scanner.nextInt();
                attemptsUsed++;

                // Step 3: compare guess to the number and give feedback
                if (guess == numberToGuess) {
                    guessedCorrectly = true;
                    int pointsThisRound = Math.max(0, (maxAttempts - attemptsUsed + 1) * 10);
                    totalScore += pointsThisRound;
                    System.out.println("Correct! You guessed it in " + attemptsUsed + " attempt(s).");
                    System.out.println("You earned " + pointsThisRound + " points this round.");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attemptsUsed));
                } else {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attemptsUsed));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Your total score so far: " + totalScore);

            // Step 6: ask if the user wants to play another round
            System.out.print("Play again? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }

        // Step 7: final score display
        System.out.println("\nThanks for playing! Final score: " + totalScore);
        scanner.close();
    }
}
