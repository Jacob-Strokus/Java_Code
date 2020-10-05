
/**
 * Class designed to take in information from the keyboard, perform calculations
 * using predetermined algorithm, and print answer to the console.
 * 
 * @author Jacob Strokus
 *
 */
public class VineyardCalc {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int numberOfVines;

		System.out.println("How long is the row (in feet)?");
		int rowLength = scan.nextInt();
		System.out.println("How much space is needed at each end (in feet)?");
		int spaceAtEachEnd = scan.nextInt();
		System.out.println("How much space is in between vines (in feet)?");
		int spaceBetweenVines = scan.nextInt();

		numberOfVines = (rowLength - (2 * spaceAtEachEnd)) / spaceBetweenVines;

		System.out.println("Number of grape vines that will fit in each row: " + numberOfVines);

		scan.close();
	}

}
