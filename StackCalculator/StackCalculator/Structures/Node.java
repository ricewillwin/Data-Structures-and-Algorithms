package StackCalculator.Structures;

public class Node<E> {

	private E data;
	private Node<E> next;

	/**
	 * Creates a singularly linked node with the given data.
	 * @param data - Data to store
	 * @param next - Following Node
	 */
	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * @return E - the data.
	 */
	public E getData() {
			return this.data;
	}

	/**
	 * @param data - the data to set.
	 */
	public void setData(E data) {
			this.data = data;
	}

	/**
	 * @return ListNode<E> - the next node.
	 */
	public Node<E> getNext() {
			return this.next;
	}

	/**
	 * @param next - the next node to set.
	 */
	public void setNext(Node<E> next) {
			this.next = next;
	}

}