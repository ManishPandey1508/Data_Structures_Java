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

		if (t.length() > s.length())
			return "";

		int winStart = 0;
		int winEnd = 0;
		int minWinStart = -1;
		int minWinEnd = -1;
		int minWinlength = Integer.MAX_VALUE;
		boolean matchFound = false;

		int matchedCount = 0;
		Map<Character, Integer> hm = new HashMap<>();
		String res = null;

		// Create freq Map for string t

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c) + 1);
			} else {
				hm.put(c, 1);
			}
		}

		// Traverese theough whole String s

		while (winEnd < s.length()) {

			char c = s.charAt(winEnd);

			// if current character exist in map thn reduce map frequebcy but only change
			// matched
			// count if this actully matters and not reduntant
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c) - 1);
				if (hm.get(c) >= 0)
					matchedCount++;
				
				
			}

			// Check if min found
			while (matchedCount == t.length()) {
				
				if ( minWinlength > winEnd - winStart+1) {
					matchFound = true;
					minWinStart = winStart;
					minWinEnd = winEnd;
					minWinlength = winEnd - winStart + 1;

				}

				char start = s.charAt(winStart);
				if (hm.containsKey(start)) {
					if (hm.get(start) >= 0) {
						matchedCount--;
					}

					hm.put(start, hm.get(start) + 1);
				}

				winStart++;
			}

			winEnd++;
		}

		if (matchFound) {
			return s.substring(minWinStart, minWinEnd + 1);
		} else
			return "";

	}

}
