import java.time.LocalDateTime;

/**
 * Blueprint class to create Order Objects.
 * 
 * @author Jacob Strokus
 *
 */
public class Order {

	// fields
	/**
	 * The date the order was received.
	 */
	protected LocalDateTime dateRecived;

	/**
	 * The due date of the order.
	 */
	protected LocalDateTime dateDue;

	/**
	 * When the process started.
	 */
	protected LocalDateTime startprocessing = null;

	/**
	 * When the process ended.
	 */
	protected LocalDateTime endProcessing = LocalDateTime.of(2018, 1, 1, 0, 0);

	/**
	 * Integer representing the order number.
	 */
	protected int orderNum;

	/**
	 * Boolean expression whether a penalty was added.
	 */
	protected boolean penaltyAcrued = false;

	/**
	 * Counter for the number of instances.
	 */
	protected static int instanceCounter = 1;

	// instances

	/**
	 * Customer Object instance.
	 */
	protected Customer c = new Customer("John", "Doe", 150);

	/**
	 * Gizmolio Object instance.
	 */
	protected Gizmolio g = new Gizmolio("Red", 6.45);

	/**
	 * Constructs an order with following parameters.
	 * 
	 * @param dateRecived Date at which order was received
	 * @param dateDue     Date at which order is due
	 * @param c           instance of Customer
	 * @param g           instance of Gizmolio
	 */
	public Order(LocalDateTime dateRecived, LocalDateTime dateDue, Customer c, Gizmolio g, boolean penaltyAcrued) {
		super();
		this.dateRecived = dateRecived;
		this.dateDue = dateDue;
		this.c = c;
		this.g = g;
		this.penaltyAcrued = penaltyAcrued;
		orderNum = instanceCounter;
		instanceCounter++;
	}

	/**
	 * checks to see if a penalty was applied.
	 * 
	 * @return true if penalty is valid.
	 */
	public boolean penalty() {

		if (endProcessing.isAfter(dateDue)) {
			return true;
		}

		return false;

	}

	/**
	 * Prints out first name, last name, penalty id late, and color of Gizmolio.
	 * 
	 * @return String literal representing the data.
	 */
	public String toString() {
		return c.firstName + " " + c.lastName + " | color: " + g.getColor() + " | Penalty if late: " + c.getPenalty();
	}

	/**
	 * Method to get the date the order was received.
	 * 
	 * @return the dateRecived.
	 */
	protected LocalDateTime getDateRecived() {
		return dateRecived;
	}

	/**
	 * Method to set the date the order was received.
	 * 
	 * @param dateRecived the dateRecived to set.
	 */
	protected void setDateRecived(LocalDateTime dateRecived) {
		this.dateRecived = dateRecived;
	}

	/**
	 * Method to get the due date of the order.
	 * 
	 * @return the dateDue.
	 */
	protected LocalDateTime getDateDue() {
		return dateDue;
	}

	/**
	 * Method to set the due date of the order.
	 * 
	 * @param dateDue the dateDue to set.
	 */
	protected void setDateDue(LocalDateTime dateDue) {
		this.dateDue = dateDue;
	}

	/**
	 * Method to get the time when processing started.
	 * 
	 * @return the startprocessing.
	 */
	protected LocalDateTime getStartprocessing() {
		return startprocessing;
	}

	/**
	 * Method to set the time when processing started.
	 * 
	 * @param startprocessing the startprocessing to set.
	 */
	protected void setStartprocessing(LocalDateTime startprocessing) {
		this.startprocessing = startprocessing;
	}

	/**
	 * Method to get when the processing finished.
	 * 
	 * @return the endProcessing.
	 */
	protected LocalDateTime getEndProcessing() {
		return endProcessing;
	}

	/**
	 * Method to set when the processing finished.
	 * 
	 * @param endProcessing the endProcessing to set.
	 */
	protected void setEndProcessing(LocalDateTime endProcessing) {
		this.endProcessing = endProcessing;
	}

	/**
	 * Method to get the order's identifier.
	 * 
	 * @return the orderNum.
	 */
	protected int getOrderNum() {
		return orderNum;
	}

	/**
	 * Method to set the order's identifier.
	 * 
	 * @param orderNum the orderNum to set.
	 */
	protected void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * Method to check if a penalty was added.
	 * 
	 * @return the penaltyAcrued.
	 */
	protected boolean isPenaltyAcrued() {
		return penaltyAcrued;
	}

	/**
	 * Method to set the penalty.
	 * 
	 * @param penaltyAcrued the penaltyAcrued to set.
	 */
	protected void setPenaltyAcrued(boolean penaltyAcrued) {
		this.penaltyAcrued = penaltyAcrued;
	}

	/**
	 * Method to get the number of instances.
	 * 
	 * @return the instanceCounter.
	 */
	protected static int getInstanceCounter() {
		return instanceCounter;
	}

	/**
	 * Method to set the number of instances.
	 * 
	 * @param instanceCounter the instanceCounter to set.
	 */
	protected static void setInstanceCounter(int instanceCounter) {
		Order.instanceCounter = instanceCounter;
	}

	/**
	 * Method to get the instance of the Customer Object.
	 * 
	 * @return the c.
	 */
	protected Customer getC() {
		return c;
	}

	/**
	 * Method to set the instance of the Customer Object.
	 * 
	 * @param c the c to set
	 */
	protected void setC(Customer c) {
		this.c = c;
	}

	/**
	 * Method to get the instance of the Gizmolio Object.
	 * 
	 * @return the g.
	 */
	protected Gizmolio getG() {
		return g;
	}

	/**
	 * Method to set the instance of the Gizmolio Object.
	 * 
	 * @param g the g to set.
	 */
	protected void setG(Gizmolio g) {
		this.g = g;
	}

}
