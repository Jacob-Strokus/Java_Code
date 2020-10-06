import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Stack;
import java.util.StringTokenizer;

import Blueprint.Customer;
import Blueprint.Gizmolio;
import Blueprint.Order;

/**
 * This class creates a Machine Object to process Orders.
 * 
 * @author Jacob Strokus
 *
 */
public class Machine {

	/**
	 * Double representing the total penalty added.
	 */
	private double totalPenalty = 0.0;

	/**
	 * Keeps track of the current date and time the machine is running.
	 */
	private LocalDateTime currentDate;

	/**
	 * Create instance of Queue to hold orders Create instance of Stack to hold
	 * orders Create instance of ArrayList to hold orders Create instance of
	 * ArrayList to hold processed orders to write to summary result
	 */
	Queue theQueue = new Queue();
	Stack<Order> theStack = new Stack<>();
	ArrayList<Order> theArrayList = new ArrayList<>();
	ArrayList<Order> done = new ArrayList<>();

	/**
	 * Boolean expression whether machine is processing the first order.
	 */
	private boolean isFirstOrder = true;

	/**
	 * Constructs a machine
	 * 
	 * @param totalPenalty double representing the total penalty added.
	 * @param currentDate
	 *
	 */
	public Machine(double totalPenalty, LocalDateTime currentDate) {
		super();
		this.totalPenalty = totalPenalty;
		this.currentDate = currentDate;
	}

	/**
	 * Method to open a file. Allows the user to pick a file location to read data
	 * from using a file dialog box (file should be a formatted .csv to prevent
	 * errors).
	 * 
	 * @return Returns a buffered reader tied to whatever file the user chose.
	 */
	public static BufferedReader openRead() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for reading your file", FileDialog.LOAD);
		System.out.println(
				"The dialog box will appear behind Eclipse.  " + "\n   Choose where you would like to read from.");
		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		// create a file instance for the absolute path
		File inFile = new File(dirPath + foName);
		if (!inFile.exists()) {
			System.out.println("That file does not exist");
			System.exit(0);
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inFile));
		} catch (IOException e) {
			System.out.println("You threw an exception. ");
		}
		return in;

	}

	/**
	 * Uses a Buffered Reader to load the various important data elements into a a
	 * series of new orders contained in a variety of data structures.
	 */
	public void inputFile() {
		BufferedReader in = null;
		String line = null;

		try {
			in = openRead();
			try {
				in.readLine();
				line = in.readLine();

			} catch (IOException i) {
				i.printStackTrace();
			}

			while (line != null && line != "") {

				StringTokenizer st = new StringTokenizer(line, ",");
				st.nextToken();
				String[] colors = st.nextToken().split(" ");
				String gizmoColor = colors[0];
				int hours = Integer.parseInt(st.nextToken().trim());
				String[] name = st.nextToken().trim().split(" ");
				String firstName = name[0];
				String lastName = name[1];
				int penalty = Integer.parseInt(st.nextToken().trim());
				String[] dateReceived = st.nextToken().trim().split("/");
				String[] year_time = dateReceived[2].trim().split(" ");

				LocalDate d = LocalDate.of(Integer.parseInt(year_time[0]), Integer.parseInt(dateReceived[0]),
						Integer.parseInt(dateReceived[1]));
				LocalTime t = LocalTime.of(Integer.parseInt(year_time[1]) / 100, Integer.parseInt(year_time[1]) % 100);

				LocalDateTime a = LocalDateTime.of(d, t);

				String[] dateDue = st.nextToken().trim().split("/");
				String[] year_time2 = dateDue[2].trim().split(" ");
				LocalDate d2 = LocalDate.of(Integer.parseInt(year_time2[0]), Integer.parseInt(dateDue[0]),
						Integer.parseInt(dateDue[1]));
				LocalTime t2 = LocalTime.of(Integer.parseInt(year_time2[1]) / 100,
						Integer.parseInt(year_time2[1]) % 100);

				LocalDateTime a2 = LocalDateTime.of(d2, t2);
				Order order = new Order(a, a2, new Customer(firstName, lastName, penalty),
						new Gizmolio(gizmoColor, hours), false);

				theQueue.enqueue(order);
				theStack.push(order);
				theArrayList.add(order);

				try {
					line = in.readLine();

				} catch (IOException i) {
					i.printStackTrace();
				}

			}

		} catch (InputMismatchException e) {
			System.out.println("Something in file is not correct/");

		}
	}

	/**
	 * Simulates the creation of a Gizmolio according to the specifications of each
	 * order currently in the queue adds to an arrayList containing all orders
	 * processed over the course of the method.
	 */
	public void processFIFO() {

		int startSize = theQueue.getSize();
		for (int i = 0; i < startSize; i++) {
			System.out.println(i);

			Order currentOrder = theQueue.peek();

			// initializes currentDate on the first pass through the loop
			if (isFirstOrder) {
				currentDate = currentOrder.getDateRecived();
			}
			isFirstOrder = false;

			// moves time forward if the arrival date of the currentOrder hasn't happened
			// yet
			if (currentDate.isBefore(currentOrder.getDateRecived())) {
				currentDate = currentOrder.getDateRecived();
			}

			// Gizmolio is processing...

			Order processedOrder = theQueue.dequeue();

			processedOrder.setStartprocessing(currentDate);

			currentDate = currentDate.plusHours((long) processedOrder.getG().getTimeToMake());

			processedOrder.setStartprocessing(currentDate);

			processedOrder.setEndProcessing(currentDate);
			// Gizmolio finished processing and time has been updated

			// adds the penalty to the running total if the order was not completed before
			// the requested date
			if (currentDate.isAfter(processedOrder.getDateDue())) {
				System.out.println("Penalty added: " + processedOrder.getC().getPenalty());
				totalPenalty += processedOrder.getC().getPenalty();
			}
			done.add(processedOrder);
		}

		/*
		 * if (!theQueue.empty()) { processFIFO(); }
		 */
	}

	/**
	 * Simulates the creation of a Gizmolio according to the specifications of each
	 * order currently in the stack adds to an arrayList containing all orders
	 * processed over the course of the method.
	 */
	public void processLIFO() {
		int startSize = theStack.size();
		for (int i = 0; i < startSize; i++) {
			System.out.println(i);
			Order currentOrder = theStack.peek();

			// initializes currentDate on the first pass through the loop
			if (isFirstOrder) {
				currentDate = currentOrder.getDateRecived();
			}
			isFirstOrder = false;

			// moves time forward if the arrival date of the currentOrder hasn't happened
			// yet
			if (currentDate.isBefore(currentOrder.getDateRecived())) {
				currentDate = currentOrder.getDateRecived();
			}

			// Gizmolio is processing...

			Order processedOrder = theStack.pop();

			processedOrder.setStartprocessing(currentDate);

			currentDate = currentDate.plusHours((long) processedOrder.getG().getTimeToMake());

			processedOrder.setEndProcessing(currentDate);
			// Gizmolio finished processing and time has been updated

			// adds the penalty to the running total if the order was not completed before
			// the requested date
			if (currentDate.isAfter(processedOrder.getDateDue())) {
				System.out.println("Penalty added: " + processedOrder.getC().getPenalty());
				totalPenalty += processedOrder.getC().getPenalty();
			}
			done.add(processedOrder);
		}
	}

	/**
	 * Simulates the creation of a Gizmolio according to the specifications of each
	 * order currently in the ArrayList based on largest penalty first.
	 * 
	 * @param currentDate
	 * @param timeElapsed
	 * @param totalPenalty
	 */
	public void calcLargestPentalty(ArrayList<Order> theArrayList) {

		int largestPenalty = 0;
		Order currentOrder = null;

		for (int i = 0; i < theArrayList.size(); i++) {
			theArrayList.get(i).setStartprocessing(currentDate);
			int penalty = theArrayList.get(i).getC().getPenalty();
			currentDate = theArrayList.get(i).getDateRecived();

			if (penalty > largestPenalty) {
				largestPenalty = penalty;
				currentOrder = theArrayList.get(i);
				done.add(currentOrder);
			}
		}
		System.out.println(currentOrder);

		// if date is before current order, accrue penalty
		if (currentDate.isBefore(currentOrder.getDateRecived())) {
			System.out.println("Penalty added: " + currentOrder.getC().getPenalty());
			totalPenalty += currentOrder.getC().getPenalty();
		}

		// Gizmolio is processing...

		currentOrder.setStartprocessing(currentDate);

		currentDate = currentDate.plusHours((long) currentOrder.getG().getTimeToMake());

		currentOrder.setEndProcessing(currentDate);
		// Gizmolio finished processing and time has been updated

		theArrayList.remove(currentOrder);

		if (currentDate.isAfter(currentOrder.getDateDue())) {
			System.out.println("Penalty added: " + currentOrder.getC().getPenalty());
			totalPenalty += currentOrder.getC().getPenalty();
		}

		if (!theArrayList.isEmpty()) {
			calcLargestPentalty(theArrayList);
		}

	}

	/**
	 * Simulates the creation of a Gizmolio according to the specifications of each
	 * order currently in the ArrayList based on earliest Requested first.
	 * 
	 * @param theArrayList ArrayList of Order Objects.
	 */
	public void proccessEarliestRequested(ArrayList<Order> theArrayList) {

		Order processedOrder = null;
		Collections.sort(theArrayList, (a, b) -> a.getDateDue().compareTo(b.getDateDue()));

		for (int i = 0; i < theArrayList.size(); i++) {
			System.out.println(theArrayList.get(i).getDateDue());
		}
		final int startSize = theArrayList.size();
		for (int i = 0; i < startSize; i++) {
			if (isFirstOrder) {
				currentDate = theArrayList.get(0).getDateRecived();
			}
			isFirstOrder = false;

			if (currentDate.isBefore(theArrayList.get(0).getDateRecived())) {
				currentDate = theArrayList.get(0).getDateRecived();
			}

			processedOrder = theArrayList.remove(0);

			processedOrder.setStartprocessing(currentDate);
			currentDate = currentDate.plusHours((long) processedOrder.getG().getTimeToMake());

			processedOrder.setEndProcessing(currentDate);
			// Gizmolio finished processing and time has been updated

			if (currentDate.isAfter(processedOrder.getDateDue())) {
				System.out.println("Penalty added: " + processedOrder.getC().getPenalty());
				totalPenalty += processedOrder.getC().getPenalty();
			}

			done.add(processedOrder);

		}
	}

	/**
	 * Getter for TotalPenalties accrued.
	 * 
	 * @return accumulator for penalties.
	 */
	public double getTotalPenalty() {
		return totalPenalty;
	}

	/**
	 * Set the value of total penalty.
	 * 
	 * @param totalPenalty takes in a double.
	 */
	public void setTotalPenalty(double totalPenalty) {
		this.totalPenalty = totalPenalty;
	}

}
