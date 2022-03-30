package StackCalculator;

import java.io.*;

import StackCalculator.Structures.Queue;
import StackCalculator.Structures.LinkedQueue;
import StackCalculator.Structures.IndexedQueue;

public class runner {
	
	public static void main(String[] args) {
		
		
		try {
			Queue<String> inputQueue = new LinkedQueue<String>();
			Queue<String> outputOueue = new IndexedQueue<String>();

			FileReader readFile;
			readFile = new FileReader("Data-Structures-and-Algorithms/StackCalculator/StackCalculator/exampleExpressions");
			BufferedReader inFile = new BufferedReader(readFile);

			String inputString = inFile.readLine();

			while (inputString != null){
				inputQueue.enqueue(inputString);
				inputString = inFile.readLine();
			}

			inFile.close();
		
			while (!inputQueue.isEmpty()) {
				String eq = inputQueue.dequeue();
				eq += "\nInfix\t->  " + Calculator.calculate(eq);
				eq = "\nPostfix\t->  " + eq;
				try {
					outputOueue.enqueue(eq);
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println(outputOueue.dequeue());
					outputOueue.enqueue(eq);
				}
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}
