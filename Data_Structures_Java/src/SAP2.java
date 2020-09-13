import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SAP2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Your code goes here
		int h = 0;
		int v = 0;
		int m = 0;
		int n = 0;
		int i = 0;
		List<String> farms = new ArrayList<>();
		while (scan.hasNextLine()) {

			if (i == 0) {
				h = Integer.parseInt(scan.nextLine());
				i++;
			} else if (i == 1) {
				v = Integer.parseInt(scan.nextLine());
				i++;
			} else {
				farms.add(scan.nextLine());

			}

		}

		int noOFStudent = (h + 1) * (v + 1);
		int countOfFLower = 0;

		for (String str : farms) {
			for (char c : str.toCharArray()) {
				if (c == '*') {
					countOfFLower++;
				} else {
					continue;
				}
			}
		}

		if (countOfFLower > noOFStudent)
			System.out.println("TRUE");
		else {
			System.out.println("FALSE");
		}

	}

}
