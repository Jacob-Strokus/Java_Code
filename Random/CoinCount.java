import java.text.NumberFormat;

/**
 * Utilizes the car blueprint to assign test values. Demonstrates the connection
 * between blueprint and driver classes. In this demo, create an instance of the
 * Coins class and assign values. Test these values and format where needed.
 * Prints to console.
 * 
 * @author Jacob Strokus
 *
 */
public class CoinCount {

	public static void main(String[] args) {

		NumberFormat money = NumberFormat.getCurrencyInstance();

		Coins coins = new Coins(8, 5, 3, 4);

		System.out.println(coins.toString());
		System.out.println(money.format(coins.totalValue()));
	}

}
