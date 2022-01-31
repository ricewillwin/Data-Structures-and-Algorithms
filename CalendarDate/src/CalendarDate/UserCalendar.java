package CalendarDate;

import java.io.*;

/**
 * 
 * Class for the user to input a date and get all the information about that date
 * 
 * @author William Rice <william@wrice.dev>
 * 
 */
public class UserCalendar {

	/**
	 * Get the user input
	 * @return User Input
	 */
	public static String getUserInput() {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String inputStr = "";
		int userInput = 0;
		do {
			try {
				System.out.print("> ");
				inputStr = input.readLine();
				userInput = 1;
			}
			catch (Exception e) {
				System.out.println("Error: " + e + "\ntry again.\n");
				userInput = 0;
			}
		} while (userInput != 1);

		return inputStr;

	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		int day = 1;
		int month = 1;
		int year = 1;

		try {
			System.out.println("Enter Day");
			day = Integer.parseInt(getUserInput());
		}
		catch (Exception e) {
			System.out.println("Invalid day\nError: " + e);
		}

		try {
			System.out.println("\nEnter Month");
			month = Integer.parseInt(getUserInput());
		}
		catch (Exception e) {
			System.out.println("Invalid month\nError: " + e);
		}

		try{
			System.out.println("\nEnter Year");
			year = Integer.parseInt(getUserInput());
		}
		catch (Exception e) {
			System.out.println("Invalid year\nError: " + e);
		}


		CalendarDate date = new CalendarDate(day, month, year);
		System.out.println("\n\nThe date is " + date.getWeekDay() + " " + date);
		System.out.println("\nThe next day is " + date.getNextDay().getWeekDay() + " " + date.getNextDay());
		System.out.println("\nThe last day was " + date.getLastDay().getWeekDay() + " " + date.getLastDay());

	}

}
