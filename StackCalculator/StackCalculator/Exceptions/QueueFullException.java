package StackCalculator.Exceptions;

public class QueueFullException extends Exception {
	/**
	 * Creates a Queue Full Exception.
	 */
	public QueueFullException() {}

	@Override
	public String toString() {
		return "Queue Full";
	}

}
