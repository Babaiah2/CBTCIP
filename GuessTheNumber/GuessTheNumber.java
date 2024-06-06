import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain;

        do {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to 'Guess the Number'!");
            System.out.println("I have chosen a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.println("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "):");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number.");
                    score += (maxAttempts - attempts + 1) * 10;
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher. Try again.");
                } else {
                    System.out.println("The number is lower. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was: " + randomNumber);
            }

            System.out.println("Your score: " + score);
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = sc.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thank you for playing! Your final score: " + score);
        sc.close();
    }
}
