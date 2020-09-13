package Binary_Search;

public class FindFirstAdnLastIndexSorted {

	public static void main(String[] args) {
		int[] arr = {};

		int target = 2;

		int[] result = FindFirstAdnLastHelper(arr, target);
		System.out.println("First Index " + result[0] + " Last Index " + result[1]);

	}

	private static int[] FindFirstAdnLastHelper(int[] arr, int target) {

		if (arr.length == 0)
			return new int[] { -1, -1 };

		int mid = binarySerachHelper(arr, target, 0, arr.length - 1);
		int found1 = mid;
		int found2 = mid;

		int loop1 = binarySerachHelper(arr, target, 0, found1 - 1);
		while (loop1 != -1 && loop1 < found1) {
			found1 = loop1;
			loop1 = binarySerachHelper(arr, target, 0, found1 - 1);
		}

		int loop2 = binarySerachHelper(arr, target, found2 + 1, arr.length - 1);

		while (loop2 != -1 && loop2 > found2) {
			found2 = loop2;
			loop2 = binarySerachHelper(arr, target, found2 + 1, arr.length - 1);
		}

		return new int[] { found1, found2 };
	}

	private static int binarySerachHelper(int[] nums, int target, int left, int right) {

		if (left > right) {
			return -1;
		}
		int middle = left + (right - left) / 2;

		if (target < nums[middle])
			return binarySerachHelper(nums, target, left, middle - 1);
		else if (target > nums[middle])
			return binarySerachHelper(nums, target, middle + 1, right);
		else
			return middle;

	}
}