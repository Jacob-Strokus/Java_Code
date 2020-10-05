import java.util.Scanner;

/**
 * 
 * Reads in a sequence of integers from the keyboard. Keeps track of certain
 * variables. Prints to console.
 * 
 * @author Jacob Strokus
 *
 */
public class Numbers {

	/**
	 * Controls the flow of the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int input = 0;
		int count = 0;
		int smallest = 1000000000;
		int largest = -1000000000;
		int evenTotal = 0;
		int oddTotal = 0;
		int total = 0;
		int previousNum = 0;

		while (input != -999) {

			System.out.println("Enter a number: (enter -999 to quit)");
			input = scan.nextInt();

			if (previousNum == input) {
				System.out.println(previousNum + " and " + input + " are adjacent duplicates!");
			}

			previousNum = input;

			if (input == -999) {
				break;

			} else {
				count++;
				total += input;

				if (input % 2 == 0) {
					evenTotal++;
				} else {
					oddTotal++;
				}

				if (input < smallest) {
					smallest = input;
				} else if (input > largest) {
					largest = input;
				}
			}

		}

		printResults(count, smallest, largest, evenTotal, oddTotal, total, previousNum);
		scan.close();
	}

	/**
	 * Prints results to console
	 * 
	 * @param count       keeps count off all values that were entered
	 * @param smallest    holds smallest number
	 * @param largest     holds largest number
	 * @param evenTotal   keeps count of all even numbers
	 * @param oddTotal    keeps count of all odd numbers
	 * @param total       cumulative total
	 * @param previousNum keeps track of previous number entered
	 * @param dups        list of duplicate words
	 */
	private static void printResults(int count, int smallest, int largest, int evenTotal, int oddTotal, int total,
			int previousNum) {

		System.out.println("Number of values entered: " + count);
		System.out.println("Smallest integer entered: " + smallest);
		System.out.println("Largest integer entered: " + largest);
		System.out.println("Number of even #'s: " + evenTotal);
		System.out.println("Number of odd #'s: " + oddTotal);
		System.out.println("Sum of all numbers entered: " + total);

	}

}
