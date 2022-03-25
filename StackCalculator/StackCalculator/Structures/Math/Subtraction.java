package StackCalculator.Structures.Math;

public class Subtraction implements Operator {
	
	/**
	 * Creates an Subtraction Operator.
	 */
	public Subtraction() {}

	@Override
	public Integer valueOf() {
		return 1;
	}

	@Override
	public Float operate(float numOne, float numTwo) {
		return numOne - numTwo;
	}

	@Override
	public Integer operate(int numOne, int numTwo) {
		return numOne - numTwo;
	}
	
	@Override
	public String toString() {
		return "-";
	}

	@Override
	public int compareTo(Operator o) {
		return this.valueOf().compareTo(o.valueOf());
	}

}
