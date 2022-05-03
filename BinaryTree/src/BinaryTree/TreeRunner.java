package BinaryTree;

import java.io.*;

public class TreeRunner {

	public static void main(String[] args) {

		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		String inputStr = "";

		while (!inputStr.equals("done")) {

			try {
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Action: ");
				inputStr = input.readLine();
				inputStr = inputStr.toLowerCase();

				if (inputStr.equals("add")) {
					Boolean d = false;
					while (!d) {
						System.out.print("Number to add: ");
						inputStr = input.readLine();
						try {
							tree.add(Integer.parseInt(inputStr));
							d = true;
						} catch (NumberFormatException e) {
							d = false;
						}
					}
					System.out.println();
				}

				if (inputStr.equals("del")) {
					Boolean d = false;
					while (!d) {
						System.out.print("Number to del: ");
						inputStr = input.readLine();
						try {
							tree.delete(Integer.parseInt(inputStr));
							d = true;
						} catch (NumberFormatException e) {
							d = false;
						}
					}
					System.out.println();
				}

				if (inputStr.equals("pre")) {
					System.out.print("PreOrder: ");
					tree.preOrder(tree.getRoot());
					System.out.println("\n");
				}

				if (inputStr.equals("in")) {
					System.out.print("InOrder: ");
					tree.inOrder(tree.getRoot());
					System.out.println("\n");
				}

				if (inputStr.equals("post")) {
					System.out.print("PostOrder: ");
					tree.postOrder(tree.getRoot());
					System.out.println("\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}

/*
 * 
 * Action: pre
 * PreOrder: Empty
 * 
 * Action: add
 * Number to add: 13
 * Number added
 * 
 * Action: add
 * Number to add: 10
 * Number added
 * 
 * Action: add
 * Number to add: 20
 * Number added
 * 
 * Action: add
 * Number to add: 12
 * Number added
 * 
 * Action: add
 * Number to add: 15
 * Number added
 * 
 * Action: add
 * Number to add: 5
 * Number added
 * 
 * Action: pre
 * PreOrder: 13 10 5 12 20 15
 * 
 * Action: in
 * InOrder: 5 10 12 13 15 20
 * 
 * Action: post
 * PostOrder: 5 12 10 15 20 13
 * 
 * Action: del
 * Number to del: 5
 * Deletion done
 * 
 * Action: add
 * Number to add: 30
 * Number added
 * 
 * Action: add
 * Number to add: 40
 * Number added
 * 
 * Action: add
 * Number to add: 11
 * Number added
 * 
 * Action: del
 * Number to del: 18
 * Not in tree
 * 
 * Action: add
 * Number to add: 35
 * Number added
 * 
 * Action: add
 * Number to add: 50
 * Number added
 * 
 * Action: del
 * Number to del: 0
 * Not in tree
 * 
 * Action: del
 * Number to del: 20
 * Deletion done
 * Deletion done
 * 
 * Action: in
 * InOrder: 10 11 12 13 15 30 35 40 50
 * 
 * Action: del
 * Number to del: 50
 * Deletion done
 * 
 * Action: add
 * Number to add: 2
 * Number added
 * 
 * Action: del
 * Number to del: 13
 * Deletion done
 * Deletion done
 * 
 * Action: del
 * Number to del: 100
 * Not in tree
 * 
 * Action: del
 * Number to del: 10
 * Deletion done
 * Deletion done
 * 
 * Action: del
 * Number to del: 2
 * Deletion done
 * 
 * Action: in
 * InOrder: 11 12 15 30 35 40
 * 
 * Action: del
 * Number to del: 15
 * Deletion done
 * 
 * Action: del
 * Number to del: 12
 * Deletion done
 * Deletion done
 * 
 * Action: del
 * Number to del: 30
 * Deletion done
 * 
 * Action: del
 * Number to del: 35
 * Deletion done
 * 
 * Action: del
 * Number to del: 40
 * Deletion done
 * 
 * Action: post
 * PostOrder: 11
 * 
 * Action: add
 * Number to add: 10
 * Number added
 * 
 * Action: add
 * Number to add: 15
 * Number added
 * 
 * Action: add
 * Number to add: 20
 * Number added
 * 
 * Action: add
 * Number to add: 5
 * Number added
 * 
 * Action: pre
 * PreOrder: 11 10 5 15 20
 * 
 * Action: in
 * InOrder: 5 10 11 15 20
 * 
 * Action: post
 * PostOrder: 5 10 20 15 11
 * 
 * Action: done
 * 
 */