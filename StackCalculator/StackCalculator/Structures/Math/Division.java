package StackCalculator.Structures.Math;

public class Division implements Operator {
	
	/**
	 * Creates an Division Operator.
	 */
	public Division() {}

	@Override
	public Integer valueOf() {
		return 2;
	}

	@Override
	public Float operate(float numOne, float numTwo) {
		return numOne / numTwo;
	}

	@Override
	public Integer operate(int numOne, int numTwo) {
		return numOne / numTwo;
	}

	@Override
	public String toString() {
		return "/";
	}

	@Override
	public int compareTo(Operator o) {
		return this.valueOf().compareTo(o.valueOf());
	}

}
