package RadixSort;

public class RadixSortRunner {

	public static void main(String[] args) {

		RadixSort array = new RadixSort(50);
		System.out.println("Original List -\n" + array);
		array.setArray(RadixSort.radixSort(array.getArray()));
		System.out.println("\nSorted List -\n" + array);

	}

}
