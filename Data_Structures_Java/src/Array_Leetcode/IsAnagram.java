/*Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.*/

package Array_Leetcode;

import java.util.HashMap;

public class IsAnagram {

	public static void main(String[] args) {
		String s = "anagram", t = "nagarap";

				System.out.println("Strings are anagaram "+ isAnagram(s, t));
	}

	public static boolean isAnagram(String s, String t) {
		// Using HashMap
		if (s == "" || t == "") {
			return s == t;
		}
		HashMap<Character, Integer> map = new HashMap<>();

		for (Character c : s.toCharArray()) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);

		}

		for (Character c : t.toCharArray()) {

			if (!map.containsKey(c)) {
				return false;
			}
			else {
				int n = map.get(c);
				if(n==1)
					map.remove(c);
				else
					map.put(c, n-1);		
			}
		}
		
		return map.isEmpty();

	}

}
