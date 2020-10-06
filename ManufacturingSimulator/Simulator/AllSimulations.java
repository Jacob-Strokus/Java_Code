import java.util.Scanner;

/**
 * Driver class to test Manufacturing Simulator.
 * 
 * @author Jacob Strokus
 *
 */
public class AllSimulations {

	/**
	 * Controls the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Machine eagleOne = new Machine(0, null);
		SummaryResult sum = new SummaryResult();

		int choice = -1;
		System.out.println("Welcome to the Jacob's Gizmolio Manufactoring Assistant.");

		while (choice != 6) {

			menu();

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				eagleOne.inputFile();
				break;
			case 2:
				Simulation.runSimFIFO(eagleOne);
				sum.writeText(eagleOne.done, eagleOne.getTotalPenalty());
				eagleOne.done.clear();
				eagleOne.setTotalPenalty(0);
				break;
			case 3:
				Simulation.runSimLIFO(eagleOne);
				sum.writeText(eagleOne.done, eagleOne.getTotalPenalty());
				eagleOne.done.clear();
				eagleOne.setTotalPenalty(0);
				break;
			case 4:
				Simulation.runSimEarliestRequested(eagleOne);
				sum.writeText(eagleOne.done, eagleOne.getTotalPenalty());
				eagleOne.done.clear();
				eagleOne.setTotalPenalty(0);
				break;
			case 5:
				Simulation.runSimLargestPenalty(eagleOne);
				sum.writeText(eagleOne.done, eagleOne.getTotalPenalty());
				eagleOne.done.clear();
				eagleOne.setTotalPenalty(0);
				break;
			case 6:
				System.out.println("Thank you for using Gizmolio Manufactoring Assistant.");
				scan.close();
				System.exit(0);
			}
		}
	}

	/**
	 * Display the menu for the user to select different options.
	 */
	public static void menu() {
		System.out.println("Choose an option below:");
		System.out.println("1: Read in an order file");
		System.out.println("2: Test FIFO");
		System.out.println("3: Test LIFO");
		System.out.println("4: Test Earliest Requested First");
		System.out.println("5: Test Largest Penalty First");
		System.out.println("6: Exit");
		System.out.println("CHOICE:");
	}

}

