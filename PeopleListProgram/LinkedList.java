package PeopleListProgram;

import java.security.DrbgParameters.NextBytes;
import java.util.Currency;

public class LinkedList<E extends Comparable<E>> {
	
	private ListNode<E> front;
	private ListNode<E> back;
	private int size;

	/**
	 * Creates a linked list of size 0
	 */
	public LinkedList() {
		this.front = null;
		this.back = null;
		this.size = 0;
	}

	/**
	 * Inserts a node after prior
	 * @param prior
	 * @param newNode
	 * @param dir
	 * @return prior
	 */
	private ListNode<E> insertNode(ListNode<E> prior, ListNode<E> newNode, int dir) {
		
		this.size ++;
		
		if (prior == null) {
			prior = newNode;
			this.front = prior;
			this.back = prior;
			return prior;
		}

		
		if (dir == 0) {
			newNode.setPrevious(prior);
			if (prior.getNext() == null) {
				prior.setNext(newNode);
				this.back = newNode;
				return prior;
			}

			newNode.setNext(prior.getNext());
			prior.getNext().setPrevious(newNode);
			prior.setNext(newNode);
		}
		else {
			newNode.setNext(prior);
			if (prior.getPrevious() == null) {
				// System.out.println(prior + " : " + newNode);
				prior.setPrevious(newNode);
				this.front = newNode;
				return prior;
			}

			newNode.setPrevious(prior.getPrevious());
			prior.getPrevious().setNext(newNode);
			prior.setPrevious(newNode);
		}
		return prior;

	}

	/**
	 * Adds a node from the front of the list
	 * @param newNode
	 * @return something //TODO
	 */
	public String addFront(ListNode<E> newNode) {

		if (this.size == 0) {
			this.insertNode(null, newNode, 0);
			return "";
		}
		
		ListNode<E> current = this.front;
		
		while (current.compareTo(newNode) < 0 && current.getNext() != null) {
			current = current.getNext();
		}

		if (current.getNext() == null) {
			if (current.compareTo(newNode) > 0) {
				insertNode(current, newNode, 1);
			}
			else if (current.compareTo(newNode) < 0) {
				insertNode(current, newNode, 0);
			}
			else {
				return "Already in list";
			}
			return "";
		}

		if (current.compareTo(newNode) < 0) {
			insertNode(current, newNode, 0);
			return "";
		}
		else if (current.compareTo(newNode) > 0) {
			insertNode(current, newNode, 1);
			return "";
		}
		else {
			return "Already in list (or other case)";
		}

	}

	/**
	 * Adds a node from the back of the list
	 * @param newNode
	 * @return something //TODO
	 */
	public String addBack(ListNode<E> newNode) {

		if (this.size == 0) {
			this.insertNode(null, newNode, 1);
			return "";
		}
		
		ListNode<E> current = this.back;
		
		while (current.compareTo(newNode) > 0 && current.getPrevious() != null) {
			current = current.getPrevious();
		}

		if (current.getPrevious() == null) {
			if (current.compareTo(newNode) > 0) {
				insertNode(current, newNode, 1);
			}
			else if (current.compareTo(newNode) < 0) {
				insertNode(current, newNode, 0);
			}
			else {
				return "Already in list";
			}
			return "";
		}

		if (current.compareTo(newNode) < 0) {
			insertNode(current, newNode, 0);
			return "";
		}
		else if (current.compareTo(newNode) > 0) {
			insertNode(current, newNode, 1);
			return "";
		}
		else {
			return "Already in list (or other case)";
		}

	}

	/**
	 * Resets entire list
	 */
	public void reset() {
		this.front = null;
		this.back = null;
	}

	/**
	 * Returns the formatted list
	 * @return formatted list
	 */
	@Override
  public String toString() {

		if (front == null) {
			return "List is empty";
		}

		String out = "[ ";
		ListNode current = front;
		while (current.getNext() != null) {
			out += current.getData() + "\n";
			current = current.getNext();
		}
		out += current.getData() + " ]";
		return out;
	}

	/**
	 * Returns the formatted list backwards
	 * @return formatted list
	 */
	public String backwardsOut() {

		if (back == null) {
			return "List is empty";
		}

		String out = "[ ";
		ListNode current = back;
		while (current.getPrevious() != null) {
			out += current.getData() + "\n";
			current = current.getPrevious();
		}
		out += current.getData() + " ]";
		return out;
	}

	/**
	 * Returns the first 5 elements in the list formatted
	 * @return First 5 elements formatted
	 */
	public String uiOutput() {

		if (front == null) {
			return "List is empty";
		}

		String out = "[ ";
		ListNode current = front;
		int i = 0;
		while (current.getNext() != null && i < 5) {
			out += current.getData() + ", ";
			current = current.getNext();
			i++;
		}
		if (i >= 5) {
			out += "... ]";
		}
		else {
			out += current.getData() + " ]";
		}
		return out;
	}

}