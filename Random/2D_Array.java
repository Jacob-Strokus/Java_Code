public class 2D_Array {

	public static void main(String[] args) {

		/*
		 * 2D square matrix with odd dimensions Method named 'printMiddle()' which
		 * accepts the 2D array of items printMiddle's second argument is the size, the
		 * number of rows/columns Should be able to pass it af ints, doubles, or
		 * Strings, and a size as its arguments Program should print the middle row and
		 * middle column of the given odd square array
		 */

		double[][] sample = new double[][] { 
					{ 1.2, 2.2, 3.2, 1.2, 3.3 }, 
					{ 4.1, 5.1, 6.1, 1.3, 3.2 }, 
					{ 3.4, 4.4, 5.4, 1.5, 3.6 },
					{ 7.8, 8.8, 9.8, 1.6, 3.8 },
					{ 4.1, 5.1, 6.1, 1.3, 3.2 },
		};
		
		// print
		printWhole(sample);
		System.out.println("");
		printMiddle(sample);

	}
	
	public static void printWhole(int[][] sample) {
		for(int i=0; i<sample.length; i++) {
			for(int j=0; j<sample[i].length; j++) {
				System.out.print(sample [i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void printWhole(double[][] sample) { // double
		for(int i=0; i<sample.length; i++) {
			for(int j=0; j<sample[i].length; j++) {
				System.out.print(sample [i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void printWhole(String[][] sample) { // string
		for(int i=0; i<sample.length; i++) {
			for(int j=0; j<sample[i].length; j++) {
				System.out.print(sample [i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void printMiddle(int[][] sample) { // integers
		// find the middle ((sample.length - 1) / 2) + 1
		int middleNum = ((sample.length - 1) / 2);

		// print middle row
		System.out.println("Middle Row: ");
		for( int i=0; i<sample.length; i++ ) {
			System.out.println( sample[middleNum] [i] );
		}
		System.out.println("");
		
		// print middle col
		System.out.println("Middle Column: ");
		for( int j=0; j<sample.length; j++ ) { // rows
			System.out.println( sample[j] [middleNum]);
		}
		System.out.println("");

	}
	
	public static void printMiddle(double[][] sample) { // doubles
		// find the middle ((sample.length - 1) / 2) + 1
		int middleNum = ((sample.length - 1) / 2);

		// print middle row
		System.out.println("Middle Row: ");
		for( int i=0; i<sample.length; i++ ) {
			System.out.println( sample[middleNum] [i] );
		}
		System.out.println("");
		
		// print middle col
		System.out.println("Middle Column: ");
		for( int j=0; j<sample.length; j++ ) { // rows
			System.out.println( sample[j] [middleNum]);
		}
		System.out.println("");

	}
	
	public static void printMiddle(String[][] sample) { // Strings
		// find the middle ((sample.length - 1) / 2) + 1
		int middleNum = ((sample.length - 1) / 2);

		// print middle row
		System.out.println("Middle Row: ");
		for( int i=0; i<sample.length; i++ ) {
			System.out.println( sample[middleNum] [i] );
		}
		System.out.println("");
		
		// print middle col
		System.out.println("Middle Column: ");
		for( int j=0; j<sample.length; j++ ) { // rows
			System.out.println( sample[j] [middleNum]);
		}
		System.out.println("");

	}

}
