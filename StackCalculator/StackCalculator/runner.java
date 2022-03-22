package StackCalculator;

import java.io.*;

public class runner {
	
	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = "";

		while (!inputStr.equals("done")) {
			try {
				System.out.print("");
				inputStr = input.readLine();
			}
			catch (IOException e) {
				System.out.println("Invalid Input");
			}
			if (!inputStr.equals("done")) {
				System.out.println(Calculator.calculate(inputStr));
			}
		}
	}

}
