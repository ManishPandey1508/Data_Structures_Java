package Array_Leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.*/

public class SummaryRanges {

	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,7};
		System.out.println(summaryRanges(nums));
	}
	
	
	public static List<String> summaryRanges(int[] nums) {

		List<String> result = new ArrayList<String>();
		if (nums == null || nums.length == 0)
			return result;

		int pre = nums[0];
		int first = nums[0];

		if (nums.length == 1)
			result.add(nums[0] + "");
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] == pre + 1) {

				if (i == nums.length - 1) {
					result.add(first + "->" + nums[i]);
				}

			} else {
				if (first == pre) {
					result.add(first + "");
				} else {
					result.add(first + "->" + pre);
				}

				if (i == nums.length - 1) {
					result.add(nums[i] + "");
				}
				
				first = nums[i];

			}

			pre = nums[i];

		}
		return result;
	}

}
