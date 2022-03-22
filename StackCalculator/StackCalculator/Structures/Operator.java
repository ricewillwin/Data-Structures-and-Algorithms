package StackCalculator.Structures;

public class Operator implements Comparable<Operator> {
	
	private Character operator;

	public Operator(Character c) {
		if (isOperator(c)) {
			operator = c;
		}
	}

	/**
	 * Checks a character to see if it is a supported operator.
	 * @param c - The operator to check.
	 * @return true - If the given character is an operator.
	 */
	private boolean isOperator(char c) {
		if ("+-/*()".indexOf(c) != -1) {
			return true;
		}

		return false;
	}

	/**
	 * Returns the value of an operator from pemdas with parathesis being given negitive values.
	 * @return Integer - The value of an operator.
	 */
	public Integer valueOf() {
		if (operator == '+' || operator =='-') {
			return 1;
		}
		else if (operator == '/' || operator == '*') {
			return 2;
		}
		else if (operator == '(') {
			return -2;
		}
		else if (operator == ')') {
			return -1;
		}
		else {
			return 0;
		}
	}

	public String toString() {
		return String.valueOf(this.operator);
	}

	public int compareTo(Operator o) {
		return valueOf().compareTo(o.valueOf());
	}

}
