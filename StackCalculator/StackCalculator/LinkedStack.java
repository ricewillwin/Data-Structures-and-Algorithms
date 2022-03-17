package StackCalculator;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
	
	private ListNode<E> top;

	/**
	 * Creates an empty LinkedStack.
	 */
	public LinkedStack() {
		this.top = null;
	}

	public void push(E element) {
		this.top = new ListNode<E>(element, top);
	}
	
	public E peek() {
		try {
			return this.top.getData();
		}
		catch (NullPointerException e) {
			throw new EmptyStackException();
		}
	}

	public E pop() {
		try {
			ListNode<E> oldTop = top;
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

}
