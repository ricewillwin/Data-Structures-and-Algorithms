package LinkedListProgram;

public class ListNode<E extends Comparable<E>> implements Comparable<ListNode<E>> {
	
	private E data;
	private ListNode<E> next;

	public ListNode(E data, ListNode<E> next) {
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return this.data;
	}

	public ListNode<E> getNext() {
		return this.next;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setNext(ListNode<E> next) {
		this.next = next;
	}

	@Override
  public String toString() {
		return this.data.toString();
	}

	public int compareTo(ListNode<E> other) {
		return this.data.compareTo(other.getData());
	}

}
