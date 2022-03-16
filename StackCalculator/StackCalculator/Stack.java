package StackCalculator;

public interface Stack<E> {
	
	/**
	 * Adds the given element to the top of the stack.
	 * @param element - the element to be pushed.
	 */
	public abstract void push(E element);
	
	/**
	* Removes the top element in the stack.
	* @return E - the removed element.
	*/
	public abstract E pop();

	/**
	 * Returns the top element in the stack.
	 * @return E - the top element.
	 */
	public abstract E peek();

	/**
	 * Returns if the stack is empty.
	 * @return true - if the stack is empty.
	 */
	public abstract boolean isEmpty();

}
