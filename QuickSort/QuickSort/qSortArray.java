package QuickSort;
import java.util.concurrent.TimeUnit;

public class qSortArray extends SortArray {

	public qSortArray(int len, int dir) {
		super(len, dir);
	}

	public String sort() {
		// this.quickSortUI(-1, -1, this.getArray().length);
		this.setArray(qSort(this.getArray(), 0, this.getArray().length-1));
		// this.quickSortUI(-1, -1, this.getArray().length);

		return (this.getArray().length + " Items\nSwaps:\t\t" + this.getSwaps() + "\nComparisons:\t" + this.getComparisons() + "\n");
	}

	private int[] qSort(int[] unsortedArray, int low, int high) {

		if (low >= high) {
			return unsortedArray;
		}

		int first = unsortedArray[low];
		int middle = unsortedArray[(low+high)/2];
		int last = unsortedArray[high];
		int pivot;
		
		this.setComparisons(this.getComparisons() + 1);
		if ((first > middle && first > last) || (first < middle && first < last)) {
			if((middle < last && middle < first) || (middle > last && middle > first)) {
				// Last is the median
				pivot = last;

				int k = unsortedArray[low];
				unsortedArray[low] = pivot;
				unsortedArray[high] = k;
				this.setSwaps(this.getSwaps() + 1);
				// swapUI(unsortedArray, low, high);

			}
			else {
				// Middle is the median
				pivot = middle;
				
				int k = unsortedArray[low];
				unsortedArray[low] = pivot;
				unsortedArray[(low+high)/2] = k;
				this.setSwaps(this.getSwaps() + 1);
				// swapUI(unsortedArray, low, (high/2));

			}
		}
		else {
			// First is the medians
			pivot = first;

		}
		
		int i = low;
		int j = high;
		
		this.setComparisons(this.getComparisons() + 1);
		while(i < j) {
			
			this.setComparisons(this.getComparisons() + 3);
			if(unsortedArray[i] <= pivot) {
				i++;
				continue;
			}
			
			unsortedArray = swapArray(unsortedArray, i, j);
			
			while(j > i) {
				this.setComparisons(this.getComparisons() + 1);
				if (unsortedArray[j] >= pivot) {
					j--;
					continue;
				}
				
				unsortedArray = swapArray(unsortedArray, i, j);
				break;
				
			}
			
		}
		
		int split = i;
		
		this.setComparisons(this.getComparisons() + 1);
		while (unsortedArray[split] > pivot) {
			this.setComparisons(this.getComparisons() + 1);
			split--;
		}

		unsortedArray = swapArray(unsortedArray, low, split);
		
		unsortedArray = qSort(unsortedArray, low, split-1);
		unsortedArray = qSort(unsortedArray, split+1, high);

		return unsortedArray;

	}

	private int[] swapArray(int[] array, int indexOne, int indexTwo) {
		int temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
		this.setSwaps(this.getSwaps() + 1);
		swapUI(array, indexOne, indexTwo);
		return array;
	}
	
	private String moveUp(int lines) {
		return "\033[" + lines + "F";
	}

	private String drawIndex(int[] array, int height, int modifer, int index) {
		String out = moveUp(height+1) + "\033[" + index + "G";
		for (int i = height; i >= 0; i--) {
			if (array[index] / modifer > i) {
				out += "#\033[1B\033[1D";
			}
			else {
				out += " \033[1B\033[1D";
			}
		}

		return out;
	}
	
	private void swapUI(int[] array, int indexOne, int indexTwo) {
		int maxheight = 30 - 1;
		int height = array.length-1 < maxheight ? array.length-1 : maxheight;
		int modifer = array.length/height;

		
		String out = drawIndex(array, height, modifer, indexOne);
		out += drawIndex(array, height, modifer, indexTwo);

		try {TimeUnit.MILLISECONDS.sleep(15);} catch (Exception e) {}
		
		System.out.print(out);
	}

	public void quickSortUI(int indexFront, int indexBack, int sorted) {
		int maxheight = 30 - 1;
		int height = this.getArray().length-1 < maxheight ? this.getArray().length-1 : maxheight;
		int modifer = this.getArray().length/height;
		String output = "";
		for (int j = 0; j < this.getArray().length; j++) {
			output += drawIndex(this.getArray(), height, modifer, j);
		}
		output += "\033[0G";
		for (int i = 0; i < this.getArray().length - 1; i++) {
			output += i%10 == 0 ? (i / 10 > 0) ? ((i / 10 > 9) ? ("\033[2D" + i) : ("\033[1D" + i)) : (i) : " ";
		}
		
		
		System.out.print(output);
	}

	public static void main(String[] args) {

		qSortArray array = new qSortArray(176, 2);
		for (int i = 0; i < 29; i++) {
			System.out.print("\n");
		}
		System.out.print("\033[?25l");
		array.sort();
		System.out.print("\033[?25h");

		// qSortArray array = new qSortArray(500, 0);
		// System.out.println(array.sort());
		// array = new qSortArray(5000, 0);
		// System.out.println(array.sort());
		// array = new qSortArray(50000, 0);
		// System.out.println(array.sort());
		// array = new qSortArray(500, 1);
		// System.out.println(array.sort());
		// array = new qSortArray(5000, 1);
		// System.out.println(array.sort());
		// array = new qSortArray(50000, 1);
		// System.out.println(array.sort());
		// array = new qSortArray(500, 2);
		// System.out.println(array.sort());
		// array = new qSortArray(5000, 2);
		// System.out.println(array.sort());
		// array = new qSortArray(50000, 2);
		// System.out.println(array.sort());

	}

}

/*

500 Items
Swaps:          1467
Comparisons:    47560

5000 Items
Swaps:          14953
Comparisons:    4226591

500 Items
Swaps:          1469
Comparisons:    62319

5000 Items
Swaps:          14955
Comparisons:    5780350

500 Items
Swaps:          1998
Comparisons:    12493

5000 Items
Swaps:          27858
Comparisons:    177205

50000 Items
Swaps:          356289
Comparisons:    2389406


*/