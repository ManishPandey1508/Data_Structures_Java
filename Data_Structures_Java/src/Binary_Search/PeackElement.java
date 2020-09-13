package Binary_Search;

public class PeackElement {

	public static void main(String[] args) {
		int[] arr = { 2,1 };
		System.out.println("Index of peak Element " + findPeakElement(arr, 0, arr.length - 1));

	}

	static public int findPeakElement(int[] arr, int start, int end) {

		if (arr.length == 1)
			return 0;
		if (start > end)
			return -1;

		int mid = start + (end - start) / 2;
		if (mid == 0 && arr[mid] > arr[mid + 1])
			return mid;

		if (mid == arr.length - 1 && arr[mid] > arr[mid - 1])
			return mid;

		if (arr[mid + 1] < arr[mid] && arr[mid] > arr[mid - 1]) {

			return mid;
		} else if (arr[mid + 1] > arr[mid]) {
			return findPeakElement(arr, mid + 1, end);
		} else
			return findPeakElement(arr, start, mid - 1);
	}

}
