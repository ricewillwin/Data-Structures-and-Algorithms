package StackCalculator;

import StackCalculator.Exceptions.*;
import StackCalculator.Structures.LinkedStack;
import StackCalculator.Structures.Math.*;

import java.util.EmptyStackException;

public class PostfixCalculator {

	private static LinkedStack<Integer> memStack = new LinkedStack<Integer>();

	/**
	 * Performs an operation on the stack
	 * @param c - The operation to perform
	 * @throws Exception Throws if the given operator or Equation is not valid
	 */
	private static void operate(char c) throws InvalidExpressionException, InvalidOperatorException {
		int digitOne;
		int digitTwo;
		Operator op;
		
		try {
			digitTwo = memStack.pop();
			digitOne = memStack.pop();
			op = createOperator(c);
		}
		catch (EmptyStackException e){
			throw new InvalidExpressionException(memStack);
		}

		try {
			memStack.push(op.operate(digitOne, digitTwo));
		}
		catch (ArithmeticException e) {
			throw new InvalidExpressionException(memStack);
		}

	}

	/**
	 * Returns an operator from a character.
	 * @param c - The character that represents the operator.
	 * @return Operator - The given operator.
	 * @throws InvalidOperatorException - If the given character is not a supported operator.
	 */
	private static Operator createOperator(char c) throws InvalidOperatorException {
		if (c == '+') {
			return new Addition();
		}
		else if (c == '-') {
			return new Subtraction();
		}
		else if (c == '*') {
			return new Multiplication();
		}
		else if (c == '/') {
			return new Division();
		}
		else if (c == '(') {
			return new LeftParenthesis();
		}
		else if (c == ')') {
			return new RightParenthesis();
		}
		else {
			throw new InvalidOperatorException(Character.toString(c));
		}
	}

	/**
	 * Calculates the numerical answer from a given string
	 * @param equation - The equation in postfix notation
	 * @return Integer - The resulting number
	 */
	public static Integer calculate(String equation) {

		while (!memStack.isEmpty()) {
			memStack.pop();
		}

		for (String num : equation.split(" ")) {
			try {
				memStack.push(Integer.parseInt(num));
			}
			catch (NumberFormatException e) {
				try {
					operate(num.charAt(0));
				}
				catch (InvalidExpressionException ee) {
					System.out.println(memStack);
					System.out.println(ee);
					return null;
				}
				catch (InvalidOperatorException ee) {
					System.out.println(ee);
					return null;
				}
			}
		}
		int result = memStack.pop();
		
		if (!memStack.isEmpty()) {
			System.out.println(new InvalidExpressionException(memStack));
			return null;
		}
		else {
			return result;
		}

	}

}