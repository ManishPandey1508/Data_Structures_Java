package GrokkingDPProblems.PalindromicSubsequence;

//Given a number sequence, find the length of its Longest Alternating Subsequence (LAS). A subsequence is considered alternating if its elements are in alternating order.

//
//A three element sequence (a1, a2, a3) will be an alternating sequence if its elements hold one of the following conditions:
//
//{a1 > a2 < a3 } or { a1 < a2 > a3}. 
//Example 1:
//
//Input: {1,2,3,4}
//Output: 2
//Explanation: There are many LAS: {1,2}, {3,4}, {1,3}, {1,4}
//Example 2:
//
//Input: {3,2,1,4}
//Output: 3
//Explanation: The LAS are {3,2,4} and {2,1,4}.
//Example 3:
//
//Input: {1,3,2,4}
//Output: 4
//Explanation: The LAS is {1,3,2,4}.

public class LongestAlternatingSubSequence {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		System.out.println("LASS  "
				+ Math.max(findLASLengthRecursive(nums, -1, 0, true), findLASLengthRecursive(nums, -1, 0, false)));

	}

	public static int findLASLengthRecursive(int[] nums, int previousIndex, int currentIndex, boolean isAsc) {

		if (currentIndex == nums.length)
			return 0;

		int c1 = 0;
		// if ascending, the next element should be bigger
		if (isAsc) {
			if (previousIndex == -1 || nums[previousIndex] < nums[currentIndex])
				c1 = 1 + findLASLengthRecursive(nums, currentIndex, currentIndex + 1, !isAsc);
		} else { // if descending, the next element should be smaller
			if (previousIndex == -1 || nums[previousIndex] > nums[currentIndex])
				c1 = 1 + findLASLengthRecursive(nums, currentIndex, currentIndex + 1, !isAsc);
		}
		// skip the current element
		int c2 = findLASLengthRecursive(nums, previousIndex, currentIndex + 1, isAsc);
		return Math.max(c1, c2);

	}

}
