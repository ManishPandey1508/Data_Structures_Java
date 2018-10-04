package Strings;

/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lower case letters a-z.*/
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		String answr = longestCommonPrefix(strs);
		System.out.println(answr);
	}

	public static String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0)
			return "";

		String prefix = strs[0];

		for (int i = 0; i < strs.length; i++) {
			if (strs[i] == "") {
				prefix = "";
				break;
			}
			int prefixLength = 0;
			int min = Math.min(prefix.length(), strs[i].length());
			for (int j = 0; j < min; j++) {
				if (strs[i].charAt(j) == prefix.charAt(j)) {
					prefixLength++;
				}
			}

			prefix = prefix.substring(0, prefixLength);
		}

		return prefix;
	}

}
