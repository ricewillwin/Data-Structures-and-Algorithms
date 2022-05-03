package BinaryTree;

public class BinaryTree<E extends Comparable<E>> {

	/*
	 * 
	 * 
	 * Private Data
	 * 
	 * 
	 */

	private TreeNode<E> root;

	/*
	 * 
	 * 
	 * Constructors
	 * 
	 * 
	 */

	/**
	 * Constructs a Binary Tree
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Constructs a Binary Tree from the given tree node
	 * 
	 * @param top root TreeNode
	 */
	public BinaryTree(TreeNode<E> top) {
		this.root = top;
	}

	/*
	 * 
	 * 
	 * Getters and Setters
	 * 
	 * 
	 */

	/**
	 * @return TreeNode<E> return the root
	 */
	public TreeNode<E> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}

	/*
	 * 
	 * 
	 * Public Methods
	 * 
	 * 
	 */

	/**
	 * Adds the given data to the tree
	 * 
	 * @param data data to add to tree
	 */
	public void add(E data) {
		if (this.root == null) {
			System.out.println("Number added");
			this.root = new TreeNode<E>(data);
		} else {
			this.insert(this.root, new TreeNode<E>(data));
		}
	}

	/**
	 * Recursively finds where node needs to be inserted and then places it
	 * in said location
	 * 
	 * @param node    node to add on to
	 * @param newNode node to add
	 * @return TreeNode<E> top level node after additions
	 */
	private TreeNode<E> insert(TreeNode<E> node, TreeNode<E> newNode) {

		if (node != null) {
			if (newNode.compareTo(node) < 0) {
				node.setLeftNode(insert(node.getLeftNode(), newNode));
			} else if (newNode.compareTo(node) > 0) {
				node.setRightNode(insert(node.getRightNode(), newNode));
			} else {
				System.out.println("Node - " + newNode.getData() + " - is already in tree");
			}
		} else {
			System.out.println("Number added");
			return newNode;
		}
		return node;
	}

	/**
	 * Removes the given data from the tree
	 * 
	 * @param data Data to be removed
	 */
	public void delete(E data) {
		root = deleteData(data, root);
	}

	/**
	 * Removes the given data from a tree starting at a given TreeNode
	 * 
	 * @param data Data to be removed
	 * @param node Starting node
	 * @return Modifed starting node
	 */
	private TreeNode<E> deleteData(E data, TreeNode<E> node) {

		if (node == null) {
			System.out.println("Not in tree");
			return null;
		}

		if (data.compareTo(node.getData()) == 0) {
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				System.out.println("Deletion done");
				return null;
			} else if (node.getLeftNode() != null && node.getRightNode() != null) {
				TreeNode<E> temp = getPreviousNode(node.getData(), node);
				deleteData(temp.getData(), root);
				temp.setLeftNode(node.getLeftNode());
				temp.setRightNode(node.getRightNode());
				System.out.println("Deletion done");
				return temp;
			} else {
				System.out.println("Deletion done");
				if (node.getLeftNode() != null) {
					return node.getLeftNode();
				} else {
					return node.getRightNode();
				}
			}
		}

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftNode(deleteData(data, node.getLeftNode()));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightNode(deleteData(data, node.getRightNode()));
		}

		return node;

	}

	/**
	 * Returns the leaf node that is only 1 position less than the current node.
	 * 
	 * @param data Data to find previous with
	 * @param node Node to start
	 * @return Previous node
	 */
	private TreeNode<E> getPreviousNode(E data, TreeNode<E> node) {

		if (node.getRightNode() != null) {
			if (data.compareTo(node.getRightNode().getData()) > 0) {
				return getPreviousNode(data, node.getRightNode());
			}
			else if (node.getLeftNode() != null) {
				return getPreviousNode(data, node.getLeftNode());
			}
		}

		return node;

	}

	/**
	 * Prints the tree in pre-order notation
	 * 
	 * @param node Starting Node
	 */
	public void preOrder(TreeNode<E> node) {
		if (root == null) {
			System.out.print("Empty");
			return;
		}
		if (node != null) {
			System.out.print(node.getData() + " ");
			preOrder(node.getLeftNode());
			preOrder(node.getRightNode());
		}
	}

	/**
	 * Prints the tree in in-order notation
	 * 
	 * @param node Starting Node
	 */
	public void inOrder(TreeNode<E> node) {
		if (root == null) {
			System.out.print("Empty");
			return;
		}
		if (node != null) {
			inOrder(node.getLeftNode());
			System.out.print(node.getData() + " ");
			inOrder(node.getRightNode());
		}
	}

	/**
	 * Prints the tree in post-order notation
	 * 
	 * @param node Starting Node
	 */
	public void postOrder(TreeNode<E> node) {
		if (root == null) {
			System.out.print("Empty");
			return;
		}
		if (node != null) {
			postOrder(node.getLeftNode());
			postOrder(node.getRightNode());
			System.out.print(node.getData() + " ");
		}
	}

}
