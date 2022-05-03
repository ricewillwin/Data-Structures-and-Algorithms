package PriorityQueue;

public interface Priority {
	
	/**
	 * Returns the Priority
	 * @return Priority int from 1 highest to 10 lowest
	 */
	public abstract Integer getPriority();

		/**
	 * Sets the Priority of the elemet
	 * @param priority integer representation of the priority.
	 */
	public abstract void setPriority(int priority);


}
