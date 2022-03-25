package StackCalculator.Structures;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
	
	private Node<E> top;

	/**
	 * Creates an empty LinkedStack.
	 */
	public LinkedStack() {
		this.top = null;
	}

	public void push(E element) {
		this.top = new Node<E>(element, top);
	}
	
	public E peek() throws EmptyStackException {
		try {
			return this.top.getData();
		}
		catch (NullPointerException e) {
			throw new EmptyStackException();
		}
	}

	public E pop() throws EmptyStackException {
		try {
			Node<E> oldTop = top;
			this.top = top.getNext();
			return oldTop.getData();
		}
		catch (NullPointerException e) {
			throw new EmptyStackException();
		}
	}

	public boolean isEmpty() {
		return top == null;
	}
	
	@Override
	public String toString() {
		if (!isEmpty()) {
			return top.toString();
		}
		return "";
	}

}
