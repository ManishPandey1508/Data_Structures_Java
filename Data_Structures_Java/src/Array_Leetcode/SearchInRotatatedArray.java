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

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1*/
public class SearchInRotatatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 5;
		System.out.println(search(arr, target));
	}

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;

		int length = nums.length;

		if (length == 1)
			return nums[0] == target ? 0 : -1;

		return binarySearchHelper(nums, 0, length - 1, target);

	}

	public static int binarySearchHelper(int[] nums, int low, int high, int target) {

		if (low == high)
			return nums[low] == target ? low : -1;

		if (low > high)
			return -1;

		int mid = low + (high - low) / 2;

		if (nums[mid] == target)
			return mid;

		if (nums[low] <= nums[mid]) {

			if (nums[low] <= target && target < nums[mid])
				return binarySearchHelper(nums, low, mid - 1, target);
			else {
				return binarySearchHelper(nums, mid + 1, high, target);
			}
		} else {

			if (target <= nums[high] && target > nums[mid]) {
				return binarySearchHelper(nums, mid + 1, high, target);
			} else {
				return binarySearchHelper(nums, low, mid - 1, target);
			}

		}

	}

}
