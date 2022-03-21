package StackCalculator;

import java.util.EmptyStackException;

public class IndexedStack<E> implements Stack<E> {

	E[] data;
	int topOfStack = -1;

	public IndexedStack(int length) {
		data = (E[]) new Object[length];
	}

	public void push(E element) {
		topOfStack++;
		data[topOfStack] = element;
		
	}

	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return data[topOfStack--];
	}

	public E peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return data[topOfStack];
	}

	public boolean isEmpty() {
		return topOfStack == -1;
	}

}
