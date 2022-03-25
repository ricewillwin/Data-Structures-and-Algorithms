package StackCalculator.Structures.Math;

public interface Operator extends Comparable<Operator> {
	
	/**
	 * Returns the value of an operator from pemdas with parathesis being given negitive values.
	 * @return Integer - The value of an operator.
	 */
	public Integer valueOf();

	/**
	 * Operates on two floats.
	 * @param numOne - Float one.
	 * @param numTwo - Float two.
	 * @return Float - result of the operation.
	 */
	public Float operate(float numOne, float numTwo);

	/**
	 * Operates on two intergers.
	 * @param numOne - Integer one.
	 * @param numTwo - Integer two.
	 * @return Integer - result of the operation.
	 */
	public Integer operate(int numOne, int numTwo);

	public int compareTo(Operator o);

}
