package Array_Leetcode;

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
			   0 1 2 4 5 6 7	
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1*/
public class SearchInRotatatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;

		System.out.println(search(arr, target));
	}

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;
			// 4,5,6,7,0,1,2 , target 0

			if (target == nums[mid])
				return mid;
			else if (nums[mid] >= nums[left]) {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

		}
		return -1;
	}

	// Simple Binary Search Tree
	public static int binarySearch(int[] nums, int left, int right, int target) {
		if (left > right)
			return -1;
		int mid = left + (right - left) / 2;

		if (nums[mid] == target)
			return mid;
		else if (nums[mid] > target)
			return binarySearch(nums, left, mid - 1, target);
		else
			return binarySearch(nums, mid + 1, right, target);

	}

}
