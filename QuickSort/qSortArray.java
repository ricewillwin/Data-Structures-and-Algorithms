package QuickSort;
import java.util.concurrent.TimeUnit;
import QuadraticSort.SortArray;

public class qSortArray extends SortArray {

	public qSortArray(int len, int dir) {
		super(len, dir);
	}

	public String sort() {
		this.setArray(qSort(this.getArray(), 0, this.getArray().length-1));

		return (this.toString() + " Items\nSwaps:\t\t" + this.getSwaps() + "\nComparisons:\t" + this.getComparisons() + "\n");
	}

	private int[] qSort(int[] unsortedArray, int low, int high) {

		if (low >= high) {
			return unsortedArray;
		}

		int first = unsortedArray[low];
		int middle = unsortedArray[(high)/2];
		int last = unsortedArray[high];
		int pivot;
		
		if ((first > middle && first > last) || (first < middle && first < last)) {
			if((middle < last && middle < first) || (middle > last && middle > first)) {
				// Last is the median
				pivot = last;

				int k = unsortedArray[low];
				unsortedArray[low] = pivot;
				unsortedArray[high] = k;
			}
			else {
				// Middle is the median
				pivot = middle;

				int k = unsortedArray[low];
				unsortedArray[low] = pivot;
				unsortedArray[(high)/2] = k;
			}
		}
		else {
			// First is the medians
			pivot = first;

		}


		int i = low;
		int j = high;
		while(i < j) {
			if(unsortedArray[i] <= pivot) {
				i++;
				continue;
			}

			int k = unsortedArray[i];
			unsortedArray[i] = unsortedArray[j];
			unsortedArray[j] = k;

			try {
				TimeUnit.MILLISECONDS.sleep(25);
				this.quickSortUI();
			}
			catch (Exception e) {}

			while(j > i) {
				if (unsortedArray[j] > pivot) {
					j--;
					continue;
				}

				k = unsortedArray[i];
				unsortedArray[i] = unsortedArray[j];
				unsortedArray[j] = k;
				break;

			}
			
		}

		int split = i;

		while (unsortedArray[split] > pivot) {
			split--;
		}

		int k = unsortedArray[low];
		unsortedArray[low] = unsortedArray[split];
		unsortedArray[split] = k;

		unsortedArray = qSort(unsortedArray, low, split-1);
		unsortedArray = qSort(unsortedArray, split+1, high);

		return unsortedArray;

	}

	private String moveUp(int lines) {
		return "\033[" + lines + "F";
	}

	public void quickSortUI() {
		int modifer = 4;
		int maxheight = 30 - 1;
		int height = this.getArray().length-1 < maxheight ? this.getArray().length-1 : maxheight;
		String output = moveUp(height + 1);
		for (int i = height; i >= 0; i--) {
			for (int j = 0; j < this.getArray().length; j++) {
				if ((this.getArray()[j] / modifer) > i) {
					if (i == maxheight && (this.getArray()[j] / modifer) > maxheight + 1) {
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

		// int errornum = 0;
		// for (int i = 0; i < 100; i++) {

		// 	qSortArray stuff = new qSortArray(40, 2);
		// 	stuff.sort();
		// 	for (int k = 0; k < stuff.getArray().length - 1; k++) {
		// 		if (stuff.getArray()[k] > stuff.getArray()[k+1]) {
		// 			// System.out.println("Error " + stuff.getArray()[k]);
		// 			errornum++;
		// 		}
		// 	}

		// }

		// System.out.println( "\n\n\n\n\n\n" + errornum + "\n"+ errornum * 100 / 100);

		int errornum = 0;
		qSortArray array = new qSortArray(125, 2);
		for (int i = 0; i < 29; i++) {
			System.out.print("\n");
		}
		array.sort();

		for (int i = 0; i < array.getArray().length -1; i++) {
			if (array.getArray()[i] > array.getArray()[i+1]) {errornum++;}
		}
		System.out.println(errornum);
	}

}
