package Binary_Search;

public class SearchElementinInfiniteArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 23, 24, 25, 27, 29, 30, 32, 42, 52 };

		int target = 27;

		System.out.println("Element found at Index " + findElement(arr, target));

	}

	private static int findElement(int[] arr, int target) {

		int start = 0;
		int end = 1;

		while (start < end) {
			if (target > arr[end]) {
				start = end;
				end = 2 * end;
			} else if (target < arr[end]) {
				return binarySearch(arr, target, start, end);
			} else {
				return end;
			}

		}
		return -1;
	}

	private static int binarySearch(int[] arr, int target, int start, int end) {

		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (arr[mid] == target)
			return mid;
		else if (arr[mid] > target)
			return binarySearch(arr, target, mid + 1, end);
		else
			return binarySearch(arr, target, start, mid - 1);

	}

}
