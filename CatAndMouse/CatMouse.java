import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Class that describes a maze in which a cat finds a mouse
 * 
 * @author William Rice <william@wrice.dev>
 */
public class CatMouse {
	
	private ArrayList<char[]> maze = new ArrayList<char[]>();
	private int cat;

	/**
	 * Base Constructor
	 * <p>
	 * Gives the user a prompt for the name of the file then creates the maze.
	 * </p>
	 * 
	 * @throws IOException
	 */
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

	/**
	 * Constructs a maze from a given file.
	 * @param filename
	 * @throws IOException
	 */
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

	/**
	 * Attemps to find the mouse with a given path
	 * @return The maze with the path
	 */
	public String findMouseRunner() {
		boolean found = findMouse(0, this.cat);

		return ("The Cat "  + (found == true ? "found" : "didn't find") + " the mouse in this " + this.maze.size() + 
						"x" + this.maze.get(0).length + " maze" + (found == true ? " as follows:" : ".") + (found == true ? "\n" + this.toString() : ""));
	}

	/**
	 * Attemps to find the mouse with a given path + fancy ui
	 * @return The maze with the path
	 */
	public String findMouseUIRunner() throws Exception {
		boolean found = findMouseUI(0, this.cat, 0);

		return ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nThe Cat "  + (found == true ? "found" : "didn't find") + " the mouse in this " + this.maze.size() + 
						"x" + this.maze.get(0).length + " maze" + (found == true ? " as follows:" : ".") + (found == true ? "\n" + this.toString() : ""));
	}

	/**
	 * Finds the mouse from the cats starting location
	 * @param x
	 * @param y
	 * @return If the mouse was found
	 */
	private boolean findMouse(int x, int y) {

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

	/**
	 * Finds the mouse from the cats starting location with an ui.
	 * @param x
	 * @param y
	 * @return If the mouse was found
	 */
	private boolean findMouseUI(int x, int y, int r) throws Exception {

	int frames = 5;
		
	// System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSearching...\n" + toString());
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSearching" + ((r <= frames) ? "" : (r <= 2*frames) ? "." : (r <= 3*frames) ? ".." : "...")  + "\n" + toString());
	if (r > 4*frames) {
		r = 0;
	}
	else {
		r++;
	}

	TimeUnit.MILLISECONDS.sleep(25);


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

		if (!(findMouseUI(x-1, y, r) || findMouseUI(x, y+1, r) || findMouseUI(x+1, y, r) ||  findMouseUI(x, y-1, r))) {
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

	public static void main(String[] args) throws Exception {
		// Data-Structures-and-Algoritms/CatAndMouse/maze101.txt
		CatMouse mazenew = new CatMouse();
		System.out.println(mazenew);
		System.out.println(mazenew.findMouseUIRunner());
	}

}
