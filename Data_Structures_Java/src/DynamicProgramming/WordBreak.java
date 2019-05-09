package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false*/

public class WordBreak {

	public static void main(String[] args) {
		String s = "applepenapple";
		String[] wordDict = { "apple", "pen" };

		System.out.println(
				" Can String be formed ?? " + wordBreakRecursive(s, 0, new HashSet<String>(Arrays.asList(wordDict))));
		Boolean[] dp = new Boolean[s.length()];
		dp[0] = true;
		System.out.println(" Can String be formed ?? " + wordBreakDP1(s, 0, Arrays.asList(wordDict), dp));
	}

	public static boolean wordBreakRecursive(String s, int start, Set<String> wordDict) {

		if (start >= s.length())
			return true;

		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && wordBreakRecursive(s, end, wordDict)) {
				return true;

			}

		}
		return false;

	}

	public static boolean wordBreakDP1(String s, int start, List<String> wordDict, Boolean[] dp) {

		if (start >= s.length())
			return true;

		if (dp[start] != null)
			return dp[start];

		for (int end = start + 1; end <= s.length(); end++) {

			if (wordDict.contains(s.substring(start, end)) && wordBreakDP1(s, end, wordDict, dp)) {
				dp[start] = true;
			}

		}

		return dp[start] = false;

	}

}
