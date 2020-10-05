/**
 * Merge two integer arrays in ascending order. Prints to console.
 * 
 * @author Jacob Strokus
 *
 */
public class MergeArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 3, 6, 10, 14, 21 };
		int[] b = { 24, 15, 13, 12, 5, 2, 1 };
		int[] c = mergeArrays(a, b);
		printResults(c);

	}

	/**
	 * prints new integer array to console.
	 * 
	 * @param c
	 *            integer array
	 */
	private static void printResults(int[] c) {

		for (int nums : c) {
			System.out.print(nums + " ");
		}
	}

	/**
	 * Merge two integer arrays together from least to greatest.
	 * 
	 * @param a
	 *            first integer array
	 * @param b
	 *            second integer array
	 * @return new integer array (c)
	 */
	private static int[] mergeArrays(int[] a, int[] b) {

		int[] c = new int[a.length + b.length];
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
			count++;
		}

		for (int j = 0; j < b.length; j++) {
			c[count++] = b[j];
		}

		for (int i = 0; i < c.length; i++) {
			for (int j = i + 1; j < c.length; j++) {
				if (c[i] > c[j]) {
					int temp = c[i];
					c[i] = c[j];
					c[j] = temp;
				}
			}
		}

		return c;
	}

}
