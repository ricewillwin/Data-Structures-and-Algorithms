package StackCalculator.Structures;

import java.util.NoSuchElementException;

public class InputQueue<E> implements Queue<Node<E>> {

	private Node<E> front;
	private Node<E> back;

	public InputQueue() {}

	@Override
	public boolean isEmpty() {
		return this.front == null;
	}

	@Override
	public void enqueue(Node<E> element) {
		if (!isEmpty()) {
			this.back.setNext(element);
			this.back = element;
		}
		else {
			this.front = element;
			this.back = element;
		}
	}

	@Override
	public Node<E> dequeue() throws NoSuchElementException {
		Node<E> temp = this.front;
		this.front = front.getNext();
		return temp;
	}

	@Override
	public Node<E> front() throws NoSuchElementException {
		return this.front;
	}
	
}
