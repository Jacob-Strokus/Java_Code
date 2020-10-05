/**
 * Blueprint class to create Customer Objects.
 * 
 * @author Jacob Strokus
 *
 */
public class Customer {

	/**
	 * String literal for customer first name.
	 */
	protected String firstName;

	/**
	 * String literal for customer last name.
	 */
	protected String lastName;

	/**
	 * Penalty to being late.
	 */
	protected int penalty;

	/**
	 * Constructs an instance of a Customer.
	 * 
	 * @param firstName String literal for customer first name.
	 * @param lastName  String literal for customer last name.
	 * @param penalty   Penalty to being late.
	 */
	public Customer(String firstName, String lastName, int penalty) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.penalty = penalty;
	}

	// getters and setters.

	/**
	 * Method to get first name of customer.
	 * 
	 * @return the firstName.
	 */
	protected String getFirstName() {
		return firstName;
	}

	/**
	 * Method to set first name of customer.
	 * 
	 * @param firstName the firstName to set.
	 */
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method to get last name of customer.
	 * 
	 * @return the lastName.
	 */
	protected String getLastName() {
		return lastName;
	}

	/**
	 * Method to set first name of customer.
	 * 
	 * @param lastName the lastName to set.
	 */
	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method to get the penalty.
	 * 
	 * @return the penalty.
	 */
	protected int getPenalty() {
		return penalty;
	}

	/**
	 * Method to set the penalty.
	 * 
	 * @param penalty the penalty to set.
	 */
	protected void setPenalty(int penalty) {
		this.penalty = penalty;
	}

}
