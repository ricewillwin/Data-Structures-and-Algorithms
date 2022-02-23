package RadixSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Creates an integer Array then sorts that array
 * 
 * @author 	William Rice <william@wrice.dev>
 * 
 */
public class RadixSort {
	
	private int[] intArray;



	// ####################
	// ##                ##
	// ##  Constructors  ##
	// ##                ##
	// ####################

	/**
	 * Creates an array of a given length in a given order
	 * 
	 * @param arrayLength The length of the array
	 */
	public RadixSort(int arrayLength) {
		
		this.intArray = genRandomArray(arrayLength);

	}





	// #####################
	// ##                 ##
	// ##  Create Arrays  ##
	// ##                 ##
	// #####################

	/**
	 * Generates an array of a given length in random order
	 * 
	 * @param length The length of the array
	 * @return Array of Integers
	 */
	public int[] genRandomArray(int length) {
		int[] newArray = new int[length];

		for (int i = 0; i < length; i++) {
			newArray[i] = (int) (Math.random()*1000);
		}

		return newArray;
	}





	// #########################
	// ##                     ##
	// ##  Getters / Setters  ##
	// ##                     ##
	// #########################

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
	 * 
	 * Fills the buckets in the order of their digits
	 * 
	 * @param buckets Array of Buckets
	 * @param array Array of Integers
	 * @param position Current digit
	 * @return Buckets
	 */
	private static ArrayList<Integer>[] fillBuckets(ArrayList<Integer>[] buckets, int[] array, int position) {

		for (int i : array) {
			buckets[(i%position)/(position/10)].add(i);
		}

		return buckets;
	}

	/**
	 * 
	 * Fills the array from the buckets in order of bucket
	 * 
	 * @param buckets Array of Buckets
	 * @param array Array of Integers
	 * @return Array of Integers
	 */
	private static int[] fillArray(ArrayList<Integer>[] buckets, int[] array) {
		
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j : buckets[i]) {
				array[index] = j;
				index++;
			}
		}
		
		return array;
	}

	/**
	 * 
	 * Clears Array of ArrayLists that are type Integer
	 * 
	 * @param buckets Array of Buckets
	 * @return Buckets
	 */
	private static ArrayList<Integer>[] clearBuckets(ArrayList<Integer>[] buckets) {
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		return buckets;
	}

	/**
	 * 
	 * Finds the max number of digits in a given array
	 * 
	 * @param array Array of Integers
	 * @return maxDigits
	 */
	private static int maxDigits(int[] array) {

		int digits = 0;

		for (int i : array) {
			int j = 1;
			while (i > 9) {
				i /= 10;
				j++;
				if(j > digits) {
					digits = j;
				}
			}
		}

		return digits;

	}

	/**
	 * 
	 * Sorts an Array of Integers using Radix Sort
	 * 
	 * @param array Array of Integers
	 * @return Sorted Array
	 */
	public static int[] radixSort(int[] array) {

		ArrayList<Integer>[] buckets = new ArrayList[10];

		buckets = clearBuckets(buckets);
		int digits = maxDigits(array);

		for(int i = 1; i <= digits; i++) {
			buckets = fillBuckets(buckets, array, (int) Math.pow(10, i));
			array = fillArray(buckets, array);
			buckets = clearBuckets(buckets);
		}

		

		return array;
	}

}