import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Blueprint.Order;

/**
 * This class will take all the data gathered from running Simulations and
 * output it to a .csv file that can be added to the database.
 * 
 * @author Jacob Strokus
 *
 */
public class SummaryResult {

	/**
	 * Constructs SummaryResult Objects.
	 */
	public SummaryResult() {

	}

	/**
	 * Outputs data in correct format to be uploaded to the database.
	 * 
	 * @param orders ArrayList of Order Objects.
	 * 
	 */
	public void writeText(List<Order> orders, double d) {
		Frame f = new Frame();
		FileDialog foBox = new FileDialog(f, "Saving Orders File", FileDialog.SAVE);
		foBox.setVisible(true);
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();
		String loc = dirPath + foName;
		File outFile = new File(loc + ".csv");
		PrintWriter out = null;

		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
			// down to here is exactly the same for writing any text file
			// --------------------------------------------------------
			/*
			 * Indices for the following output array 0: Order Number 1: Gizmolio Type 2:
			 * Time to make 3: Full name 4: Potential Penalty 5: Arrival Date 6: Requested
			 * Date 7: Start of Processing 8: End of Processing 9: Penalty
			 * 
			 */
			out.println("Order,Gismolio Type,Time(hrs),Name,Potential Late Penalty"
					+ ",Order Arrival,Requested Date,Start Processing,End Processing,Penalty Accrued");
			// loop through the array list and get each item
			for (int i = 0; i < orders.size(); i++) {
				String[] output = new String[10];
				output[0] = "Order: " + orders.get(i).getOrderNum();
				output[1] = orders.get(i).getG().getColor();
				output[2] = Integer.toString((int) orders.get(i).getG().getTimeToMake());
				output[3] = orders.get(i).getC().getFirstName() + " " + orders.get(i).getC().getLastName();
				output[4] = Double.toString(d);
				output[5] = orders.get(i).getDateRecived().toString();
				output[6] = orders.get(i).getDateDue().toString();
				output[7] = orders.get(i).getStartprocessing().toString();
				output[8] = orders.get(i).getEndProcessing().toString();
				if (orders.get(i).penalty()) {
					output[9] = output[4];
				} else
					output[9] = "0";
				String outputAll = output[0];
				for (int j = 1; j < output.length; j++) {
					outputAll = outputAll + "," + output[j];
				}
				out.println(outputAll);

			}

		}

		catch (IOException io) {
			System.out.println("An IO Exception occurred");
			io.printStackTrace();
		} finally {

			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
