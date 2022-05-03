package PriorityQueue;

public class Patient implements Priority {

	private String firstName;
	private String lastName;
	private int priority;

	public Patient(String firstName, String lastName, int priority) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.priority = priority;
	}

	/**
	 * @return String return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return String return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return int return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return this.priority + " : " + this.firstName + " " + this.lastName;
	}

}
