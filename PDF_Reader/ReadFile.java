import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Map<String, Integer> frequency = new HashMap<>();

		boolean more = true;
		while (more) {
			try {
				inputFile(frequency);
				mostFrequent(frequency);
				saveFile(frequency);
				System.out.println("Another file? (true/false)");
				more = scan.nextBoolean();
			} catch (IOException e) {
				e.printStackTrace();
			}

			scan.nextLine();
		} // end while

		System.exit(0);
	}

	private static BufferedReader openRead() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for reading your file", FileDialog.LOAD);

		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		String abPath = dirPath + foName; // good oop practice

		// create a file instance for the absolute path
		File inFile = new File(abPath);
		if (!inFile.exists()) {
			System.out.println("That file does not exist");
			System.exit(0);
		}
		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader(inFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return in;

	}

	private static Map<String, Integer> inputFile(Map<String, Integer> frequency) throws IOException {

		BufferedReader in = null;
		String line = null;
		try {
			in = openRead();

			in.readLine();
			line = in.readLine();

			while (line != null) {
				System.out.println(line);

				if (!(line.trim().equals(" "))) {
					String[] words = line.split(" ");

					for (String word : words) {

						if (word.equals(null) || word.equals(" ")) { // if word is null or a space skip it
							continue;
						}
						String processed = word.trim().toLowerCase();

						if (frequency.containsKey(processed)) {

							frequency.put(processed, frequency.get(processed + 1)); // if word appears more than once,
														// increment the count

						} else {
							frequency.put(processed, 1); // if it doesn't appear more than once, assign it the value of
											// 1
						}

					} // end for
				}
				line = in.readLine(); // read in the next line

			} // end while
		} finally {
			in.close();
		}

		System.out.println(frequency); // check

		return frequency;
	}

	private static void mostFrequent(Map<String, Integer> frequency) {

		int mostFrequentlyUsedWord = 0; // Occurrence
		String theWord = null; // each word

		for (String word : frequency.keySet()) {

			System.out.println(frequency.get(word));

			Integer theVal = Integer.valueOf(frequency.get(word));

			if (theVal > mostFrequentlyUsedWord) {
				mostFrequentlyUsedWord = theVal;
				theWord = word;
			}
		}

		System.out.println();
		System.out.printf("The word that appeared the most frequently is '%s', %d times ", theWord,
				mostFrequentlyUsedWord);
	}

	private static PrintWriter openWrite() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for writing your file", FileDialog.SAVE);
		System.out.println("Choose where to save the file");

		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		// create a file instance for the absolute path
		File outFile = new File(dirPath + foName);
		PrintWriter out = null;

		try {
			out = new PrintWriter(outFile);
		} catch (IOException e) {
			System.out.println("You threw an exception");
		}
		return out;
	}

	private static void saveFile(Map<String, Integer> frequency) {
		PrintWriter a1 = null;
		try {
			a1 = openWrite();
			for (int i = 0; i < frequency.size(); i++) {
				a1.println(frequency);
			}
		} finally {
			try {
				a1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
