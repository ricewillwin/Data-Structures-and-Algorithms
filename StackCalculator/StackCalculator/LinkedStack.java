package StackCalculator;

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
		return this.top.getData();
	}

	public E pop() {
		ListNode<E> oldTop = top;
		this.top = top.getNext();
		return oldTop.getData();
	}

	public boolean isEmpty() {
		return top == null;
	}

}
