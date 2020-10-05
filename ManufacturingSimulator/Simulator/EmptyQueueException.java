/**
 * Creates an Exception for an empty Queue.
 * 
 * @author Jacob Strokus
 *
 */
public class EmptyQueueException extends Exception {

	/**
	 * A unique serial version Identifier.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Method creates a EmptyQueueException and passes the String message to parent
	 * class.
	 * 
	 * @param message - Message to be paired with exception.
	 */
	public EmptyQueueException(String message) {
		super(message);
	}
}
