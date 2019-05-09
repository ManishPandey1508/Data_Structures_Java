package Array_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 0, 0 };
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int j = i + 1;
			int k = n - 1;
			int target = -nums[i];
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					result.add(list);
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;
				} else if (nums[j] + nums[k] > target) {
					k--;
				} else {
					j++;
				}
			}
		}
		return result;

	}

}
