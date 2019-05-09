package DynamicProgramming;

/*Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false*/

public class WildCardMatching {

	public static void main(String[] args) {

		System.out.println(isMatch("aaaa","*b"));
		
	}

	public static boolean isMatch(String s, String p)

	{
		if (p.isEmpty())
			return s.isEmpty();

		return isMatchHelper("a" + s, "a" + p);

	}

	private static boolean isMatchHelper(String s, String p) {

		boolean[][] dp = new boolean[p.length()][s.length()];
		dp[0][0] = true;

		// populate for col for all rows
		for (int i = 1; i < p.length(); i++) {

			dp[i][0] = p.charAt(i) == '*' && dp[i - 1][0];

		}

		// populate first row for all string base case
		for (int j = 1; j < s.length(); j++) {

			dp[0][j] = false;

		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {

				if (p.charAt(i) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
				} else if (p.charAt(i) == '?')
					dp[i][j] = dp[i - 1][j - 1];

				else
					dp[i][j] = dp[i - 1][j - 1] && p.charAt(i) == s.charAt(j);
			}
		}

		return dp[p.length()-1][s.length()-1];
	}

}
