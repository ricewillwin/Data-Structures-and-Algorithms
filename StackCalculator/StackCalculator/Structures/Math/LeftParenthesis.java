package StackCalculator.Structures.Math;

public class LeftParenthesis implements Operator {

	/**
	 * Creates an Left Parenthesis Operator.
	 */
	public LeftParenthesis() {}

	@Override
	public Integer valueOf() {
		return -2;
	}

	@Override
	public Float operate(float numOne, float numTwo) {
		return null;
	}

	@Override
	public Integer operate(int numOne, int numTwo) {
		return null;
	}

	@Override
	public String toString() {
		return "(";
	}

	@Override
	public int compareTo(Operator o) {
		return this.valueOf().compareTo(o.valueOf());
	}
	
}
