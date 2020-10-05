/**
 * Used to run simulations.
 * 
 * @author Jacob Strokus
 *
 */
public class Simulation {

	/**
	 * Instance of SummaryResult Object to output data to the database.
	 */
	SummaryResult sum = new SummaryResult();

	/**
	 * Instance of Machine that will be used to process simulations.
	 */
	Machine eagleOne = new Machine(0, null);

	/**
	 * Launches simulation methods.
	 * 
	 * @param args     Command-line arguments supplied as an Array of String
	 *                 Objects.
	 * @param eagleOne The machine that will process the simulations.
	 */
	public static void main(String args[], Machine eagleOne) {

		eagleOne.inputFile();

		runSimEarliestRequested(eagleOne);

		runSimLargestPenalty(eagleOne);

		runSimFIFO(eagleOne);

		// runSimInOrderTree(eagleOne); Not implemented.

		// runSimPreOrderTree(eagleOne); Not implemented.

		// runSimPostOrderTree(eagleOne); Not implemented.

		runSimLIFO(eagleOne);

	}

	/**
	 * Method call to launch Queue simulation.
	 * 
	 * @param eagleOne Machine that will be used to process simulations.
	 */
	public static void runSimFIFO(Machine eagleOne) {

		eagleOne.processFIFO();

		System.out.println("\nTotal Penalty Applied: " + eagleOne.getTotalPenalty());

	}

	/**
	 * Method call to launch stack simulation.
	 * 
	 * @param eagleOne Machine that will be used to process simulations.
	 */
	public static void runSimLIFO(Machine eagleOne) {

		eagleOne.processLIFO();

		System.out.println("\nTotal Penalty Applied: " + eagleOne.getTotalPenalty());
	}

	/**
	 * Method call to launch largest penalty simulation.
	 * 
	 * @param eagleOne Machine that will be used to process simulations.
	 */
	public static void runSimLargestPenalty(Machine eagleOne) {

		eagleOne.calcLargestPentalty(eagleOne.theArrayList);

		System.out.println("\nTotal Penalty Applied: " + eagleOne.getTotalPenalty());

	}

	/**
	 * Method call to launch earliest requested simulation.
	 * 
	 * @param eagleOne Machine that will be used to process simulations.
	 */
	public static void runSimEarliestRequested(Machine eagleOne) {

		for (int i = 0; i < eagleOne.theArrayList.size(); i++) {
			System.out.println(eagleOne.theArrayList.get(i));
		}

		System.out.println("\nBefore sorting due dates (dates requested)\n");
		for (int i = 0; i < eagleOne.theArrayList.size(); i++) {
			System.out.println(eagleOne.theArrayList.get(i).getDateDue());
		}

		System.out.println("\n----------------------------\n");

		System.out.println("\nAfter sorting due dates (dates requested)\n");
		eagleOne.proccessEarliestRequested(eagleOne.theArrayList);

		System.out.println("\nTotal Penalty Applied: " + eagleOne.getTotalPenalty());

	}

}
