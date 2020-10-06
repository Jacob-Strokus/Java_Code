import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PDFBoxReadFromFile {

	public static void main(String[] args) {

		ArrayList<String> data = new ArrayList<>();

		populateList(data);
		printList(data);
		mapping(data);

	}// end main

	public static ArrayList<String> populateList(ArrayList<String> data) {

		PDFManager pdfManager = new PDFManager();
		pdfManager.setFilePath("YOUR_FILE_PATH_HERE");
		try {
			String text = pdfManager.toText();
			data.add(text);
		} catch (IOException ex) {
			Logger.getLogger(PDFBoxReadFromFile.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		return data;

	}// end populate

	public static void printList(ArrayList<String> data) {

		for (String s : data) {
			System.out.println(s);
		}
	}// end sort

	public static void mapping(ArrayList<String> data) {

		Map<String, Integer> frequency = new HashMap<>();

		for (String s : data) {
			s.split(" ");
			if (!(s.trim()).equals(" "))
				;
			System.out.println(s);
		}

	}

	private void countWords(final Path file) throws IOException {
		Arrays.stream(new String(Files.readAllBytes(file), StandardCharsets.UTF_8).split("\\W+"))
				.collect(Collectors.groupingBy(Function.<String>identity(), TreeMap::new, counting())).entrySet()
				.forEach(System.out::println);
	}
}
