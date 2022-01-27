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
		ArrayList<Integer> arrayOfNums = Arrays.asList(genAscendingArray(length)); //FIXME

		for (int i = 0; i < length; i++) {
			int currentInt = (int) (Math.random() * arrayOfNums.size()-1);
			System.out.println(currentInt);
		}

		return newArray;
	}



	// #########################
	// ##                     ##
	// ##  Getters / Setters  ##
	// ##                     ##
	// #########################

	public int getSwaps() {
		return this.swaps;
	}

	public void setSwaps(int swaps) {
		this.swaps = swaps;
	}

	public int getComparisons() {
		return this.comparisons;
	}

	public void setComparisons(int comparisons) {
		this.comparisons = comparisons;
	}

	public int[] getArray() {
		return this.intArray;
	}

	public void setArray(int[] intArray) {
		this.intArray = intArray;
	} 

}
