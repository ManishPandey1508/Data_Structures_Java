package DynamicProgramming;

import java.util.List;

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

	}

	public boolean wordBreak(String s, List<String> wordDict) {

		if (s.isEmpty())
			return true;

		if (wordDict.isEmpty())
			return false;

		boolean[] dp = new boolean[s.length()];

		for (int i = 0; i < s.length(); i++) {

			for (int j = 0; j <= i; j++) {

				if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1] == true)) {

					System.out.print("temp" + s.substring(j, i + 1));
					dp[i] = true;
					break;
				}

			}

		}

		return dp[s.length() - 1];
	}

}