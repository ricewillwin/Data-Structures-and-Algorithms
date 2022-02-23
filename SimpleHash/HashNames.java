import java.io.*;

public class HashNames {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = "";

		while (inputStr.toLowerCase() != "done") {
		
			System.out.print("Enter a name: ");
			inputStr = input.readLine();

			if (inputStr.toLowerCase().equals("done")) {
				break;
			}

			int total = 0;
			for (int i = 0; i < inputStr.length(); i++) {
				total += ((int) inputStr.toUpperCase().charAt(i)) - 64;
			}

			System.out.println(total + " : " + total % 10 + "\n");

		}

	}

}
