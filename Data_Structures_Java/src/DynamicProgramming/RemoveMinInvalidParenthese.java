package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
*/

public class RemoveMinInvalidParenthese {

	public static void main(String[] args) {
		String input = "(a)())()";

		List<String> result = removeInvalidParentheses(input);

		for (String str : result) {
			System.out.println(str);
		}

	}

	public static List<String> removeInvalidParentheses(String s) {

		// List to store final pairs
		List<String> result = new ArrayList<>();

		// sanity test
		if (s == null || s.length() == 0)
			return result;

		// Queue to perform BFS
		Queue<String> queue = new LinkedList<>();

		// One set to check if string is already visited

		Set<String> visited = new HashSet<>();

		visited.add(s);
		queue.add(s);
		boolean isFound = false;

		while (!queue.isEmpty()) {

			String p = queue.poll();
			visited.add(p);

			// if Valid string is found no need to check for another level
			if (isValidPalindrome(p)) {
				isFound = true;
				result.add(p);
			}

			if (isFound)
				continue;

			// If valid string is not found then add all string of next level in queue

			// add all string in queue after removing one bracket at a time

			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == '(' || p.charAt(i) == ')') {
					String str = p.substring(0, i) + p.substring(i + 1);
					if (!visited.contains(str)) {
						visited.add(str);
						queue.add(str);
					}

				}

			}

		}

		return result;
	}

	public static boolean isValidPalindrome(String p) {
		if (p == null || p.length() == 0)
			return true;

		int leftCount = 0;
		int rightCount = 0;
		int i = 0;

		while (i < p.length()) {

			if (rightCount > leftCount)
				return false;

			if (p.charAt(i) == '(')
				leftCount++;

			if (p.charAt(i) == ')')
				rightCount++;

			i++;
		}

		return leftCount == rightCount;
	}

}
