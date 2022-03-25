package StackCalculator.Exceptions;

public class InvalidOperatorException extends Exception {

	private String operator;

	/**
	 * Creates an Invalid Operator Exception.
	 * @param operator - String operator.
	 */
	public InvalidOperatorException(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "The given operator \"" + operator + "\" is not accepted";
	}

}
