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
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		int n = nums.length;

		Arrays.sort(nums);

		for (int i = 0; i + 2 < nums.length; i++) {

			// If elements are same skip ot next one
			if (i>0 && nums[i] == nums[i-1])
				continue;

			int j = i + 1;
			int target = -nums[i];
			int k = n - 1;

			while (j < k) {
				if (nums[j] + nums[k] == target) {
					ArrayList<Integer> row = new ArrayList<>();
					row.add(nums[i]);
					row.add(nums[j]);
					row.add(nums[k]);
					result.add(row);
					j++;
					k--;
					while (j < k && nums[j] == nums[j + 1])
						j++;
					while (j < k && nums[k] == nums[k - 1])
						k--;
				}

				else if (nums[j] + nums[k] > target)
					k--;
				else
					j++;
			}

		}
		return result;
	}

}
