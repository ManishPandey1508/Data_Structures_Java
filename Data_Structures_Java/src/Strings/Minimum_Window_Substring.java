package Strings;

import java.util.HashMap;
import java.util.Map;

/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/
public class Minimum_Window_Substring {

	public static void main(String[] args) {

		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	public static String minWindow(String s, String t) {

		if (t == null)
			return "";
		// Map to store frequency of T characters
		Map<Character, Integer> map = new HashMap<>();

		for (char c : t.toCharArray()) {

			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}

		int left = 0, right = 0, count = 0, minLength = s.length() + 1, minStringStartsAt = 0;

		for (right = 0; right < s.length(); right++) {

			// check if right character belongs to t, if it does thn reduce count and reduce
			// frequency in map

			if (map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) - 1);

				if (map.get(s.charAt(right)) >= 0) {
					count++;
				}
			}
			// if count reaches to t.length()
			while (count == t.length()) {
				// calculate the min length

				if (right - left + 1 < minLength) {
					minLength = right - left + 1;
					minStringStartsAt = left;
				}
				if (map.containsKey(s.charAt(left))) {
					map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
					if (map.get(s.charAt(left)) > 0) {
						count--;
					}
				}

				left++;
			}
		}

		if (minLength == s.length() + 1)
			return "";
		else
			return s.substring(minStringStartsAt, minStringStartsAt + minLength);

	}

}
