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
			op = Calculator.createOperator(c);
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
					return null;
				}
				catch (InvalidOperatorException ee) {
					return null;
				}
			}
		}
		int result = memStack.pop();
		
		if (!memStack.isEmpty()) {
			return null;
		}
		else {
			return result;
		}

	}

}