package PriorityQueue;

public class runner {
	
	public static void main(String[] args) {

		PriorityQueue<Patient> q = new PriorityQueue<>();

		q.enqueue(new Patient("Zoe", "Field", 10));
		q.enqueue(new Patient("Suzy", "Queue", 5));
		q.enqueue(new Patient("Ura", "Nerd", 9));
		q.enqueue(new Patient("Cal", "Kalate", 5));
		q.enqueue(new Patient("Closda", "Windoes", 1));
		q.enqueue(new Patient("Blaise", "Pascal", 2));
		q.enqueue(new Patient("Sally", "Field", 3));
		q.enqueue(new Patient("Qwerty", "Keys", 4));
		q.enqueue(new Patient("Linc", "List", 9));
		q.enqueue(new Patient("Ima", "Geek", 1));

		for (int i = 0; i<7; i++) {
			System.out.println(q.dequeue());
		}
		System.out.println("\n\n\n");

		q.enqueue(new Patient("Electromagnetic", "Field", 8));
		q.enqueue(new Patient("Zoe", "Guest", 7));
		q.enqueue(new Patient("Sally", "Guest", 2));
		q.enqueue(new Patient("April", "Field", 1));
		q.enqueue(new Patient("Asdfgh", "Keys", 10));
		q.enqueue(new Patient("Mike", "Rochip", 10));
		q.enqueue(new Patient("Amy", "Rochip", 10));
		q.enqueue(new Patient("Didja", "Windoes", 8));
		q.enqueue(new Patient("Data", "Field", 4));
		q.enqueue(new Patient("Howard", "Yadoing", 3));

		for (int i = 0; i<5; i++) {
			System.out.println(q.dequeue());
		}
		System.out.println("\n\n\n");

		q.enqueue(new Patient("Alice", "Ardvaark", 6));
		q.enqueue(new Patient("Genevieve", "Stapos", 10));
		q.enqueue(new Patient("Abe", "Ardvaark", 1));
		q.enqueue(new Patient("Doyour", "Math", 2));
		q.enqueue(new Patient("Iluv", "Math", 2));

		for (int i = 0; i<3; i++) {
			System.out.println(q.dequeue());
		}
		System.out.println("\n\n\n");

		q.enqueue(new Patient("Sally", "Pacal", 9));

		for (int i = 0; i<12; i++) {
			System.out.println(q.dequeue());
		}

	}

}
/*

*/