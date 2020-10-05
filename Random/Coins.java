/**
 * Blueprint class.
 * 
 * @author Jacob Strokus
 *
 */
public class Coins {

	int quarters;
	int dimes;
	int nickels;
	int pennies;

	/**
	 * Default constructor.
	 */
	Coins() {

	}

	/**
	 * Full constructor.
	 * 
	 * @param q
	 *            quarters
	 * @param d
	 *            dimes
	 * @param n
	 *            nickels
	 * @param p
	 *            pennies
	 */
	Coins(int q, int d, int n, int p) {
		this.quarters = q;
		this.dimes = d;
		this.nickels = n;
		this.pennies = p;
	}

	/*
	 *String output to console.
	 */
	@Override
	public String toString() {
		return "Coins [quarters = " + quarters + ", dimes = " + dimes + ", nickels = " + nickels + ", pennies = " + pennies
				+ "]";
	}

	/**
	 * @return double representing the sum of all coins.
	 */
	public double totalValue() {

		return (quarters * .25) + (dimes * .10) + (pennies * .01) + (nickels * .05);
	}

	/**
	 * come back to me, I'm lazy.
	 */
	public void optimalCoins() {

	}

	/**
	 * @return the quarters
	 */
	public int getQuarters() {
		return quarters;
	}

	/**
	 * @param quarters
	 *            the quarters to set
	 */
	public void setQuarters(int quarters) {
		this.quarters = quarters;
	}

	/**
	 * @return the dimes
	 */
	public int getDimes() {
		return dimes;
	}

	/**
	 * @param dimes
	 *            the dimes to set
	 */
	public void setDimes(int dimes) {
		this.dimes = dimes;
	}

	/**
	 * @return the nickels
	 */
	public int getNickels() {
		return nickels;
	}

	/**
	 * @param nickels
	 *            the nickels to set
	 */
	public void setNickels(int nickels) {
		this.nickels = nickels;
	}

	/**
	 * @return the pennies
	 */
	public int getPennies() {
		return pennies;
	}

	/**
	 * @param pennies
	 *            the pennies to set
	 */
	public void setPennies(int pennies) {
		this.pennies = pennies;
	}

}
