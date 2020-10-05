import java.util.Arrays;
import java.util.Scanner;

public class MixedLetters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean more = true;
		while (more) {
			System.out.println("Enter first word: ");
			String firstWord = scan.nextLine();
		
			System.out.println("Enter second word: ");
			String secondWord = scan.nextLine();
			
			if (firstWord.length() != secondWord.length()) {
				System.out.println("Lengths are not same.");
			}
			else if (firstWord.length() == secondWord.length()) {
				char[] word1 = firstWord.toCharArray();
				char[] word2 = secondWord.toCharArray();
				 Arrays.sort(word1);
				 Arrays.sort(word2);
				 if (Arrays.equals(word1, word2)) {
					 System.out.println("Words match!");
				 }
				 else {
					 System.out.println("Words do not match.");
				 }
			}
			
			System.out.println("Want to try more words? (true/false)");
			more = scan.nextBoolean();
			scan.nextLine();
		} // end while
		System.out.println("Bye!");
	}
}
