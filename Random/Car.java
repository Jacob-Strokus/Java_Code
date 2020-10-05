/**
 * Blueprint class to create a Car. Multiple constructors to offer convenience
 * of use.
 * 
 * @author Jacob Strokus
 *
 */
public class Car {

	int yearModel;
	String make;
	int speed;

	Car() {

	}

	/**
	 * @param yearModel
	 *            integer representing the model year of the car.
	 * @param make
	 *            String representing the type of car.
	 * @param speed
	 *            integer representing the car's current speed.
	 */
	Car(int yearModel, String make, int speed) {
		this.yearModel = yearModel;
		this.make = make;
		this.speed = speed;
	}

	/**
	 * @param yearModel
	 *            integer value to hold model year of the car.
	 * @param make
	 *            String representing the type of car.
	 */
	Car(int yearModel, String make) {
		this.yearModel = yearModel;
		this.make = make;
	}

	/**
	 * String to link variable values together in a conscious way.
	 */
	public String toString() {

		return yearModel + " " + make + " is traveling at a speed of " + getSpeed() + ".";
	}

	/**
	 * @return String representing the current speed the car is traveling.
	 */
	public String toStringF() {

		return "Speed: " + getSpeed();
	}

	/**
	 * increase the speed of the car by 5.
	 */
	public void accelerate() {

		speed += 5;
	}

	/**
	 * decrease the speed of the car by 5.
	 */
	public void brake() {

		speed -= 5;
	}

	/**
	 * @return year the car was made.
	 */
	public int getYearModel() {
		return yearModel;
	}

	/**
	 * sets the car's model year.
	 * 
	 * @param yearModel
	 *            integer value to hold model year of the car.
	 */
	public void setYearModel(int yearModel) {
		this.yearModel = yearModel;
	}

	/**
	 * getter for the make of the car.
	 * 
	 * @return String representing the type of car.
	 */
	public String getMake() {
		return make;
	}

	/**
	 * sets the car's type.
	 * 
	 * @param make
	 *            String representing the type of car.
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * getter for the speed of the car.
	 * 
	 * @return current speed of car.
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * sets the speed of the car.
	 * 
	 * @param current
	 *            speed car of car.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
