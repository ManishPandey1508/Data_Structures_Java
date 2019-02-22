package Array_Leetcode;

public class FindMinInRotatedSortedArray {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2 };

		System.out.println(findMin(arr));
	}

	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];
		return findMinRecursive(nums, 0, nums.length - 1);
	}

	public static int findMinRecursive(int[] nums, int left, int right) {

		if (left == right) {
			return nums[left];
		}
		if (right == left + 1)
			return Math.min(nums[left], nums[right]);

		if (nums[left] < nums[right])
			return nums[left];

		int mid = left + (right - left) / 2;
		if (nums[mid] > nums[left])
			return findMinRecursive(nums, mid, right);
		if (nums[mid] < nums[left])
			return findMinRecursive(nums, left, mid);
		else
			return nums[mid];
	}

}
