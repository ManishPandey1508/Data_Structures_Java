package Strings;
/*Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.*/

public class OneEditDistance {

	public boolean isOneEditDistance(String s, String t) {

		if (s == null || t == null)
			return false;

		int m = s.length();
		int n = t.length();

		if (Math.abs(m - n) > 1)
			return false;

		int i = 0, j = 0;
		int count = 0;

		while (i < m && j < n) {

			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				count++;
				if (count > 1)
					return false;
				// s = "abc", t = "bc"
				if (m > n) {
					i++;
				} else if (m < n) { // s = "bc", t = "abc"
					j++;
				} else { 
					i++;
					j++;
				}

			}

		}

		if(count==1)
			return true;
		else
		return false;

	}

}
