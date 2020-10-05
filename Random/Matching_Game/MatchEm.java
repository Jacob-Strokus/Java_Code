import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Welcome to the Casino! Program randomly generates three numbers, twenty
 * times. The user has to bet on if they will have any matches. one match = win
 * their original bet amount; match all three = triple their original bet
 * pay-out; no matches = lose twice their original bet. The program keeps track
 * of the user's current holdings, and any, all, or no matches. Prints to
 * console.
 * 
 * @author Jacob Strokus
 *
 */
public class MatchEm {

	/**
	 * Controls the flow of the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		NumberFormat money = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		int currentBet = 0;
		int originalBet = 0;

		System.out.println("Hello! Welcome to the casino. Here you can bet on one of our state of the art number games."
				+ "\nWould you like to place a bet? (yes/no)");
		String offer = scan.nextLine();

		if (offer.equalsIgnoreCase("YES")) {
			System.out.println("How much? (answer in US dollars)");
			currentBet = scan.nextInt();
			originalBet = currentBet;
		} else {
			System.out.println("We are a casino not a charity! Place a bet or leave!\n");
			main(args);
		}
		int oneMatch = 0;
		int count3Match = 0;
		int NoMatch = 0;

		Random r = new Random();
		System.out.println("You bet :" + money.format(currentBet) + "\n");

		for (int i = 0; i < 10; i++) {

			int r1 = r.nextInt(5);
			int r2 = r.nextInt(5);
			int r3 = r.nextInt(5);

			System.out.println(r1 + " " + r2 + " " + r3);

			if (r1 == r2 && r2 == r3 && r1 == r3) {
				count3Match++;
				currentBet += originalBet * 3;
			}
			if (r1 == r2 || r1 == r3 || r2 == r3) {
				oneMatch++;
				currentBet += originalBet;
			} else if (r1 != r2 && r1 != r3 && r2 != r3) {
				NoMatch++;
				currentBet -= originalBet * 2;
			}
		}

		System.out.println("Number of times there were no matches: " + NoMatch);
		System.out.println("Number of matches: " + oneMatch);
		System.out.println("Number of all three numbers matching: " + count3Match);

		if (currentBet > originalBet) {
			System.out.println("\nCongratulations! you made a profit! current holdings: " + money.format(currentBet));
		}
		if (currentBet < originalBet) {
			System.out.println("\nYou are in debt to the casino. Pay now and leave! current holdings: "
					+ money.format(currentBet));
		}
		if (currentBet == originalBet) {
			System.out.println("\nSorry, you broke even.. better luck next time.");
		}
		scan.close();
	}

}
