package CalendarDate;

/**
 *
 * Creates an Object that represents a date and is able to do operation on said date
 *
 * @author 	William Rice <william@wrice.dev>
 *
 */
public class CalendarDate {

	private int day;
	private int month;
	private int year;
	private final int[] monthLen = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] monthLenLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final String[] monthFormatted = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
	private final int[] monthOffset = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
	private final int[] monthOffsetLeap = {0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
	private final String[] dayFormatted = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

	/**
	 * Creates a CalendarDate Object with the default date of January 1, 2018
	 */
	public CalendarDate() {
		this.day = 1;
		this.month = 1;
		this.year = 2018;
	}
	
	/**
	 *
	 * Creates a CalendarDate Object from the given date.
	 * <p>
	 * If the given date doesn't exist then the CalendarDate Object will be created with the default date January 1, 2018
	 * </p>
	 *
	 * @param day The day 1/<strong>1</strong>/2018 (1 indexed)
	 * @param month The month <strong>1</strong>/1/2018 (1 indexed)
	 * @param year The year 1/1/<strong>2018</strong> (1 indexed) 
	 */
	public CalendarDate(int day, int month, int year) {

		if (isLeapYear(year) && day <= monthLenLeap[month -1]) {
			this.day = day;
			this.month = month;
			this.year = year;
			return;
		}

		if (day <= monthLen[month - 1]) {
			this.day = day;
			this.month = month;
			this.year = year;
			return;
		}

		this.day = 1;
		this.month = 1;
		this.year = 2018;

	}

	/**
	 *
	 * Returns true if the given year is a leap year
	 *
	 * @param year The year to test
	 * @return True if the year is a leap year
	 */
	public boolean isLeapYear(int year) {
		if ( (year % 4 == 0) && (!(year % 100 == 0) || (year % 400 == 0)) ) {
			return true;
		}
		return false;

	}

	/**
	 * Returns the CalendarDate object of the next calendar date
	 * @return Next Date  (ex. 1/1/2018 --> 1/2/2018)
	 */
	public CalendarDate getNextDay() {

		int nextDay = this.day;
		int nextMonth = this.month;
		int nextYear = this.year;

		if ((!(isLeapYear(year)) && (this.day + 1 > monthLen[this.month - 1])) || (isLeapYear(this.year) && (this.day + 1 > monthLenLeap[this.month - 1]))) {
				if (this.month + 1 > 12) {
				nextDay = 1;
				nextMonth = 1;
				nextYear += 1;
				}
				else {
				nextDay = 1;
				nextMonth += 1;
				}
		}
		else {
				nextDay += 1;
		}

		return (new CalendarDate(nextDay, nextMonth, nextYear));
	}

	/**
	 * Returns the formatted date of the next calendar date
	 * @return Formatted Next Date (ex. 1/1/2018 --> 1/2/2018)
	 */
	public String getNextDayFormatted() {
		return getNextDay().toString();
	}

	/**
	 * Returns the CalendarDate object of the last calendar date
	 * @return Last Date (ex. 1/1/2018 --> 12/31/2017)
	 */
	public CalendarDate getLastDay() {

		int lastDay = this.day;
		int lastMonth = this.month;
		int lastYear = this.year;

		if ((this.day - 1 < 1)) {
				if (this.month - 1 < 1) {
					lastDay = 31;
					lastMonth = 12;
					lastYear -= 1;
				}
				else {
					lastMonth -= 1;
					if (isLeapYear(lastYear)) {
						lastDay = monthLenLeap[lastMonth-1];
					}
					else {
						lastDay = monthLen[lastMonth-1];
					}
				}
		}
		else {
				lastDay -= 1;
		}

		return (new CalendarDate(lastDay, lastMonth, lastYear));
	}

	/**
	 * Returns the formatted date of the last calendar date
	 * @return Formatted Last Date (ex. 1/1/2018 --> 12/31/2017)
	 */
	public String getLastDayFormatted() {
		return getLastDay().toString();
	}

	/**
	 *
	 * Returns the formatted week day
	 *
	 * @return Formatted Week Day
	 */
	public String getWeekDay() {

		// Gauss' method for finding the first day of the week for any given year
		int janFirstDay = (1+5*((this.year-1)%4)+4*((this.year-1)%100)+6*((this.year-1)%400))%7;
		int monthOffset;

		if (isLeapYear(this.year)) {
			monthOffset = this.monthOffsetLeap[this.month - 1];
		}
		else {
			monthOffset = this.monthOffset[this.month - 1];
		}

		// 
		int day = (janFirstDay + monthOffset + this.day)%7;
		// int day = (janFirstDay + monthOffset + this.day)%7 - 1;
		// if (day == -1) {
		//   return this.dayFormatted[6];
		// }
		return this.dayFormatted[day];

	}

	/**
	 * Returns an integer representation of the Day
	 * @return The day assigned to the CalendarDate Object
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * Sets the Day to a given integer.z
	 * @param day The day 1/<strong>1</strong>/2018 (1 indexed)
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Returns an integer representation of the Month
	 * @return The month assigned to the CalendarDate Object
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Sets the Month to a given integer
	 * @param month The month <strong>1</strong>/1/2018 (1 indexed)
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Returns an integer representation of the Year
	 * @return year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Sets the Year to a given integer
	 * @param year The day 1//1<strong>2018</strong> (1 indexed)
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Returns the formatted Date as a String
	 * @return String
	 */
	public String toString() {
		return (monthFormatted[this.month - 1] + " " + this.day + ", " + this.year);
	}

	/**
	 * Main method
	 * @param args Args
	 */
	public static void main(String args[]) {

		String day = "";
		String month = "";
		String year = "";

		System.out.println(args.length);

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-d")) {
				day = args[i+1];
			}
			if (args[i].equals("-m")) {
				month = args[i+1];
			}
			if (args[i].equals("-y")) {
				year = args[i+1];
			}
		}

		CalendarDate dateOne = new CalendarDate(1,1,1);

		try {
			dateOne = new CalendarDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}

		System.out.println("The date is " + dateOne.getWeekDay() + " " + dateOne);
		System.out.println("The next day is " + dateOne.getNextDayFormatted());
		System.out.println("The last day was " + dateOne.getLastDayFormatted());

	}

}
