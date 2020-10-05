import java.text.NumberFormat;

/**
 * Driver class to demonstrate Money blueprint. Formats output and prints to the
 * console.
 * 
 * @author Jacob Strokus
 *
 */
public class MoneyDriver {

	/**
	 * Controls the flow of the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		NumberFormat nf = NumberFormat.getCurrencyInstance();
		int[] income = { 120000, 193000, 285000, 145000, 256000, 245000, 199000, 257000 };
		Money money = new Money(income);

		System.out.println(money.toString() + " \n");
		System.out.println("Total: " + nf.format(money.total()));
		System.out.println("Min: " + nf.format(money.min()));
		System.out.println("Max: " + nf.format(money.max()));
		System.out.println("Average: " + nf.format(money.average()));
	}

}
