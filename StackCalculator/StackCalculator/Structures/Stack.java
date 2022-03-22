package StackCalculator.Structures;

import java.util.EmptyStackException;

public interface Stack<E> {
	
	/**
	 * Adds the given element to the top of the stack.
	 * @param element - the element to be pushed.
	 */
	public abstract void push(E element);
	
	/**
	* Removes the top element in the stack.
	* @return E - the removed element.
	* @throws EmptyStackException If the stack is empty
	*/
	public abstract E pop() throws EmptyStackException;

	/**
	 * Returns the top element in the stack.
	 * @return E - the top element.
	 * @throws EmptyStackException If the stack is empty
	 */
	public abstract E peek() throws EmptyStackException;

	/**
	 * Returns if the stack is empty.
	 * @return true - if the stack is empty.
	 */
	public abstract boolean isEmpty();

}
