package StackCalculator.Exceptions;

import StackCalculator.*;
import StackCalculator.Structures.LinkedStack;

public class InvalidExpressionException extends Exception{

	private LinkedStack<Integer> stack;

	public InvalidExpressionException(LinkedStack<Integer> stack) {
		this.stack = stack;
	}

	@Override
	public String toString() {
		return "Error on stack " + stack;
	}

}