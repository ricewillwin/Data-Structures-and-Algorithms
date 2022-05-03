package PriorityQueue;

import java.io.*;

public class runner {
	
	public static void main(String[] args) {

		PriorityQueue<Patient> q = new PriorityQueue<>();



		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = "null";

		while (!inputStr.toLowerCase().equals("done")) {
			try {
				System.out.print("\n>>> ");
				inputStr = input.readLine();
	
				if (inputStr.toLowerCase().equals("a")) {
					System.out.print("First Name >>> ");
					String name = input.readLine();
					System.out.print("Last Name >>> ");
					String last = input.readLine();
					System.out.print("Priority >>> ");
					String pri = input.readLine();
					int prio = Integer.parseInt(pri);
					q.enqueue(new Patient(name, last, prio));
				}
				else if (inputStr.toLowerCase().equals("r")) {
					Patient p = q.dequeue();
					if (p == null){
						System.out.println("Empty");
					}
					else {
						System.out.println(p);
					}
				}
				else if (inputStr.toLowerCase().equals("f")) {
					try {
						System.out.println(q.front());
					}
					catch (Exception e) {
						System.out.println("Empty");
					}
				}
				else if (inputStr.toLowerCase().equals("e")) {
					System.out.println(q.isEmpty());
				}
				else if (inputStr.toLowerCase().equals("done")) {}
				else {
					System.out.println("Not a valid command.");
				}
	
			} catch (Exception e) {
				System.out.println("Not a valid command.");
			}
		}


	}

}
/*

>>> a
First Name >>> Zoe
Last Name >>> Field
Priority >>> 10

>>> a
First Name >>> Suzy
Last Name >>> Queue
Priority >>> 5

>>> a 
First Name >>> Ura
Last Name >>> Nerd
Priority >>> 9

>>> a
First Name >>> Cal
Last Name >>> Kulate
Priority >>> 5

>>> a  
First Name >>> Closda
Last Name >>> Windoes
Priority >>> 1

>>> a  
First Name >>> Blaise
Last Name >>> Pascal
Priority >>> 2

>>> a
First Name >>> Sally
Last Name >>> Field
Priority >>> 3

>>> a     
First Name >>> Qwerty
Last Name >>> Keys
Priority >>> 4

>>> a
First Name >>> Linc
Last Name >>> List
Priority >>> 9

>>> a
First Name >>> Ima
Last Name >>> Geek
Priority >>> 1

>>> r
1 : Closda Windoes

>>> r
1 : Ima Geek

>>> r
2 : Blaise Pascal

>>> r
3 : Sally Field

>>> r
4 : Qwerty Keys

>>> r
5 : Suzy Queue

>>> r
5 : Cal Kulate

>>> a
First Name >>> Electromagnetic
Last Name >>> Field          
Priority >>> 8

>>> a
First Name >>> Zoe
Last Name >>> Guest
Priority >>> 7

>>> a
First Name >>> Sally
Last Name >>> Guest
Priority >>> 2

>>> a
First Name >>> April 
Last Name >>> Field
Priority >>> 1

>>> a
First Name >>> Asdfgh
Last Name >>> Keys
Priority >>> 10

>>> a
First Name >>> Mike
Last Name >>> Rochip
Priority >>> 10

>>> a
First Name >>> Amy
Last Name >>> Rochip 
Priority >>> 10

>>> a
First Name >>> Didja
Last Name >>> Windoes
Priority >>> 8

>>> a
First Name >>> Data
Last Name >>> Field
Priority >>> 4

>>> a
First Name >>> Howard        
Last Name >>> Yadoing
Priority >>> 3

>>> r
1 : April Field

>>> r
2 : Sally Guest

>>> r
3 : Howard Yadoing

>>> r
4 : Data Field

>>> r
7 : Zoe Guest

>>> a
First Name >>> Alice
Last Name >>> Ardvaark
Priority >>> 1

>>> a
First Name >>> Genevieve
Last Name >>> Stapos
Priority >>> 10

>>> a  
First Name >>> Abe
Last Name >>> Ardvarrk
Priority >>> 1

>>> a
First Name >>> Doyour 
Last Name >>> Math
Priority >>> 2

>>> a
First Name >>> Iluv
Last Name >>> Math
Priority >>> 2

>>> r
1 : Alice Ardvaark

>>> r
1 : Abe Ardvarrk

>>> r
2 : Doyour Math

>>> a
First Name >>> Sally
Last Name >>> Pascal
Priority >>> 9

>>> r
2 : Iluv Math

>>> r
8 : Electromagnetic Field

>>> r
8 : Didja Windoes

>>> r
9 : Ura Nerd

>>> r
9 : Linc List

>>> r
9 : Sally Pascal

>>> r
10 : Zoe Field

>>> r
10 : Asdfgh Keys

>>> r
10 : Mike Rochip

>>> r
10 : Amy Rochip

>>> r
10 : Genevieve Stapos

>>> r
Empty

>>> done

*/