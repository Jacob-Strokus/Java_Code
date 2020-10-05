import java.util.Scanner;

/**
 * Here is a short program to test if a 3 digit number is an Armstrong number.
 * numbers are taken in from keyboard and tested, results are printed to the
 * console
 * 
 * @author Jacob Strokus
 *
 */
public class Armstrong {

	/**
	 * Controls the flow of the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		int number = 0;
		int countWinners = 0;
		int countLosers = 0;

		while (number != -999) {
			System.out.println("Enter a 3 digit number to test:  (Enter -999 to quit)");
			number = new Scanner(System.in).nextInt();

			if (number == -999) {
				break;
			}

			if (number > 999 || number > 1 && number <= 99) {

				System.out.println("You MUST enter a 3 digit number.\n");

			} else if (!isArmStrong(number) || number == 0) {

				System.out.println(number + " is not an Armstrong number.\n");
				countLosers++;

			} else if (isArmStrong(number)) {

				System.out.println(number + " is an Armstrong number.\n");
				countWinners++;
			}
		}

		printReport(countWinners, countLosers);
	}

	/*
	 * @return true if number is an Armstrong number if not return false
	 */
	private static boolean isArmStrong(int number) {
		int result = 0;
		int currentNumber = number;
		while (number != 0) {
			int remainder = number % 10;
			result = result + remainder * remainder * remainder;
			number = number / 10;
		}

		if (currentNumber == result) {
			return true;
		}

		return false;
	}

	/**
	 * print a report of all numbers that passed the test
	 * 
	 * @param armstrongNumbers is an arrayList of every number entered that was
	 *                         proven to be an Armstrong number
	 */
	public static void printReport(int winners, int losers) {

		System.out.println("# of Armstrong numbers: " + winners);
		System.out.println("# of non-Armstrong numbers: " + losers);
	}

}
