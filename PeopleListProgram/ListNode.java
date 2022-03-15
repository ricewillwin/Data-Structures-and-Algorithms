package PeopleListProgram;

import java.util.List;

public class ListNode<E extends Comparable<E>> implements Comparable<ListNode<E>> {
	
	private E data;
	private ListNode<E> next;
	private ListNode<E> previous;

	/**
	 * Creates a node from the given Data and Next Node
	 * @param data
	 * @param previous
	 * @param next
	 */
	public ListNode(E data, ListNode<E> previous, ListNode<E> next) {
		this.data = data;
		this.previous = previous;
		this.next = next;
	}

	/**
	 * Returns the Data of a node
	 * @return data
	 */
	public E getData() {
		return this.data;
	}

	/**
	 * Returns the Next node
	 * @return next node
	 */
	public ListNode<E> getNext() {
		return this.next;
	}

	/**
	 * Returns the previous node
	 * @return Previous node
	 */
	public ListNode<E> getPrevious() {
		return this.previous;
	}

	/**
	 * Sets the data of a node
	 * @param data
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Sets the nextNode
	 * @param next
	 */
	public void setNext(ListNode<E> next) {
		this.next = next;
	}

	/**
	 * Sets the nextNode
	 * @param next
	 */
	public void setPrevious(ListNode<E> previous) {
		this.previous = previous;
	}

	/**
	 * Overrides toString
	 * @returns String
	 */
	@Override
  public String toString() {
		return this.data.toString();
	}

	/**
	 * Compares the data of this node to the other node
	 * @returns int
	 */
	public int compareTo(ListNode<E> other) {
		return this.data.compareTo(other.getData());
	}

}
