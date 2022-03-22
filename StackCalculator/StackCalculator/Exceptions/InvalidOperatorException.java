package StackCalculator.Exceptions;

public class InvalidOperatorException extends Exception {

	private String operator;

	public InvalidOperatorException(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "The given operator \"" + operator + "\" is not accepted";
	}

}
