package StackCalculator.Structures.Math;

import StackCalculator.Exceptions.InvalidOperatorException;

public class Division implements Operator {
	
	public Division(char c) throws InvalidOperatorException {
		if (c != '/') {
			throw new InvalidOperatorException(Character.toString(c));
		}
	}

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
