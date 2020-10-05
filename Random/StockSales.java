import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Class designed to take in information from the keyboard, keep track of, and
 * calculate commission rates and net profit/loss; print to console.
 * 
 * @author Jacob Strokus
 *
 */
public class StockSales {

	/**
	 * Controls the flow of the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		NumberFormat money = NumberFormat.getCurrencyInstance();

		System.out.println("What is the name of the stock?");
		String name = scan.nextLine();
		System.out.println("What is the purchase cost per share when you purchased the stock?");
		double purchaseCost = scan.nextDouble();
		System.out.println("How many shares were purchased?");
		int numShares = scan.nextInt();
		System.out.println("What is the commission rate in percentage?");
		double commPercent = scan.nextDouble();
		System.out.println("What was the sales cost per share when you sold the stock?");
		double salesCost = scan.nextDouble();

		double boughtStock = purchaseCost * numShares;
		double commissionCalc = (commPercent * boughtStock) / 100;
		double totalAmountPaid = boughtStock + commissionCalc;
		double soldStock = numShares * salesCost;
		double netProfitLoss = soldStock - commissionCalc - boughtStock;

		System.out.println("Amount paid for stock -> " + boughtStock);
		System.out.println("The amount of commission in dollars -> " + commissionCalc);
		System.out.println("Total amount paid for the stock ->" + totalAmountPaid);
		System.out.println("Total value of stock when sold -> " + soldStock);
		//
		if (soldStock > boughtStock) {
			System.out.println(" Your stock of " + name + " made a Net profit of " + money.format(netProfitLoss));
		} else {
			System.out.println("Your stock of " + name + " had a Net loss of " + money.format(netProfitLoss));
		}

		scan.close();
	}

}
