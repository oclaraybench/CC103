import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        String choice;

        do {
            int secretNum = r.nextInt(100) + 1;
            int attempts = 0;
            boolean win = false;

            System.out.println("\nHello, " + name + "!");
            System.out.println("Guess a number between 1 and 100 (10 attempts)");

            while (attempts < 10) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Invalid input!");
                    continue;
                }

                attempts++;

                if (guess == secretNum) {
                    System.out.println("Correct! You guessed it in " + attempts + " tries.");
                    win = true;
                    break;
                } else if (guess < secretNum) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!win) {
                System.out.println("Game Over! The number was " + secretNum);
            }

            // Simple rating
            if (attempts == 1) System.out.println("Rating: Perfect!");
            else if (attempts <= 3) System.out.println("Rating: Excellent!");
            else if (attempts <= 6) System.out.println("Rating: Good job!");
            else System.out.println("Rating: Nice try!");

            System.out.print("Play again? (Y/N): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        sc.close();
    }
}