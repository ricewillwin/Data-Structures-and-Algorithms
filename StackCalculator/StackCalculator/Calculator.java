package StackCalculator;

import javax.naming.LinkLoopException;

public class Calculator {

	private static LinkedStack<Integer> memStack = new LinkedStack<Integer>();

	/**
	 * Creates a Calculator
	 */
	// public Calculator() {
	// }

	private static int pow(int numOne, int numTwo) {
		int result = 1;
		for (int i = 0; i < numTwo; i++) {
			result *= numOne;
		}
		return result;
	}

	private static void opp(char c) throws Exception {
		int digitOne;
		int digitTwo;
		
		try {
			digitTwo = memStack.pop();
			digitOne = memStack.pop();
		}
		catch (Exception e){
			throw new Exception("Invalid Equation");
		}

		if (c == '+') {
			memStack.push(digitOne + digitTwo);
			return;
		}
		else if (c == '-') {
			memStack.push(digitOne - digitTwo);
			return;
		}
		else if (c == '*') {
			memStack.push(digitOne * digitTwo);
			return;
		}
		else if (c == '/') {
			memStack.push(digitOne / digitTwo);
			return;
		}
		else if (c == '^') {
			memStack.push(pow(digitOne, digitTwo));
			return;
		}
		else {
			throw new Exception("Invalid Operation");
		}

	}

	public static Integer calculate(String equation) {

		while (!memStack.isEmpty()) {
			memStack.pop();
		}

		for (String num : equation.split(" ")) {
			try {
				memStack.push(Integer.parseInt(num));
			}
			catch (Exception e) {
				try {
					opp(num.charAt(0));
				}
				catch (Exception ee) {
					System.out.println("Invalid Operation");
					return null;
				}
			}
		}
		int result = memStack.pop();
		
		if (!memStack.isEmpty()) {
			System.out.println("Invalid Expression");
			return null;
		}
		else {
			return result;
		}

	}

	public static int calculate(LinkedStack<Integer> equation) {
		return 0;
	}


}