package Array_Leetcode;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int[] sum = { 2, 7, 11, 15 };

		for (int i : twoSum(sum, 9)) {
			System.out.println(i);
		}

	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int firstIndex = 0;
		int lastIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			if (map.containsKey(nums[i])) {
				firstIndex = map.get(nums[i]);
				lastIndex =i ;
			} else {
				map.put(val, i);

			}
		}
		return new int[] { firstIndex, lastIndex };
	}

}
