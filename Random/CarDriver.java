/**
 * Utilizes the car blueprint to assign test values. Demonstrates the connection
 * between blueprint and driver classes. In this demo, create two instances of a
 * Car, assign values, test these values. prints to the console.
 * 
 * @author Jacob Strokus
 *
 */
public class CarDriver {

	/**
	 * Controls the flow of the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		Car car = new Car(2019, "Corvette", 80);
		Car car2 = new Car();

		car2.setMake("Jeep Wrangler");
		car2.setYearModel(2018);
		car2.setSpeed(70);

		System.out.println(car.toString());

		for (int i = 0; i < 5; i++) {
			car.accelerate();
			System.out.println(car.toStringF());
		}

		for (int j = 0; j < 5; j++) {
			car.brake();
			System.out.println(car.toStringF());
		}
	}

}
