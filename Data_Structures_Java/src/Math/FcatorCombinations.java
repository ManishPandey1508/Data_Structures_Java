package Math;

import java.util.ArrayList;
import java.util.List;

public class FcatorCombinations {

	public static void main(String[] args) {

		int n = 8;
		
		List<List<Integer>> res = getFactors(n);
		
		System.out.println(res);
	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, new ArrayList<Integer>(), n, 2);
		return result;
	}

	public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
		if (n <= 1) {
			if (item.size() > 1) {
				result.add(new ArrayList<Integer>(item));
			}
			return;
		}

		for (int i = start; i <= n; ++i) {
			if (n % i == 0) {
				item.add(i);
				helper(result, item, n / i, i);
				item.remove(item.size() - 1);
			}
		}
	}
}
