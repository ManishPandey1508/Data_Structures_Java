/*LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.*/
package DynamicProgramming;

public class LongestCommonSubSequence {

	public static void main(String[] args) {

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n));

	}

	static int lcs(char[] x, char[] y, int m, int n) {

		// make two dimensional array

		int[][] mapping = new int[m+1][n+1];

		for (int i = 0; i <= m; i++) {

			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					mapping[i][j] = 0;
				} else if (x[i-1] == y[j-1]) {

					mapping[i][j] = 1 + mapping[i - 1][j - 1];
				} else {

					mapping[i][j] = Math.max(mapping[i][j - 1], mapping[i - 1][j]);
				}
			}

		}

		return mapping[m][n];

	}

}
