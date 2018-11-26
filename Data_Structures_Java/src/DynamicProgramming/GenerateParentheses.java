package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/
public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesisBackTrack(3));

	}

	/*
	 * My method is DP. First consider how to get the result f(n) from previous
	 * result f(0)...f(n-1). Actually, the result f(n) will be put an extra () pair
	 * to f(n-1). Let the "(" always at the first position, to produce a valid
	 * result, we can only put ")" in a way that there will be i pairs () inside the
	 * extra () and n - 1 - i pairs () outside the extra pair.
	 * 
	 * Let us consider an example to get clear view:
	 * 
	 * f(0): ""
	 * 
	 * f(1): "("f(0)")"
	 * 
	 * f(2): "("f(0)")"f(1), "("f(1)")"
	 * 
	 * f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"
	 * 
	 * So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ...
	 * "("f(i)")"f(n-1-i) ... "(f(n-1)")"
	 */ public static List<String> generateParenthesis(int n) {

		List<List<String>> lists = new ArrayList<>();
		ArrayList<String> temp1 = new ArrayList<>();
		temp1.add("");
		lists.add(temp1);

		for (int i = 1; i <= n; i++) {
			ArrayList<String> temp = new ArrayList<String>();

			for (int j = 0; j < i; j++) {

				for (String first : lists.get(j)) {

					for (String last : lists.get(i - j - 1)) {
						temp.add("(" + first + ")" + last);
					}

				}

			}
			lists.add(temp);
		}

		return lists.get(lists.size() - 1);

	}

	public static List<String> generateParenthesisBackTrack(int n) {

		List<String> list = new ArrayList<>();
		backtracking(list, "", 0, 0, n);

		return list;
	}

	private static void backtracking(List<String> list, String string, int open, int close, int max) {

		if (string.length() == 2 * max) {
			list.add(string);
			return;
		}

		if (open < max) {
			backtracking(list, string + "(", open + 1, close, max);
		}
		if (close < open) {
			backtracking(list, string + ")", open, close + 1, max);
		}

	}

}
