package QuadraticSort;

public class SortArrayRunner {
	
	public static void main(String[] args) {
		
		SortArray array;

		array = new SortArray(500, 2);
		System.out.println(array.sort());
		
		array = new SortArray(5000, 2);
		System.out.println(array.sort());

		array = new SortArray(50000, 2);
		System.out.println(array.sort());

	}

}
