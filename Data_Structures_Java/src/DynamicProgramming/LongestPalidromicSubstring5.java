package DynamicProgramming;

public class LongestPalidromicSubstring5 {

	public static void main(String[] args) {

		String str = "abbcceccbag";

		System.out.println("Longest Plaindromic Sumstring in  " + str + "   is :-> " + longestPalindromSubString(str));

	}

	static String longestPalindromSubString(String str) {

		char[] arr = str.toCharArray();
		int max_len = 1;
		int max_String_start_at = 0;

		// Create an 2d array to dp[i][], dp[i][j] is true if i to j is a palindrome
		boolean[][] dp = new boolean[arr.length][arr.length];

		int n = arr.length;

		// First take care of length one palindrome
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		// Now check for length=2 palindrome

		for (int j = 0; j < n - 1; j++) {

			if (arr[j] == arr[j + 1]) {

				dp[j][j + 1] = true;
				max_String_start_at = j;
				max_len = 2;
			}

		}

		// Now build the dp onwards, gap = 2 and more and whatever be the highest length
		// hold the string as well
		// The core logic and code will be same if need to find the length of longest Palidrome substring or Count of all palindromic substring 
		String temp = "";

		for (int curr_len = 3; curr_len <= n; curr_len++) {

			for (int i = 0; i < n - curr_len + 1; i++) {

				int j = i + curr_len - 1;
				if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
					max_len = curr_len;
					max_String_start_at = i;
					dp[i][j] = true;
				}

			}

		}

		return str.substring(max_String_start_at, max_String_start_at + max_len);

	}

}
