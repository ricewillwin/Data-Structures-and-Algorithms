package QuickSort;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;

/**
 * 
 * Creates an integer Array then sorts that array
 * 
 * @author 	William Rice <william@wrice.dev>
 * 
 */
public class qSortArray {
	
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
	public qSortArray() {
		this.intArray = genAscendingArray(10);
	}

	/**
	 * Creates an array of a given length in ascending order
	 * 
	 * @param arrayLength The length of the array
	 */
	public qSortArray(int arrayLength) {
		this.intArray = genAscendingArray(arrayLength);
	}

	/**
	 * Creates an array of a given length in a given order
	 * 
	 * @param arrayLength The length of the array
	 * @param direction The direction the array is filled (0 -> Ascending, 1 -> Descending, 2 -> Random)
	 */
	public qSortArray(int arrayLength, int direction) {
		
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

	private String moveUp(int lines) {
		return "\033[" + lines + "F";
	}

	public void quickSortUI() {
		int maxheight = 20 - 1;
		int height = this.intArray.length-1 < maxheight ? this.intArray.length-1 : maxheight;
		String output = moveUp(height);
		for (int i = height; i >= 0; i--) {
			for (int j = 0; j < this.intArray.length; j++) {
				if (this.intArray[j] > i) {
					if (i == maxheight && this.intArray[j] > maxheight + 1) {
						output += "&";
					}
					else {
						output += "#";
					}
				}
				else {
					output += " ";
				}
			}
			output += "\n";
		}

		System.out.print(output);
	}

	

	public static void main(String[] args) {

		qSortArray stuff = new qSortArray(30, 2);
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		stuff.quickSortUI();
		System.out.println(stuff.toString());

	}

}
