/*Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.*/
package Array_Leetcode;

public class ShortestWordDistance {

	public static void main(String[] args) {

		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		System.out.println("Min Distance "+ shortestDistance(words, "practice", "coding"));
		
	}

	public static int shortestDistance(String[] words, String word1, String word2) {

		// Initialize with negative value

		int p1 = -1;
		int p2 = -1;

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			if (word1.equalsIgnoreCase(words[i])) {
				p1 = i;
			}
			if (word2.equalsIgnoreCase(words[i])) {
				p2 = i;
			}

			if (p1 != -1 && p2 != -1)
				min = Math.min(min, Math.abs(p1 - p2));

		}

		return min;

	}

}
