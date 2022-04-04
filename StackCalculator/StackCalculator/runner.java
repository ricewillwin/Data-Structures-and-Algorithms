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
			readFile = new FileReader("Data-Structures-and-Algorithms/StackCalculator/StackCalculator/list.txt");
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
			while (!outputOueue.isEmpty()) {
				System.out.println(outputOueue.dequeue());
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}

/*

Postfix ->  9*(8-5)
Infix   ->  9 8 5 - * 
Result  ->  27

Postfix ->  (9-8)*5
Infix   ->  9 8 - 5 * 
Result  ->  5

Postfix ->  3/(4*(5-(2+1)))
Infix   ->  3 4 5 2 1 + - * / 
Result  ->  0

Postfix ->  (9/3)/3
Infix   ->  9 3 / 3 / 
Result  ->  1

Postfix ->  9/(3/3)
Infix   ->  9 3 3 / / 
Result  ->  9

Postfix ->  ((2-(3+4))-1+4*3)/7
Infix   ->  2 3 4 + - 1 - 4 3 * + 7 / 
Result  ->  0

Postfix ->  5-(4+3/(2*1))
Infix   ->  5 4 3 2 1 * / + - 
Result  ->  0

Postfix ->  5/(4*(3-(2+1)))
Infix   ->  5 4 3 2 1 + - * / 
Result  ->  null

Postfix ->  (8+8*(4-2))*(3+5-6)
Infix   ->  8 8 4 2 - * + 3 5 + 6 - * 
Result  ->  48

*/