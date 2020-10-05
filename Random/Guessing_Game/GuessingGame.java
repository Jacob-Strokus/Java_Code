import java.util.Random;
import java.util.Scanner;

/**
 * Do you think you have what it takes to guess the mystery number? This
 * programs takes in information from the keyboard and compares the user's entry
 * against the randomly generated computer's entry. If they are a match, game
 * over. User has to keep guessing until they guess correctly. Lists the amount
 * of tries the user took, and asks if they wish to keep playing. Prints to
 * console.
 * 
 * @author Jacob Strokus
 *
 */

public class GuessingGame {

	/**
	 * Controls the flow of the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		String input = "";
		String quit = "no";
		int numGuess = 0;
		int myNumber = r.nextInt(8);
		int guess = 0;

		System.out.println("I bet you can't guess my number. Go on, Guess!");

		while (!input.equalsIgnoreCase(quit)) {

			guess = 0;
			numGuess = 0;

			while (guess != myNumber) {

				System.out.println("Enter your guess: (0-10)");
				guess = scan.nextInt();
				numGuess++;
				if (guess == myNumber) {
					break;
				} else if (guess < myNumber) {
					System.out.println("Your guess was low. Try again!");
				} else {
					System.out.println("Your guess was high. Try again!");
				}

			} // inner while

			System.out.println("You got it! it took you " + numGuess + " tries.");
			System.out.println("Would you like to play again? (yes/no)");
			input = scan.nextLine();
			input = scan.next();
		} // outer while

		System.out.println("That was fun! See you later!");
		scan.close();
	}

}
