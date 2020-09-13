package Binary_Search;

public class MaximuInBitonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,5,7,9};

		System.out.println("Maximum ELement in Bitonic Array  " + finMaxInBitonic(nums, 0, nums.length - 1));

	}

	private static int finMaxInBitonic(int[] nums, int start, int end) {

		if (start > end)
			return -1;

		int mid = start + (end - start) / 2;

		if (mid == nums.length - 1 && nums[mid] > nums[mid - 1])
			return nums[mid];

		if (mid == 0 && nums[mid] > nums[mid + 1])
			return nums[mid];

		if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
			return nums[mid];
		} else if (nums[mid] > nums[mid - 1])
			return finMaxInBitonic(nums, mid + 1, end);
		else
			return finMaxInBitonic(nums, start, mid - 1);

	}

}
