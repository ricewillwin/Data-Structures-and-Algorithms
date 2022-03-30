package StackCalculator.Structures;

import java.util.NoSuchElementException;

public class IndexedQueue<E> implements Queue<E> {

	E[] queue;
	int length = 5;
	int front = 0;
	int back = 0;

	/**
	 * Creates an empty Queue.
	 */
	@SuppressWarnings("unchecked")
	public IndexedQueue() {
		queue = (E[]) new Object[this.length];
	}

	@Override
	public boolean isEmpty() {
		return queue[front%5] == null;
	}

	/**
	 * @throws IndexOutOfBoundsException When the list is full.
	 */
	@Override
	public void enqueue(E element) throws IndexOutOfBoundsException {

		if (isFull()) {
			throw new IndexOutOfBoundsException();
		}

		queue[back%5] = element;
		back++;

	}

	@Override
	public E dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E temp = queue[front%5];
		queue[front%5] = null;
		front++;
		return temp;
	}

	@Override
	public E front() throws NoSuchElementException {
		return queue[front%5];
	}
	
	/**
	 * Returns if the list is full.
	 * @return true - if the list is full.
	 */
	private boolean isFull() {
		for (E i : queue) {
			if (i == null) {
				return false;
			}
		}
		return true;
	}

}
