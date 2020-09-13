package Binary_Search;

public class FindElemInRotatedSorted {

	public static void main(String[] args) {

		int[] nums = {};
		int target = 1;
		int index = findElemInRotatedSorted(nums, 0, nums.length - 1, target);

		System.out.println("Element " + target + "  Index   " + index);

	}

	private static int findElemInRotatedSorted(int[] nums, int start, int end, int target) {

		if (nums.length == 0)
			return -1;

		int minIndex = finMinIndex(nums, start, end);
		int targetIndex = -1;
		if (target == nums[minIndex])
			targetIndex = minIndex;
		else if (target > nums[minIndex] && target < nums[end]) {
			targetIndex = binarySerachHelper(nums, target, minIndex + 1, end);
		}
		else if (target > nums[minIndex] && target > nums[start]) {
			targetIndex = binarySerachHelper(nums, target, start, minIndex - 1);
		}

		return targetIndex;

	}

	// Minimum element will always be in unsorted portion.

	private static int finMinIndex(int[] nums, int start, int end) {

		// Find mid index
		int mid = (start + end) / 2;

		// check if array is already sorted
		if (nums[start] < nums[end]) {
			return start;
		}

		// check if mid is the minimum element return the element
		if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
			return mid;
		} else {
			// go in the the unsorted part
			if (nums[mid] >= nums[start]) {
				return finMinIndex(nums, mid + 1, end);
			} else {
				return finMinIndex(nums, start, mid - 1);
			}

		}

	}

	private static int binarySerachHelper(int[] nums, int target, int left, int right) {

		if (left > right) {
			return -1;
		}
		int middle = (left + right) / 2;

		if (target < nums[middle])
			return binarySerachHelper(nums, target, left, middle - 1);
		else if (target > nums[middle])
			return binarySerachHelper(nums, target, middle + 1, right);
		else
			return middle;

	}

}
