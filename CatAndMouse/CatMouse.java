import java.io.*;
import java.util.ArrayList;

import javax.tools.ForwardingJavaFileManager;

public class CatMouse {
	
	private ArrayList<char[]> maze = new ArrayList<char[]>();

	public CatMouse(String filename) throws IOException {

		FileReader readFile = new FileReader(filename);
		BufferedReader inFile = new BufferedReader(readFile);
		String inputString = inFile.readLine();
		while (inputString != null){

			maze.add(inputString.toCharArray());

			inputString = inFile.readLine();
		}

		inFile.close();

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
		CatMouse mazenew = new CatMouse("maze.txt");
		System.out.println(mazenew);
	}

}
