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
		"##  4.) Reset List (reset)       ##" + titleBackString +
		"##                               ##" + titleBackString +
		"##  5.) Stop Program (done)      ##" + titleBackString +
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
		else if (input.toLowerCase().trim().equals("reset")) {
			validInput = true;
			list.reset();
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

/* First Run

###################################
##                               ##
##      Linked List Program      ##
##        By William Rice        ##
##                               ##
## ----------------------------- ##
##                               ##
##  Functions -                  ##
##                               ##
##  1.) Output List (out)        ##
##      - Prints list            ##
##                               ##
##  2.) Add to List (add)        ##
##      - Adds Integer to        ##
##        list                   ##
##                               ##
##  3.) Remove From List (rem)   ##
##      - Removes Integer        ##
##        from the list          ##
##                               ##
##  4.) Reset List (reset)       ##
##                               ##
##  5.) Stop Program (done)      ##
##                               ##
###################################

List is empty
>>> add 15

[ 15 ]
>>> add 10

[ 10, 15 ]
>>> add 25

[ 10, 15, 25 ]
>>> rem 12
Not on list

[ 10, 15, 25 ]
>>> add one
Invalid Input

[ 10, 15, 25 ]
>>> add 5

[ 5, 10, 15, 25 ]
>>> add
Enter the number to add: 20

[ 5, 10, 15, 20, 25 ]
>>> add
Enter the number to add: 15
Already on List

[ 5, 10, 15, 20, 25 ]
>>> remove
Enter the number to remove: 30
Not on list

[ 5, 10, 15, 20, 25 ]
>>> add 17

[ 5, 10, 15, 17, 20, ... ]
>>> add 16

[ 5, 10, 15, 16, 17, ... ]
>>> add 10
Already on List

[ 5, 10, 15, 16, 17, ... ]
>>> rem 15

[ 5, 10, 16, 17, 20, ... ]
>>> remove x
Invalid Input

[ 5, 10, 16, 17, 20, ... ]
>>> remove 10

[ 5, 16, 17, 20, 25 ]
>>> out
[ 5, 16, 17, 20, 25 ]

[ 5, 16, 17, 20, 25 ]
>>> add 4

[ 4, 5, 16, 17, 20, ... ]
>>> add 0

[ 0, 4, 5, 16, 17, ... ]
>>> rem 25

[ 0, 4, 5, 16, 17, ... ]
>>> rem 20

[ 0, 4, 5, 16, 17 ]
>>> rem -4
Not on list

[ 0, 4, 5, 16, 17 ]
>>> add 18

[ 0, 4, 5, 16, 17, ... ]
>>> add 5
Already on List

[ 0, 4, 5, 16, 17, ... ]
>>> add 19

[ 0, 4, 5, 16, 17, ... ]
>>> rem 0

[ 4, 5, 16, 17, 18, ... ]
>>> rem 4

[ 5, 16, 17, 18, 19 ]
>>> out
[ 5, 16, 17, 18, 19 ]

[ 5, 16, 17, 18, 19 ]
>>> reset

List is empty
>>> out
List is empty

List is empty
>>> rem 10
Not in list

List is empty
>>> Add 5

[ 5 ]
>>> add 10

[ 5, 10 ]
>>> add 7

[ 5, 7, 10 ]
>>> out
[ 5, 7, 10 ]

[ 5, 7, 10 ]
>>> done

*/

/* Second Run

###################################
##                               ##
##      Linked List Program      ##
##        By William Rice        ##
##                               ##
## ----------------------------- ##
##                               ##
##  Functions -                  ##
##                               ##
##  1.) Output List (out)        ##
##      - Prints list            ##
##                               ##
##  2.) Add to List (add)        ##
##      - Adds Integer to        ##
##        list                   ##
##                               ##
##  3.) Remove From List (rem)   ##
##      - Removes Integer        ##
##        from the list          ##
##                               ##
##  4.) Reset List (reset)       ##
##                               ##
##  5.) Stop Program (done)      ##
##                               ##
###################################

List is empty
>>> add 5

[ 5 ]
>>> rem 5

List is empty
>>> out
List is empty

List is empty
>>> done

*/