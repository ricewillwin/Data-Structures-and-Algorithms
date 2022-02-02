import java.io.*;
import java.util.ArrayList;

/**
 * Class that describes a maze in which a cat finds a mouse
 * 
 * @author William Rice <william@wrice.dev>
 */
public class CatMouse {
	
	private ArrayList<char[]> maze = new ArrayList<char[]>();
	private int cat;

	public CatMouse() throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("What is the name of the Maze?\n>>>  ");
		String filename = input.readLine();

		FileReader readFile = new FileReader(filename);
		BufferedReader inFile = new BufferedReader(readFile);
		String inputString = inFile.readLine();
		int maxLength = inputString.length();
		int row = 0;
		while (inputString != null){

			if (inputString.length() == 0) {
				continue;
			}
			else if (inputString.length() < maxLength) {
				for (int i = inputString.length(); i < maxLength; i++) {
					inputString += " ";
				}
			}
			else {
				for (int y = 0; y < inputString.length(); y++) {
					if (inputString.charAt(y) == 'C') {
						this.cat = y;
					}
				}
				this.maze.add(inputString.toCharArray());

				inputString = inFile.readLine();
				row++;
			}
		}

		inFile.close();

	}

	public CatMouse(String filename) throws IOException {

		FileReader readFile = new FileReader(filename);
		BufferedReader inFile = new BufferedReader(readFile);
		String inputString = inFile.readLine();
		while (inputString != null){

			for (int y = 0; y < inputString.length(); y++) {
				if (inputString.charAt(y) == 'C') {
					this.cat = y;
				}
			}
			this.maze.add(inputString.toCharArray());

			inputString = inFile.readLine();
		}

		inFile.close();

	}

	public String findMouseRunner() {
		boolean found = findMouse(0, this.cat);

		System.out.println("The Cat "  + (found == true ? "found" : "didn't find") + " the mouse in this " + this.maze.size() + "x" + this.maze.get(0).length + " maze as follows:");
		return this.toString();
	}

	public boolean findMouse(int x, int y) {

		char tail = '0';

		if (x < 0 || x >= this.maze.size() || y < 0 || y >= this.maze.get(x).length) {
			return false;
		}

		if (this.maze.get(x)[y] == 'M') {
			return true;
		}
		else if (this.maze.get(x)[y] == tail || this.maze.get(x)[y] == '#') {
			return false;
		}

		if (this.maze.get(x)[y] != 'C') {
			this.maze.get(x)[y] = tail;
		}

		if (!(findMouse(x-1, y) || findMouse(x, y+1) || findMouse(x+1, y) ||  findMouse(x, y-1))) {
			if (this.maze.get(x)[y] != 'C') {
				this.maze.get(x)[y] = ' ';
			}
		}
		else {
			return true;
		}

		return false;

	}

	public String toString() {

		String mazeString = "";
		for (int i = 0; i < this.maze.size(); i++) {
			for (int j = 0; j < this.maze.get(0).length; j++) {
				mazeString += this.maze.get(i)[j];
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
