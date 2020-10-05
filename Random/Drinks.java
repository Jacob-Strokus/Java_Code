import java.text.NumberFormat;

/**
 * Blueprint class to create Drinks Objects.
 * 
 * @author Jacob Strokus
 *
 */
public class Drinks {

	NumberFormat nf = NumberFormat.getCurrencyInstance();
	String drinkType;
	char size;
	double costEach;
	int numOrdered;

	/**
	 * @param drinktype
	 * @param size
	 * @param costEach
	 * @param numOrdered
	 */
	public Drinks(String drinkType, char size, double costEach, int numOrdered) {
		super();
		this.drinkType = drinkType;
		this.size = size;
		this.costEach = costEach;
		this.numOrdered = numOrdered;
	}

	public double getTotal() {

		return numOrdered * costEach;
	}

	public String toString() {
		return "You ordered " + numOrdered + " " + size + " " + drinkType + " at " + nf.format(costEach)
				+ " for each drink. The total cost was " + nf.format(getTotal()) + ".";
	}

	public double total() {

		return 0;
	}

	/**
	 * @return the drink type
	 */
	public String getDrinktype() {
		return drinkType;
	}

	/**
	 * @param drinktype the drink type to set
	 */
	public void setDrinktype(String drinktype) {
		this.drinkType = drinktype;
	}

	/**
	 * @return the size
	 */
	public char getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(char size) {
		this.size = size;
	}

	/**
	 * @return the costEach
	 */
	public double getCostEach() {
		return costEach;
	}

	/**
	 * @param costEach the costEach to set
	 */
	public void setCostEach(double costEach) {
		this.costEach = costEach;
	}

	/**
	 * @return the numOrdered
	 */
	public int getNumOrdered() {
		return numOrdered;
	}

	/**
	 * @param numOrdered the numOrdered to set
	 */
	public void setNumOrdered(int numOrdered) {
		this.numOrdered = numOrdered;
	}

}
