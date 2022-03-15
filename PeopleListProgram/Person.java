public class Person implements Comparable<Person> {
	
	private String firstName;
	private String lastName;
	private String employer;

	/**
	 * Creates a Person object from a string in the following form
	 * <p>
	 * lastName firstName
	 * </p>
	 * @param name
	 */
	public Person(String name) {
		String[] names = name.split(" ");
		if (names.length != 2) {
			throw new Error("Invalid name format");
		}
		this.lastName = names[0];
		this.firstName = names[1];
	}

	/**
	 * Creates a Person from their first and last name
	 * @param lastName
	 * @param firstName
	 */
	public Person(String lastName, String firstName, String employer) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.employer = employer;
	}

	/**
	 * Sets first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets employer
	 * @param employer
	 */
	public void setEmployer(String employer) {
		this.employer = employer;
	}

	/**
	 * Returns person's first name
	 * @return First Name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Returns person's last name
	 * @return Last Name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Returns person's employer
	 * @return Employer
	 */
	public String getEmployer() {
		return this.employer;
	}

	@Override
	public String toString() {
		return "["+ this.firstName + ", " + this.lastName + ", " + this.employer + "]";
	}

	@Override
	public int compareTo(Person otherPerson) {

		if (this.lastName.toLowerCase().compareTo(otherPerson.getLastName().toLowerCase()) == 0) {
			return this.firstName.toLowerCase().compareTo(otherPerson.getFirstName().toLowerCase());
		}

		return this.lastName.toLowerCase().compareTo(otherPerson.getLastName().toLowerCase());
	}

}
