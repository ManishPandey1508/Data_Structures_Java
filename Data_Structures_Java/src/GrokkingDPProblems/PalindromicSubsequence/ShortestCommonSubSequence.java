package GrokkingDPProblems.PalindromicSubsequence;
/*Given two sequences ‘s1’ and ‘s2’, write a method to find the length of the shortest sequence which has ‘s1’ and ‘s2’ as subsequences.

Example 2:

Input: s1: "abcf" s2:"bdcf" 
Output: 5
Explanation: The shortest common super-sequence (SCS) is "abdcf". 
Example 2:

Input: s1: "dynamic" s2:"programming" 
Output: 15
Explanation: The SCS is "dynprogrammicng"*/

public class ShortestCommonSubSequence {

	public static void main(String[] args) {
		System.out.println(" SCS " + SCS("abcf", "bdcf", 0, 0));

	}

	public static int SCS(String s1, String s2, int i1, int i2) {

		if (i1 >= s1.length()) {
			return s2.length() - i2;
		}
		if (i2 >= s2.length())
			return s1.length() - i1;

		if (s1.charAt(i1) == s2.charAt(i2)) {
			return 1 + SCS(s1, s2, i1 + 1, i2 + 1);
		}

		int length2 = 1 + SCS(s1, s2, i1, i2 + 1);
		int length3 = 1 + SCS(s1, s2, i1 + 1, i2);

		return Math.min(length2, length3);

	}

}
