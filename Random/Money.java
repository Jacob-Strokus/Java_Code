/**
 * Blueprint class to calculate the minimum salary, maximum salary, average the
 * salaries, and total up the salaries. ToString method can you be called to
 * print.
 * 
 * @author Jacob Strokus
 *
 */
public class Money {

	int[] salaries = new int[100];

	/**
	 * Default constructor.
	 */
	public Money() {

	}

	/**
	 * Full constructor.
	 * 
	 * @param salaries
	 */
	public Money(int[] salaries) {
		super();
		this.salaries = salaries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String toReturn = "";
		for (int s: salaries) {
			toReturn += s + ", ";
		}
		
		return toReturn;
	}

	/**
	 * Loops through the array to totals up the salaries.
	 * 
	 * @return summation of every salary
	 */
	public double total() {
		double total = 0;
		for (int i = 0; i < salaries.length; i++) {
			total += salaries[i];
		}
		return total;
	}

	/**
	 * Loop through the array and find the minimum salary.
	 * 
	 * @return minimum salary in array.
	 */
	public double min() {

		double min = Integer.MAX_VALUE;
		for (int i = 0; i < salaries.length - 1; i++) {
			if (salaries[i] < min) {
				min = salaries[i];
			}
		}
		return min;
	}

	/**
	 * Loop through the array and find the maximum salary.
	 * 
	 * @return maximum salary in array.
	 */
	public double max() {
		double max = Integer.MIN_VALUE;
		for (int i = 0; i < salaries.length - 1; i++) {
			if (salaries[i] > max) {
				max = salaries[i];
			}
		}
		return max;
	}

	/**
	 * Loop through array and calculate the average of all salaries.
	 * 
	 * @return average of salaries.
	 */
	public double average() {
		double total = 0;
		int count = 0;
		for (int i = 0; i < salaries.length; i++) {
			total += salaries[i];
			count++;
		}
		double average = total / count;
		return average;
	}

	/**
	 * Getter method
	 * 
	 * @return salaries the salary to get.
	 */
	public int[] getSalaries() {
		return salaries;
	}

	/**
	 * Setter method
	 * 
	 * @param salaries
	 *            the salary to set.
	 */
	public void setSalaries(int[] salaries) {
		this.salaries = salaries;
	}

}
