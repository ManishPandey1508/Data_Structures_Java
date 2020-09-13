
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class Cisco_test {
	public static void main(String args[]) {
		int numOfElem = 0;
		int[] arr = null;
		String[] stringsArr = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			numOfElem = Integer.parseInt(br.readLine());
			arr = new int[numOfElem];
			String line = br.readLine(); // to read multiple integers line
			stringsArr = line.trim().split("\\s+");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < numOfElem; i++) {

			arr[i] = Integer.parseInt(stringsArr[i]);

		}

		if (arr.length == 0)
			System.out.println(0);
		int dp[] = new int[arr.length + 1];
		dp[0] = 0;
		dp[1] = arr[0];

		// please note that dp[] has one extra element to handle zero house
		for (int i = 1; i < arr.length; i++)
			dp[i + 1] = Math.max(arr[i] + dp[i - 1], dp[i]);

		System.out.print(dp[arr.length]);

	}

}