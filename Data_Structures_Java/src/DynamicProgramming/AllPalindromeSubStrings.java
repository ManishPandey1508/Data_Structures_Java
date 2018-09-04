package DynamicProgramming;

/*Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".*/

public class AllPalindromeSubStrings {

	public static void main(String[] args) {

		// String str = "aaa";
		String str = "abacac";
		int res = countSubstrings(str);
		System.out.println("No of plaindrome substring of" + str + "   is   " + res);

	}

	/*
	 * We will have 1 double arrays, for storing Boolean relation ship of
	 * palindrome, palindrom[i][j] means substring from i to j is palindrome
	 */

	static int countSubstrings(String s) {

		char[] str = s.toCharArray();
		int n = str.length;

		// Matrix to hold boolean value as 'True'if string is palindrome from i to j
		boolean[][] palindrome = new boolean[n][n];

		// Variable to track count of plaindromes
		int count = 0;
		// all single character will be a plaindrome
		for (int i = 0; i < palindrome.length; i++) {

			palindrome[i][i] = true;
			count++;
		}
		// Now check Palindrome of size two

		for (int i = 0; i < n - 1; i++) {

			if (str[i] == str[i + 1]) {
				palindrome[i][i + 1] = true;
				count++;
			}

		}

		// Now start filling these two matrix for all pair of string of size 3 and more

		for (int gap = 2; gap < n; gap++) {

			for (int i = 0; i < n - gap; i++) {

				int j = i + gap;
				// If new characters are equal and inside of string is already plaindrome
				if (str[i] == str[j] && palindrome[i + 1][j - 1]) {
					palindrome[i][j] = true;
					count++;
				}

			}

		}
		return count;

	}

}
