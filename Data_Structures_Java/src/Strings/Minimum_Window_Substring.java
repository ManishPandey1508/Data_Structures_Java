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

		

		Map<Character, Integer> map = new HashMap<>();

		// prepare a map of frequency of 't'
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

		}
		
		int left = 0, right = 0, count = 0, minLength = s.length() + 1, minLengthStartsAt = 0;
		
		
		// take a counter as right and starts moving it from left to right of 'S'
		for (right = 0; right < s.length(); right++) {
			
			char key = s.charAt(right);
			// check if right character belongs to t, if it does thn increase count and reduce
			// frequency in map

			if (map.containsKey(key)) {
				map.put(key, map.get(key) - 1);
				
				if (map.get(key) >= 0) {
					count++;				
				}
			}

			while (count == t.length()) {

				if (right - left + 1 < minLength) {
					minLength = right - left + 1;
					minLengthStartsAt = left;
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
		System.out.println("Min Length starts At   ---- " + minLengthStartsAt);
		System.out.println("Min Length ---- " + minLength);
		System.out.println("left "+ left);
		System.out.println("right "+ right);
		
		return minLength == s.length() + 1 ? "" : s.substring(minLengthStartsAt, minLengthStartsAt + minLength);

	}

}
