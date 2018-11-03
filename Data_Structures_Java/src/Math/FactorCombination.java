package Math;

import java.util.ArrayList;
import java.util.List;

/*Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:

You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Example 1:

Input: 1
Output: []
Example 2:

Input: 37
Output:[]
Example 3:

Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
Example 4:

Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]*/

public class FactorCombination {

	public static void main(String[] args) {

		System.out.println(getFactors(32));
	}

	public static List<List<Integer>> getFactors(int n) {

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> row = new ArrayList<>();

		if (n < 2)
			return result;

		helper(result, row, 2, n);
		return result;

	}

	private static void helper(List<List<Integer>> result, List<Integer> factor, int start, int n) {

		if (n <= 1) {
			if (factor.size() > 1) {
				result.add(new ArrayList<>(factor));
			}
			return;
		}

		for (int i = start; i <=n; ++i) {
			if (n % i == 0) {
				factor.add(i);
				helper(result, factor, i, n / i);
				factor.remove(factor.size() - 1);
			}

		}

	}

}
