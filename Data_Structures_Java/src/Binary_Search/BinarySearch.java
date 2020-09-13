package Binary_Search;

public class BinarySearch {

	public static void main(String[] args) {

		int[] nums = { 1, 3, 4, 7, 8, 9, 12, 13, 16, 19 };

		System.out.println("Index of Element 4 is " + binarySerach(nums, 20));

	}

	private static int binarySerach(int[] nums, int i) {

		return binarySerachHelper(nums, i, 0, nums.length - 1);

	}

	private static int binarySerachHelper(int[] nums, int target, int left, int right) {

		if (left > right ) {
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
