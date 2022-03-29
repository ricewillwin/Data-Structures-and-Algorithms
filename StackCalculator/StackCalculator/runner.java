package StackCalculator;

import java.io.*;

import StackCalculator.Structures.LinkedQueue;

public class runner {
	
	public static void main(String[] args) {
		
		
		try {
			LinkedQueue<String> queue = new LinkedQueue<String>();

			FileReader readFile;
			readFile = new FileReader("Data-Structures-and-Algorithms/StackCalculator/StackCalculator/exampleExpressions");
			BufferedReader inFile = new BufferedReader(readFile);

			String inputString = inFile.readLine();

			while (inputString != null){
				queue.enqueue(inputString);
				inputString = inFile.readLine();
			}

			inFile.close();
		
			String title = "| #   |   Expression\t\t\t|   Result   |";
			String bar = "|-----|---------------------------------|------------|";
			System.out.println(title + "\n" + bar);
			int i = 1;
			while (!queue.isEmpty()) {
				String eq = queue.dequeue();
				Integer result =  Calculator.calculate(eq);
				System.out.println("| " + i + (Integer.toString(i).length() > 1 ? "  " : "   ") 
													 + "|   " + eq + (eq.length() > 5 ? eq.length() > 13 ? eq.length() > 21 ? "\t" : "\t\t" : "\t\t\t" : "\t\t\t\t")
													 + "|   " + result + (result == null ? "\t" : result.toString().length() > 3 ? "\t" : "\t\t") + "\033[3D|");
				i++;
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}
