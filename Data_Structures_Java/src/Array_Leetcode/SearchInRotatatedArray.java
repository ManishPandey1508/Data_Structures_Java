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

		
		int[] arr = {4,5,6,7,0,1,2};
		int target = 5;
		System.out.println(search(arr,target));
	}

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;

		if (nums.length == 1)
			if (nums[0] == target)
				return 0;
			else
				return -1;

		int pivot = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				pivot = i;
				break;
			}
		}
		int found = -1;
		
		found = binarySearch(nums,target,pivot,nums.length-1);
		if(found==-1) {
			found= binarySearch(nums,target,0,pivot);
		}
		return found;
		
		
	}

	private static int binarySearch(int[] nums, int target, int start, int end) {
		
			if(start ==end)
				return -1;
		int mid = (start + end)/2;
		if(nums[mid]==target)
			return mid;	
		else if(nums[mid] < target)
			return binarySearch(nums, target, mid+1, end);
		else
			return binarySearch(nums, target,start, mid);
	}
}
