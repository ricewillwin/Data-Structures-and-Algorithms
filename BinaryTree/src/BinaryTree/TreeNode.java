package BinaryTree;

public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>> {

	/*
	 * 
	 * 
	 * Private Data
	 * 
	 * 
	 */

	private E data;
	private TreeNode<E> leftNode;
	private TreeNode<E> rightNode;

	/*
	 * 
	 * 
	 * Constructors
	 * 
	 * 
	 */

	/**
	 * Constructs a new tree node from the given data.
	 * 
	 * @param data - Data for the node to store.
	 */
	public TreeNode(E data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}

	/**
	 * Constructs a new tree node from the given data.
	 * 
	 * @param data      - Data for the node to store.
	 * @param leftNode  - Node to the left.
	 * @param rightNode - Node to the right.
	 */
	public TreeNode(E data, TreeNode<E> leftNode, TreeNode<E> rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	/*
	 * 
	 * 
	 * Getters and Setters
	 * 
	 * 
	 */

	/**
	 * @return E return the data
	 */
	public E getData() {
		return this.data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return TreeNode<E> return the leftNode
	 */
	public TreeNode<E> getLeftNode() {
		return this.leftNode;
	}

	/**
	 * @param leftNode the leftNode to set
	 */
	public void setLeftNode(TreeNode<E> leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * @return TreeNode<E> return the rightNode
	 */
	public TreeNode<E> getRightNode() {
		return this.rightNode;
	}

	/**
	 * @param rightNode the rightNode to set
	 */
	public void setRightNode(TreeNode<E> rightNode) {
		this.rightNode = rightNode;
	}

	/*
	 * 
	 * 
	 * Other Methods
	 * 
	 * 
	 */

	@Override
	public int compareTo(TreeNode<E> o) {
		return this.getData().compareTo(o.getData());
	}

}
