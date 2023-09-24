import java.io.*;
import java.util.*;

class CodSoftTask1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("          Welcome to the Number Game         ");
        System.out.println("Enter the maximum number of attempts :");
        int maxAttemps = sc.nextInt();
        int totalAttempts = 0;
        int roundsWon = 0;
        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            while (attempts < maxAttemps) {
                System.out.println("Enter the guess in range 1 to 100 :");
                int userGuess = sc.nextInt();
                attempts++;
                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too High! Try again.");
                } else {
                    System.out.println("congratulations! You guessed the number in " + attempts + " attempts");
                    totalAttempts += attempts;
                    roundsWon++;
                    break;
                }
            }
            if (attempts == maxAttemps) {
                System.out.println(
                        "Sorry, you've reachesd the maximum number of attempts. The number was : " + secretNumber);
            }
            System.out.println("Do you want to play another round ? (yes/no) :");
            String anotherChance = sc.next();
            if (!anotherChance.equalsIgnoreCase("yes")) {
                System.out.println("secret Number : " + secretNumber);
                break;
            }
        } while (true);
        if (roundsWon > 0) {
            double avgAttempts = (double) totalAttempts / roundsWon;
            System.out
                    .println("Thanks for playing! You won " + roundsWon + " rounds with an average of " + avgAttempts);
        } else {
            System.out.println("Thanks for playing! you didn't win any round.");
        }
    }
}