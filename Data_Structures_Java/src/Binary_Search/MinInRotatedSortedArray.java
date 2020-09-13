package Binary_Search;

public class MinInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 2,3,1 };

		int minElement = finMinIndex(nums, 0, nums.length - 1);
		
		System.out.println("Min element "+ minElement);
		
		
	}
// Minimum element will always be in unsorted portion.
	
	private static int finMinIndex(int[] nums, int start, int end) {
		
		// Find mid index
		int mid = (start + end) / 2;

		// check if array is already sorted 
		if (nums[start] < nums[end]) {
			return nums[start];
		}

		// check if mid is the minimum element return the element
		if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
			return nums[mid];
		} else {
			// go in the the unsorted part
			if (nums[mid] >= nums[start]) {
				return finMinIndex(nums, mid + 1, end);
			} else {
				return finMinIndex(nums, start, mid - 1);
			}

		}

	}

}
