package StackCalculator;

import java.util.EmptyStackException;
import StackCalculator.Structures.IndexedStack;

public class Calculator {
	
	private static IndexedStack<Character> operatorStack;
	private static String postFixString = "";

	public static int calculate(String equation) {
		convertInfix(equation);
		return PostfixCalculator.calculate(postFixString);
	}

	private static void convertInfix(String equation) {
		operatorStack = new IndexedStack<>(equation.length());
		postFixString = "";

		for (char c : equation.toCharArray()) {
			if (isOperator(c)) {
				operator(c);
			}
			else {
					postFixString += c + " ";
			}
		}
		while (!operatorStack.isEmpty()) {
			postFixString += operatorStack.pop() + " ";
		}
		
	}

	private static boolean isOperator(char c) {
		if ("+-/*()".indexOf(c) != -1) {
			return true;
		}

		return false;
	}

	private static int valueOf(char c) {
		if (c == '+' || c =='-') {
			return 1;
		}
		else if (c == '/' || c == '*') {
			return 2;
		}
		else if (c == '(') {
			return -2;
		}
		else if (c == ')') {
			return -1;
		}
		else {
			return 0;
		}
	}

	private static void operator(char c) {
		try {
			while (valueOf(c) != -2 && valueOf(c) <= valueOf(operatorStack.peek())) {
				postFixString += operatorStack.pop() + " ";
			}
			while (valueOf(c) == -1 && valueOf(operatorStack.peek()) != -2) {
					postFixString += operatorStack.pop() + " ";
			}

			if (valueOf(c) == -1) {
				operatorStack.pop();
			}
			else {
				operatorStack.push(c);
			}
		}
		catch (EmptyStackException e) {
			operatorStack.push(c);
		}
	}

}
