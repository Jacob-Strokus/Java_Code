import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class MickeyGone {

	public static void main(String[] args) {

		// Instance of Collator class
		Collator c = Collator.getInstance(Locale.US);
				
		String[] names = {"		MickEy 		", "  mickey", "Mickey", "Donald", " mickey  ", "pluto", "Pluto", "mickey", "   mickey  ",
				"Daisey", " Huey ", "Dewey", "Louie", " Ariel  "," MicKeY", "   mickey ", "Mickey", "Scrouge", " Minnie",
				"Sleepy", "MICKEy", "mIcKEY" };
		ArrayList<String> Names = new ArrayList<>();

		createArrayList(names, Names);
		removeMickey(Names);
		alphaOrder(Names,c);

	}

	// convert the array to an ArrayList<String>
	public static ArrayList<String> createArrayList(String[] names, ArrayList<String> Names) {

		Collections.addAll(Names, names);
		System.out.println(Names); // make sure new ArrayList is populated correctly
		return Names;
	}

	// remove all Mickeys, regardless of case or spacing. It must stay an array list
	public static ArrayList<String> removeMickey(ArrayList<String> Names) {

		// backwards
		for (int i = Names.size() - 1; i > 0; i--) {
			if (Names.get(i).trim().equalsIgnoreCase("mickey")) {
				Names.remove(i);
			}
		}
		// forwards
		for (int j = 0; j < Names.size(); j++) {
			if (Names.get(j).trim().equalsIgnoreCase("mickey")) {
				Names.remove(j);
			}
		}
		System.out.println("\nNames without Mickey:");
		System.out.println( Names + "\n");
		return Names;
	}

	// print the remaining Disney characters alphabetically
	public static void alphaOrder(ArrayList<String> Names, Collator c) {
		
		System.out.println("Sorted:");
		for (int i = 0; i < Names.size(); i++) {
			Names.get(i).trim();
			Collections.sort(Names, c);
			System.out.print(Names.get(i).trim() + " ");

		}
	}
}
