import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0; 
        boolean playAgain = true;
        int roundCount = 0;

        System.out.println("Welcome to the Number Guessing Game! ");
        System.out.printf("You have %d attempts to guess the number between %d and %d.\n", MAX_ATTEMPTS, MIN_RANGE, MAX_RANGE);

        while (playAgain) {
            roundCount++;
            System.out.println("\n--- Starting Round " + roundCount + " ---");
            
           
            Random random = new Random();
            int secretNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attempts = 0;
            boolean correctlyGuessed = false;

            while (attempts < MAX_ATTEMPTS && !correctlyGuessed) {
               
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
                
                if (scanner.hasNextInt()) {
                    int userGuess = scanner.nextInt();
                    attempts++;
                    
                    if (userGuess == secretNumber) {
                        System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts!");
                        totalScore++;
                        correctlyGuessed = true;
                    } else if (userGuess < secretNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else {
                        System.out.println("Too high! Try a lower number.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); 
                }
            }

            if (!correctlyGuessed) {
                System.out.println(" You ran out of attempts! The correct number was: " + secretNumber);
            }
            System.out.println("\n--- Round Summary ---");
            System.out.println("Total Rounds Played: " + roundCount);
            System.out.println("Your Current Score (Rounds Won): " + totalScore);
            System.out.println("---------------------\n");

            System.out.print("Do you want to play another round? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.startsWith("y");
        }

        System.out.println("Thank you for playing! Final Score: " + totalScore + " rounds won.");
        scanner.close();
    }
}
