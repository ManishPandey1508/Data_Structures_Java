package Array_Leetcode;

import java.util.HashMap;
import java.util.Map;

/*Maximum Size Subarray Sum Equals k
Go to Discuss
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4 
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2 
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
Follow Up:
Can you do it in O(n) time?*/

public class MaxSizeSubArrySumEqualsK {

	public static void main(String[] args) {
int[] nums = {1, -1, 5, -2, 3};
System.out.println(maxSubArrayLen(nums, 3));
		
	}

	public static int maxSubArrayLen(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return 0;
	
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i-1];
			System.out.println(nums[i]);
		}

		
		
		
		
	}
}
