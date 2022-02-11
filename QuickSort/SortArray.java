package QuadraticSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Creates an integer Array then sorts that array
 * 
 * @author 	William Rice <william@wrice.dev>
 * 
 */
public class SortArray {
	
	private int[] intArray;
	private int swaps;
	private int comparisons;



	// ####################
	// ##                ##
	// ##  Constructors  ##
	// ##                ##
	// ####################

	/**
	 * Creates an array of length 10 in ascending order
	 */
	public SortArray() {
		this.intArray = genAscendingArray(10);
	}

	/**
	 * Creates an array of a given length in ascending order
	 * 
	 * @param arrayLength The length of the array
	 */
	public SortArray(int arrayLength) {
		this.intArray = genAscendingArray(arrayLength);
	}

	/**
	 * Creates an array of a given length in a given order
	 * 
	 * @param arrayLength The length of the array
	 * @param direction The direction the array is filled (0 -> Ascending, 1 -> Descending, 2 -> Random)
	 */
	public SortArray(int arrayLength, int direction) {
		
		if (direction == 0) {
			this.intArray = genAscendingArray(arrayLength);
		}
		else if (direction == 1) {
			this.intArray = genDescendingArray(arrayLength);
		}
		else {
			this.intArray = genRandomArray(arrayLength);
		}

	}



	// #####################
	// ##                 ##
	// ##  Create Arrays  ##
	// ##                 ##
	// #####################

	/**
	 * Generates an array of a given length in ascending order
	 * 
	 * @param length The length of the array
	 * @return Array of Integers
	 */
	public int[] genAscendingArray(int length) {
		int[] newArray = new int[length];

		for (int i = 0; i < length; i++) {
			newArray[i] = i;
		}

		return newArray;
	}

	/**
	 * Generates an array of a given length in descending order
	 * 
	 * @param length The length of the array
	 * @return Array of Inegers
	 */
	public int[] genDescendingArray(int length) {
		int[] newArray = new int[length];

		for (int i = 0; i < length; i++) {
			newArray[i] = length - 1 - i;
		}

		return newArray;
	}

	/**
	 * Generates an array of a given length in random order
	 * 
	 * @param length The length of the array
	 * @return Array of Integers
	 */
	public int[] genRandomArray(int length) {
		int[] newArray = new int[length];

		for (int i = 0; i < length; i++) {
			newArray[i] = (int) (Math.random()*length);
		}

		return newArray;
	}



	// #########################
	// ##                     ##
	// ##  Getters / Setters  ##
	// ##                     ##
	// #########################

	/**
	 * Returns Swaps
	 * @return Swaps
	 */
	public int getSwaps() {
		return this.swaps;
	}

	/**
	 * Sets Swaps
	 * @param swaps Swaps
	 */
	public void setSwaps(int swaps) {
		this.swaps = swaps;
	}

	/**
	 * Gets Comparisons
	 * @return Comparisons
	 */
	public int getComparisons() {
		return this.comparisons;
	}

	/**
	 * Sets Comparisons
	 * @param comparisons Comparisons
	 */
	public void setComparisons(int comparisons) {
		this.comparisons = comparisons;
	}

	/**
	 * Gets Array
	 * @return Integer Array
	 */
	public int[] getArray() {
		return this.intArray;
	}

	/**
	 * Sets Array
	 * @param intArray Integer Array
	 */
	public void setArray(int[] intArray) {
		this.intArray = intArray;
	} 

	/**
	 * Returns the String Form of the Array
	 */
	public String toString() {
		return Arrays.toString(this.intArray);
	}



	// #########################
	// ##                     ##
	// ##  Sorting Algorthim  ##
	// ##                     ##
	// #########################

	/**
	 * Sorts an array in increasing order using bubbleSort
	 * @return # of Swaps & Comparisons
	 */
	public String sort() {
		this.intArray = bubbleSort(this.intArray);

		return (this.intArray.length + " Items\nSwaps:\t\t" + this.swaps + "\nComparisons:\t" + this.comparisons + "\n");
	}

	/**
	 * Sorts an array in a given order using bubbleSort
	 * @param direction Order to sort (0 -> Increasing, 1 -> Decreasing)
	 * @return # of Swaps & Comparisons
	 */
	public String sort(int direction) {

		if (direction == 0) {
			this.intArray = bubbleSort(this.intArray);
		}
		else {
			this.intArray = reverseBubbleSort(this.intArray);
		}

		return (this.intArray.length + " Items\nSwaps:\t\t" + this.swaps + "\nComparisons:\t" + this.comparisons + "\n");
	}

	/**
	 * 
	 * Sorts a given array in increasing order
	 * 
	 * @param unsortedArray Unsorted Array
	 * @return Sorted Integer Array 
	 */
	private int[] bubbleSort(int[] unsortedArray) {

		for (int i = 0; i < unsortedArray.length - 1; i++) {

			for (int j = 0; j < unsortedArray.length - 1 - i; j++) {
				
				this.comparisons++;
				if (unsortedArray[j] > unsortedArray[j+1]) {
					this.swaps++;
					int k = unsortedArray[j+1];
					unsortedArray[j+1] = unsortedArray[j];
					unsortedArray[j] = k;
				}

			}

		}

		return unsortedArray;
	}

	/**
	 * 
	 * Sorts a given array in decresing order
	 * 
	 * @param unsortedArray Unsorted Array
	 * @return Sorted Integer Array
	 */
	private int[] reverseBubbleSort(int[] unsortedArray) {
		
		for (int i = 0; i < unsortedArray.length - 1; i++) {

			for (int j = 0; j < unsortedArray.length - 1 - i; j++) {

				this.comparisons++;
				if (unsortedArray[unsortedArray.length - (j+1)] > unsortedArray[unsortedArray.length - (j+2)]) {
					this.swaps++;
					int k = unsortedArray[unsortedArray.length - (j+2)];
					unsortedArray[unsortedArray.length - (j+2)] = unsortedArray[unsortedArray.length - (j+1)];
					unsortedArray[unsortedArray.length - (j+1)] = k;
				}

			}

		}

		return unsortedArray;

	}

}
