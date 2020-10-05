import java.util.Random;
import java.util.Scanner;

public class Colors {

	/**
	 * Controls the flow of the program.
	 * 
	 * @param args Command-line arguments supplied as an Array of String Objects.
	 */
   public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		for (int i = 0; i < 10; i++) {
			
			int red = r.nextInt(4);
			int yellow = r.nextInt(4);
			int blue = r.nextInt(4);
			int green = r.nextInt(4);
			
			System.out.println("Enter a color: (Green, Yellow, Blue, Red)");
			String guess = scan.nextLine();
			
			
		}
		
		
		scan.close();
	}

}
