package LinkedListProgram;
import java.io.*;

public class ListRunner {

	private static LinkedList<Integer> list;
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
		"##  3.) Remove From List (rem)   ##" + titleBackString +
		"##      - Removes Integer        ##" + titleBackString +
		"##        from the list          ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  4.) Stop Program (done)      ##" + titleBackString +
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
				System.out.print("\n" + list.uiOutput() + "\n" + ">>> ");
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
		Integer flag = null;
		if (input.trim().split(" ").length == 2) {

			try {
				flag = Integer.parseInt(input.trim().split(" ")[1]);
			} catch (Exception e) {
				System.out.println("Invalid Input");
				return validInput;
			}

			input = input.split(" ")[0];
		}

		if (input.toLowerCase().trim().equals("out") || input.toLowerCase().trim().equals("output")) {
			validInput = true;
			System.out.print(list + "\n");
		}
		else if (input.toLowerCase().trim().equals("add")) {
			validInput = true;
			if (flag == null) {
				flag = getUserNum(" add");
			}
			String out = list.add(flag);
			System.out.print(out == "" ? "" : out + "\n");
		}
		else if (input.toLowerCase().trim().equals("remove") || input.toLowerCase().trim().equals("rem")) {
			validInput = true;
			if (flag == null) {
				flag = getUserNum(" remove");
			}
			String out = list.remove(flag);
			System.out.print(out == "" ? "" : out + "\n");
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
	 * Retreves a number from the user
	 * @param func
	 * @return User Number
	 */
	private static int getUserNum(String func) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Integer number = null;
		
		try {
			while (number == null) {
				System.out.print("Enter the number to" + func + ": ");
				String inputStr = input.readLine();

				try {
					number = Integer.parseInt(inputStr);
				}
				catch (Exception e) {
					System.out.print("Invalid Integer");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return number;

	} 
	
	public static void main(String[] args) {

		list = new LinkedList<Integer>();
		userUI();

	}

}
