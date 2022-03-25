package StackCalculator.Structures.Math;

public class RightParenthesis implements Operator {

	/**
	 * Creates an Right Parenthesis Operator.
	 */
	public RightParenthesis() {}

	@Override
	public Integer valueOf() {
		return -1;
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
		return ")";
	}

	@Override
	public int compareTo(Operator o) {
		return this.valueOf().compareTo(o.valueOf());
	}
	
}
