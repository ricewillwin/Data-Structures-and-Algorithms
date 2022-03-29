package StackCalculator.Structures;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {

	private Node<E> front;
	private Node<E> back;

	public LinkedQueue() {}

	@Override
	public boolean isEmpty() {
		return this.front == null;
	}

	@Override
	public void enqueue(E element) {
		Node<E> newNode = new Node<E>(element, null);
		if (!isEmpty()) {
			this.back.setNext(newNode);
			this.back = newNode;
		}
		else {
			this.front = newNode;
			this.back = newNode;
		}
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		E temp = this.front.getData();
		this.front = front.getNext();
		return temp;
	}

	@Override
	public E front() throws NoSuchElementException {
		return this.front.getData();
	}
	
}
