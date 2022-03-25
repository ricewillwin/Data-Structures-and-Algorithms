package StackCalculator;

import java.util.EmptyStackException;

import StackCalculator.Exceptions.InvalidOperatorException;
import StackCalculator.Structures.IndexedStack;
import StackCalculator.Structures.Math.*;

public class Calculator {

	/**
	 * Calculates the Integer result of the given infix string.
	 * @param expression - Expression to solve in infix notation.
	 * @return Integer - Result of the expression.
	 */
	public static Integer calculate(String expression) {
		String eq = convertInfix(expression);
		System.out.println(eq);
		return PostfixCalculator.calculate(eq);
	}

	/**
	 * Converts from infix to postfix.
	 * @param expression - The equation to convert.
	 * @return String - The given expression in postfix notation.
	 */
	private static String convertInfix(String expression) {
		IndexedStack<Operator> operatorStack = new IndexedStack<>(expression.length());
		String postFixString = "";

		for (char c : expression.toCharArray()) {
			try {
				Operator op = createOperator(c);
				Object[] temp = operator(op, operatorStack, postFixString);
				operatorStack =  (IndexedStack<Operator>) temp[0];
				postFixString = (String) temp[1];
			}
			catch (Exception e) {
				if (c != ' ') {
					postFixString += c + " ";
				}
			}
		}
		while (!operatorStack.isEmpty()) {
			postFixString += operatorStack.pop() + " ";
		}

		return postFixString;
		
	}

	/**
	 * Returns an operator from a character.
	 * @param c - The character that represents the operator.
	 * @return Operator - The given operator.
	 * @throws InvalidOperatorException - If the given character is not a supported operator.
	 */
	private static Operator createOperator(char c) throws InvalidOperatorException {
		if (c == '+') {
			return new Addition(c);
		}
		else if (c == '-') {
			return new Subtraction(c);
		}
		else if (c == '*') {
			return new Multiplication(c);
		}
		else if (c == '/') {
			return new Division(c);
		}
		else if (c == '(') {
			return new LeftParenthesis(c);
		}
		else if (c == ')') {
			return new RightParenthesis(c);
		}
		else {
			throw new InvalidOperatorException(Character.toString(c));
		}
	}

	/**
	 * Adds or removed operators from the stack.
	 * @param operator - Operator to add.
	 * @param operatorStack - Stack of operators.
	 * @param postFixString - String in postfix notation.
	 * @return {operatorStack, postFixString} - The modified values
	 */
	private static Object[] operator(Operator operator, IndexedStack<Operator> operatorStack, String postFixString) {
		try {

			while (operator.valueOf() != -2 && operator.compareTo(operatorStack.peek()) <= 0) {
				postFixString += operatorStack.pop() + " ";
			}
			while (operator.valueOf() == -1 && operatorStack.peek().valueOf() != -2) {
				postFixString += operatorStack.pop() + " ";
			}
			
			if (operator.valueOf() == -1) {
				operatorStack.pop();
			}
			else {
				operatorStack.push(operator);
			}
		}
		catch (EmptyStackException e) {
			operatorStack.push(operator);
		}

		return new Object[]{operatorStack, postFixString};

	}

}
