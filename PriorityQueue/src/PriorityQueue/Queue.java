package PriorityQueue;

import java.util.NoSuchElementException;

public interface Queue<E> {

	/**
	 * Returns if the queue is empty.
	 * @return true - If the queue is empty.
	 */
	public abstract boolean isEmpty();

	/**
	 * Inserts the given element to the end of the queue.
	 * @param element - The element to add.
	 */
	public abstract void enqueue(E element);

	/**
	 * Removes the front element from the queue.
	 * @return E - The element previously at the front of the queue.
	 * @throws NoSuchElementException When the queue is empty.
	 */
	public abstract E dequeue() throws NoSuchElementException;

	/**
	 * Returns the element at the front of the queue.
	 * @return E - the element at the front of the queue.
	 * @throws NoSuchElementException When the queue is empty.
	 */
	public abstract E front() throws NoSuchElementException;

}
