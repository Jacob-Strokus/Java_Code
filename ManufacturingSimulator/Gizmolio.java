/**
 * Blueprint class to create Gizmolio Objects.
 * 
 * @author Jacob Strokus
 *
 */
public class Gizmolio {

	/**
	 * String literal representing the color of the Gizmolio.
	 */
	private String color;

	/**
	 * Double representing the time to make a Gizmolio of that color.
	 */
	private double timeToMake;

	/**
	 * Constructs an instance of a Gizmolio.
	 * 
	 * @param color      gizmolio color.
	 * @param timeToMake the time to make.
	 */
	public Gizmolio(String color, double timeToMake) {
		super();
		this.color = color;
		this.timeToMake = timeToMake;
	}

	/**
	 * Method to get the color.
	 * 
	 * @return the color.
	 */
	protected String getColor() {
		return color;
	}

	/**
	 * Method to set the color.
	 * 
	 * @param color the color to set.
	 */
	protected void setColor(String color) {
		this.color = color;
	}

	/**
	 * Method to get the time.
	 * 
	 * @return the timeToMake.
	 */
	protected double getTimeToMake() {
		return timeToMake;
	}

	/**
	 * Method to set the time.
	 * 
	 * @param timeToMake the timeToMake to set.
	 */
	protected void setTimeToMake(double timeToMake) {
		this.timeToMake = timeToMake;
	}

}
