package Binary_Search;

public class MinimumDiffInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 4, 6, 10 };
		int key = 7;

		System.out.println("Index of min diff element is :   " + findKey(arr, key));

	}

	private static int findKey(int[] arr, int key) {

		int start = 0;
		int end = arr.length - 1;
		int floor = 0;
		int ceil = arr.length - 1;
		while (start < end) {

			int mid = start + (end - start) / 2;

			if (mid == key)
				return mid;
			if (arr[mid] > key) {
				ceil = arr[mid];
				end = mid - 1;
			} else {
				floor = arr[mid];
				start = mid + 1;
			}

		}

		int fd = Math.abs(key - floor);
		int cd = Math.abs(key - ceil);

		return fd >= cd ? floor : ceil;

	}

}
