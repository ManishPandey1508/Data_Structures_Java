package DynamicProgramming;

public class LongestPalidromicSubstring5 {

	public static void main(String[] args) {

		String str = "cbbd";

		System.out.println("Longest Plaindromic Sumstring in  " + str + "   is :-> " + longestPalindromSubString(str));
		System.out.println("Longest Plaindromic Sumstring in  " + str + "   is :-> " + longestPalindrome(str));

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
		// The core logic and code will be same if need to find the length of longest
		// Palidrome substring or Count of all palindromic substring

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

	public static String longestPalindrome(String s) {

		if (s == null || s.length() == 0)
			return s;

		char[] chars = s.toCharArray();
		int n = chars.length;
		int max_length = 1;
		int max_String_starts_at = 0;

		boolean[][] dp = new boolean[n][n];

		// for length 1 palindrome
		for (int i = 0; i < n; i++) {

			dp[i][i] = true;
		}

		// for max_length =2
		for (int j = 0; j < n - 1; j++) {

			if (chars[j] == chars[j + 1]) {
				dp[j][j + 1] = true;
			max_String_starts_at = j;
			max_length = 2;
			}

		}
		// for length > 2

		for (int curr_length = 3; curr_length <= n; curr_length++) {
			int end = n - curr_length + 1;
			for (int j = 0; j < end; j++) {

				int k = j + curr_length - 1;

				if (chars[j] == chars[k] && dp[j + 1][k - 1]) {
					max_length = curr_length;
					max_String_starts_at = j;
					dp[j][k] = true;
				}

			}

		}

		return s.substring(max_String_starts_at, max_String_starts_at + max_length);

	}

}
