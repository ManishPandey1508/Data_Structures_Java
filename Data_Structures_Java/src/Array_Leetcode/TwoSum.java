/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

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
