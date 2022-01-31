package QuadraticSort;

public class SortArrayRunner {
	
	public static void main(String[] args) {
		
		int[][] stats500 = new int[10][2];
		
		int avgSwaps = 0;
		int avgComparisons = 0;

		for (int i = 0; i < stats500.length; i++ ) {
			SortArray array = new SortArray(50000, 2);
			array.sort();
			stats500[i][0] = array.getSwaps();
			avgSwaps += array.getSwaps();
			stats500[i][1] = array.getComparisons();
			avgComparisons += array.getComparisons();
		} 

		avgSwaps /= stats500.length;
		avgComparisons /= stats500.length;

		System.out.println("#\tSwaps\tComparisons");
		for ( int i = 0; i < stats500.length; i++ ) {

			System.out.println((i+1) + "\t" + stats500[i][0] + "\t" + stats500[i][1]);

		}

		System.out.println("\nAverage Results -");
		System.out.println("Swaps:\t\t" + avgSwaps);
		System.out.println("Comparisons:\t" + avgComparisons);



		// SortArray array;

		// array = new SortArray(500, 2);
		// System.out.println(array.sort());
		
		// array = new SortArray(5000, 2);
		// System.out.println(array.sort());

		// array = new SortArray(50000, 2);
		// System.out.println(array.sort());

	}

}
