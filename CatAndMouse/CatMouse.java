import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CatMouse {
	
	private ArrayList<char[]> maze = new ArrayList<char[]>();
	private int[] cat;

	public CatMouse() throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("What is the name of the Maze?\n>>>  ");
		String filename = input.readLine();

		FileReader readFile = new FileReader(filename);
		BufferedReader inFile = new BufferedReader(readFile);
		String inputString = inFile.readLine();
		int row = 0;
		while (inputString != null){

			System.out.println(inputString);
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
		boolean found = findMouse(this.cat[0], this.cat[1]);

		System.out.println("The Cat "  + (found == true ? "found" : "didn't find") + " the mouse in this " + maze.size() + "x" + maze.get(0).length + " maze as follows:");
		return this.toString();
	}

	public boolean findMouse(int x, int y) {

		char tail = '0';

		if (x < 0 || x >= maze.size() || y < 0 || y >= maze.get(x).length) {
			return false;
		}

		if (maze.get(x)[y] == 'M') {
			return true;
		}
		else if (maze.get(x)[y] == tail || maze.get(x)[y] == '#') {
			return false;
		}

		if (maze.get(x)[y] != 'C') {
			maze.get(x)[y] = tail;
		}

		if (!(findMouse(x-1, y) || findMouse(x, y+1) || findMouse(x+1, y) ||  findMouse(x, y-1))) {
			if (maze.get(x)[y] != 'C') {
				maze.get(x)[y] = ' ';
			}
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
		CatMouse mazenew = new CatMouse();
		System.out.println(mazenew);
		System.out.println(mazenew.findMouseRunner());
	}

}
