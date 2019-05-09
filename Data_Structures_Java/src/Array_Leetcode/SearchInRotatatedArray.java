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

		int[] arr = { 5, 1, 3 };
		int target = 3;

		System.out.println(search(arr, target));
	}

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;

		// find the index of pivot

		if (nums.length == 1) {
			if (nums[0] == target)
				return 0;
			else
				return -1;
		}

		int pivot = searchPivot(nums, 0, nums.length - 1);
		int targetIndex = 0;

		if (target == nums[pivot])
			return pivot;
		
		else if (pivot == 0)
			return binarySearchHelper(nums, 0, nums.length - 1, target);

		else if (target > nums[0]) {
			targetIndex = binarySearchHelper(nums, 0, pivot - 1, target);
		} else {
			targetIndex = binarySearchHelper(nums, pivot + 1, nums.length - 1, target);
		}

		return targetIndex;
	}

	public static int searchPivot(int[] nums, int left, int right) {

		// what if its not rotated
		if (nums[left] < nums[right])
			return 0;

		while (left <= right) {

			int pivot = (left + right) / 2;

			if (nums[pivot] > nums[pivot + 1])
				return pivot + 1;

			else {

				if (nums[pivot] < nums[left]) {
					right = pivot - 1;
				} else {
					left = pivot + 1;
				}

			}
		}

		return 0;

	}

	public static int binarySearchHelper(int[] nums, int left, int right, int target) {
		if (left > right)
			return -1;
		int middle = (left + right) / 2;

		if (target == nums[middle])
			return middle;
		else if (nums[middle] > target)
			return binarySearchHelper(nums, left, middle - 1, target);
		else
			return binarySearchHelper(nums, middle + 1, right, target);
	}

}
