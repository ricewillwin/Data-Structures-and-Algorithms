package StackCalculator.Exceptions;

import StackCalculator.Structures.LinkedStack;

public class InvalidExpressionException extends Exception{

	private LinkedStack<Integer> stack;

	/**
	 * Creates an Invalid Expression Exception.
	 * @param stack - the given stack
	 */
	public InvalidExpressionException(LinkedStack<Integer> stack) {
		this.stack = stack;
	}

	@Override
	public String toString() {
		return "Error on stack " + stack;
	}

}