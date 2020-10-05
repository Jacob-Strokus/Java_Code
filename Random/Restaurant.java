import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Class designed to take information in from keyboard and calculate the tip you
 * would leave at a restaurant. Prints to console.
 * 
 * @author Jacob Strokus
 *
 */
public class Restaurant {

	public static void main(String[] args) {

		NumberFormat money = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);

		final double tax = 6.75;

		System.out.println("How much was your meal?");
		double amountPaid = scan.nextDouble();
		System.out.println("How much would you like to leave as a tip? (Answer in percentage)");
		int tip = scan.nextInt();

		double taxCalc = (amountPaid * tax) / 100;
		double tipCalc = (amountPaid * tip) / 100;
		double totalBill = amountPaid + tipCalc + taxCalc;

		System.out.println("Your meal cost " + money.format(amountPaid) + " before tax and gratuity applied.");
		System.out.println("You paid " + tip + "% or " + tipCalc + " as a tip.");
		System.out.println("You paid " + tax + "% or " + taxCalc + " in tax.");
		System.out.println("Your meal cost " + money.format(totalBill) + " after tax and gratuity applied.");

		scan.close();
	}

}
