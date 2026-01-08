// task 1 :
// Number Game :


import java.util.Scanner; 
import java.util.Random;   

public class task_1 { 

    public static void playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; 
        int attemptsAllowed = 7;
        int attemptsTaken = 0;
        boolean hasWon = false;

        System.out.println(" I have picked a number between 1 and 100.");
        
        while (attemptsTaken < attemptsAllowed) {
            System.out.print("Attempt " + (attemptsTaken + 1) + "/" + attemptsAllowed + ": Take a guess: ");
            
            int guess;
            // Input validation
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number!");
                continue;
            }
            
            attemptsTaken++;

            if (guess < numberToGuess) {
                System.out.println(" Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println(" Too high! Try again.");
            } else {
                hasWon = true;
                System.out.println(" Congratulations! You guessed the number in " + attemptsTaken + " attempts!");
                break;
            }
        }

        if (!hasWon) {
            System.out.println(" Sorry! You've used all " + attemptsAllowed + " attempts. The number was " + numberToGuess + ".");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println(" Welcome to the Number Guessing Game!");

        while (true) {
            roundsPlayed++;
            System.out.println("\n▶ Starting Round " + roundsPlayed);

            playGame(scanner);

            System.out.print(" Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\n Game Over!");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Thanks for playing! ");

        scanner.close();
    }
}
