import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CatMouse {
	
	private ArrayList<char[]> maze = new ArrayList<char[]>();
	private int[] cat;

	public CatMouse(String filename) throws IOException {

		FileReader readFile = new FileReader(filename);
		BufferedReader inFile = new BufferedReader(readFile);
		String inputString = inFile.readLine();
		int row = 0;
		while (inputString != null){

			for (int y = 0; y < inputString.length(); y++) {
				if (inputString.charAt(y) == 'C') {
					this.cat = new int[] {row, y};
				}
			}
			maze.add(inputString.toCharArray());

			inputString = inFile.readLine();
			row++;
		}

		inFile.close();

	}

	public String findMouseRunner() {
		findMouse(this.cat[0], this.cat[1]);

		return this.toString();
	}

	public boolean findMouse(int x, int y) {

		char tail = '@';

		if (maze.get(x)[y] == 'M') {
			return true;
		}
		else if (maze.get(x)[y] == tail) {
			return false;
		}
		else if (maze.get(x)[y] == '#') {
			return false;
		}

		if (maze.get(x)[y] != 'C') {
			maze.get(x)[y] = tail;
		}

		if (!(findMouse(x+1, y) || findMouse(x, y+1) || findMouse(x-1, y) || findMouse(x, y-1))) {
			maze.get(x)[y] = ' ';
		}
		else {
			return true;
		}

		return false;

	}

	public String toString() {

		String mazeString = "";
		for (int i = 0; i < maze.size(); i++) {
			for (int j = 0; j < maze.get(0).length; j++) {
				mazeString += maze.get(i)[j];
			}
			mazeString += "\n";
		}

		return mazeString;
	}

	public static void main(String[] args) throws IOException {
		CatMouse mazenew = new CatMouse("Data-Structures-and-Algoritms/CatAndMouse/maze.txt");
		System.out.println(mazenew);
		System.out.println(mazenew.findMouseRunner());
	}

}
