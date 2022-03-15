import PeopleListProgram.*;
import java.io.*;

public class ListRunner {
	
// 	/**
// 	 * Adds a node to the list from a name in the following form
// 	 * <p>lastName firstName</p>
// 	 * @param data
// 	 * @return something //TODO
// 	 */
	public static String add(LinkedList<Person> list, Person data) {
		ListNode<Person> newNode = new ListNode<Person>(data, null, null);
		if (newNode.compareTo(new ListNode<Person>(new Person("n", "", ""), null, null)) < 0) {
			return list.addFront(newNode);
		}
		else {
			return list.addBack(newNode);
		}
	}

// 	public static void main(String[] args) {
		
// 		LinkedList<Person> list = new LinkedList<Person>();
// 		System.out.println(list);

// 		String names = "hjakdshfuihasdhfjhlasf";
// 		for (Character name : names.toCharArray()) {
// 			add(list, new Person(Character.toString(name), "name"));
// 		}

// 		System.out.println(list);
// 		System.out.println(list.backwardsOut());

// 	}

// }

	private static LinkedList<Person> list;
	private static boolean again = true;

	/**
	 * Prints the program title bar and gets user input
	 */
	private static void userUI() {

		String titleBackString = "\u001b[1B\u001b[35D";
		String title = 
		"###################################" + titleBackString +
		"##                               ##" + titleBackString +
		"##      Linked List Program      ##" + titleBackString +
		"##        By William Rice        ##" + titleBackString +
		"##                               ##" + titleBackString +
		"## ----------------------------- ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  Functions -                  ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  1.) Output List (out)        ##" + titleBackString +
		"##      - Prints list            ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  2.) Add to List (add)        ##" + titleBackString +
		"##      - Adds Integer to        ##" + titleBackString +
		"##        list                   ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  3.) Reset List (reset)       ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  4.) Reverse List (reverse)   ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  5.) Add from file (file)     ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  6.) Stop Program (done)      ##" + titleBackString +
		"##                               ##" + titleBackString +
		"###################################" + titleBackString;

		for(int i = 0; i < 30; i++) {
			System.out.println();
		}
		System.out.print("\u001b[30A");

		System.out.print(title);
	  while (again == true) {
			getFunction();
		}

	}

	/**
	 * Gets function from user input
	 */
	private static void getFunction() {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		try {
			boolean validInput = false;
			while (validInput == false) {
				System.out.print("\n" + ">>> ");
				String inputStr = input.readLine();
				validInput = parseInput(inputStr, validInput);

			}
		}
		catch (Exception e) {
			System.out.println("Invalid Input " + e);
		}

	}

	/**
	 * Parses a given input to find function
	 * @param input
	 * @param validInput
	 * @return If the given input was valid
	 */
	private static boolean parseInput(String input, boolean validInput) {
		Person flag = null;
		String strflag = null;
		if (input.trim().split(" ").length > 2) {
			try {
				flag = new Person(input.trim().split(" ")[2], input.trim().split(" ")[1], input.trim().split(" ")[3]);
			} catch (Exception e) {
				System.out.println("Invalid Input");
				return validInput;
			}

			input = input.trim().split(" ")[0];
		}
		else if (input.trim().split(" ").length == 2) {
			strflag = input.trim().split(" ")[1];
		}

		if (input.toLowerCase().trim().equals("out") || input.toLowerCase().trim().equals("output")) {
			validInput = true;
			System.out.print(list + "\n");
		}
		else if (input.toLowerCase().trim().equals("add")) {
			validInput = true;
			if (flag == null) {
				flag = getUserName(" add");
			}
			String out = add(list, flag);
			System.out.print(out == "" ? "" : out + "\n");
		}
		else if (input.toLowerCase().trim().equals("reset")) {
			validInput = true;
			list.reset();
		}
		else if (input.toLowerCase().trim().equals("reverse")) {
			validInput = true;
			System.out.println(list.backwardsOut());
		}
		else if (input.toLowerCase().trim().equals("file")) {
			validInput = true;
			if (strflag == null) {
				strflag = getUserFile();
			}
			System.out.println(importFile(strflag));
		}
		else if (input.toLowerCase().trim().equals("done")) {
			validInput = true;
			again = false;
		}
		else {
			System.out.println("Invalid Input");
		}

		return validInput;

	}

	/**
	 * Gets a list of user names from a file.
	 * @param file
	 * @return output
	 */
	private static String importFile(String file) {

		try {
			System.out.println(file);
			FileReader readFile = new FileReader(file);
			BufferedReader inFile = new BufferedReader(readFile);
	
	
			String inputString = inFile.readLine();
			while (inputString != null){
				add(list, new Person(inputString.split(" ")[0], inputString.split(" ")[1], inputString.split(" ")[2]));
				inputString = inFile.readLine();
			}
			inFile.close();
	
			return "";
		}
		catch (Exception e) {
			return "So many errors";
		}

	}

	/**
	 * Get file name from user.
	 * @return File
	 */
	private static String getUserFile() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		FileReader readFile = null;
		String inputStr = null;


		try {
			while (readFile == null) {
				System.out.print("Enter the file name: ");
				inputStr = input.readLine();

				try {
					readFile = new FileReader(inputStr);
				}
				catch (Exception e) {
					System.out.print("Invalid File");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		try {readFile.close();} catch (Exception e) {System.out.print("error");}
		return inputStr;
	}

	/**
	 * Retreves a Name from the user
	 * @param func
	 * @return User name
	 */
	private static Person getUserName(String func) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Person name = null;
		
		try {
			while (name == null) {
				System.out.print("Enter the Name to" + func + ": ");
				String inputStr = input.readLine();

				try {
					name = new Person(inputStr.trim().split(" ")[1], inputStr.trim().split(" ")[0]);
				}
				catch (Exception e) {
					System.out.print("Invalid Name");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return name;

	} 
	
	public static void main(String[] args) {

		list = new LinkedList<Person>();
		userUI();

	}

}