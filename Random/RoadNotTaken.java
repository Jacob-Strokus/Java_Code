import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RoadNotTaken {

	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<>();

		inputFile(data);
		numWords(data);
		sortData(data);
		search(data);

	}

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

	public static ArrayList<String> inputFile(ArrayList<String> data) {

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
			while (line != null) {

				StringTokenizer t = new StringTokenizer(line, " ");
				while (t.hasMoreTokens()) {
					String words = t.nextToken().trim();
					data.add(words);
				}

				try {
					line = in.readLine();

				} catch (IOException i) {
					i.printStackTrace();
				}

			}

		} catch (InputMismatchException e) {
			System.out.println("Something in file is not correct/");

		}
		return data;
	}

	public static int numWords(ArrayList<String> data) {

		int counter = 0;
		for (String s : data) {
			counter++;
		}
		System.out.println("\nTotal number of words: " + counter + "\n");
		return counter;
	}

	public static void sortData(ArrayList<String> data) {

		Collections.sort(data, String.CASE_INSENSITIVE_ORDER);
		int counter = 0;
		
			System.out.println("Sorted 10 per line:");
			System.out.println("----------------------------------------------");
			for (int i = 0; i < data.size()-1; i++) {
				counter++;
				System.out.print(data.get(counter) + " ");
				if (counter % 10 ==0) {
					System.out.println("\n");
					
				}
				
				// System.out.println(data);
			} // end for

	}

	public static void search(ArrayList<String> data) {

		Scanner scan = new Scanner(System.in);

		boolean more = true;

		while (more) {

			boolean wordFound = false;
			int counter = 0;

			System.out.println("\n----------------------------------------------");
			System.out.println("\nEnter a word to search for: ");
			String ans = scan.nextLine();
			for (String s : data) {
				if (s.length() == (ans.length()) && s.equalsIgnoreCase(ans)) {
					counter++;
					wordFound = true;
				} else {
				}
			} // end for

			if (wordFound == true) {
				System.out.println("Word found!");
			} else {
				System.out.println("Word not found.");
			}
			System.out.println("Number of times " + ans + " appears: " + counter);

			System.out.println("Would you like to search for another word? (true/false)");
			more = scan.nextBoolean();
			scan.nextLine();
		} // end while
		System.out.println("Search concluded. ");
		System.exit(0);
	}
}
