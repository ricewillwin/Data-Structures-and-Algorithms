package LinkedListProgram;

public class ListNode<E extends Comparable<E>> implements Comparable<ListNode<E>> {
	
	private E data;
	private ListNode<E> next;

	/**
	 * Creates a node from the given Data and Next Node
	 * @param data
	 * @param next
	 */
	public ListNode(E data, ListNode<E> next) {
		this.data = data;
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
	 * @return nextNode
	 */
	public ListNode<E> getNext() {
		return this.next;
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
