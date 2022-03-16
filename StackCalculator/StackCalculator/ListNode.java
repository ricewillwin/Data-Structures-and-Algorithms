package StackCalculator;

public class ListNode<E> {

	private E data;
	private ListNode<E> next;

	public ListNode(E data, ListNode<E> next) {
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
	public ListNode<E> getNext() {
			return this.next;
	}

	/**
	 * @param next - the next node to set.
	 */
	public void setNext(ListNode<E> next) {
			this.next = next;
	}

}