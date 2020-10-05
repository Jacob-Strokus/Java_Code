/**
 * Driver class to test code.
 * 
 * @author Jacob Strokus
 *
 */
public class DrinkDriverArray {

	/**
	 * Controls the flow of the program
	 * 
	 * @param args Command=line arguments supplied as an Array of String Objects.
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String ans = "";
		Drinks[] drinks = new Drinks[1000];
		int count = 0;

		while (!ans.equalsIgnoreCase("no")) {
			System.out.println("Enter the type of drink: ");
			String drinkType = scan.nextLine();
			System.out.println("What size? (S, M, L)");
			char size = scan.next().charAt(0);
			while (size != 's' || size != 'm' || size != 'l') {
				System.out.println("Invalid size. Must choose s, m, or l");
				size = scan.next().charAt(0);
				if ((size == 's' || size == 'm' || size == 'l')) {
					break;
				}
			}
			System.out.println("Enter the cost per drink: ");
			double costEach = scan.nextDouble();
			System.out.println("Enter the number of these drinks purchased: ");
			int numOrdered = scan.nextInt();
			Drinks d = new Drinks(drinkType, size, costEach, numOrdered);
			drinks[count] = d;
			count++;
			System.out.println("Enter another drink ordered? (yes/no)");
			ans = scan.nextLine();
			ans = scan.nextLine();
			if (ans.equalsIgnoreCase("no")) {
				break;
			}
		}

		printOrders(drinks, count);
		scan.close();
	}

	public static void printOrders(Drinks[] d, int count) {

		System.out.println("Your orders are: ");
		for (int i = 0; i < count; i++) {
			System.out.println(d[i].toString());
		}
	}

}
