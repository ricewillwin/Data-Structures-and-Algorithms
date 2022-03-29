package StackCalculator.Structures;

import java.util.NoSuchElementException;

public class IndexedQueue<E> implements Queue<E> {

	E[] queue;
	int length = 5;
	int back = -1;

	/**
	 * Creates an empty Queue.
	 */
	@SuppressWarnings("unchecked")
	public IndexedQueue() {
		queue = (E[]) new Object[this.length];
	}

	@Override
	public boolean isEmpty() {
		return queue[0] == null;
	}

	@Override
	public void enqueue(E element) {

		if (back >= length-1) {
			//TODO - do something idfk
		}

		queue[back] = element;
		back++;

	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E front() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
