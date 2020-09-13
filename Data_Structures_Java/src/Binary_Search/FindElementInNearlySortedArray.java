package Binary_Search;

/*Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.*/

public class FindElementInNearlySortedArray {

	public static void main(String[] args) {

		int[] arr = { 3, 2, 4, 10, 40 };
		int target = 3;
		System.out.println("Index found at " + findElement(arr, 0, arr.length - 1, target));
	}

	public static int findElement(int[] arr, int start, int end, int target) {

		if (start > end)
			return -1;
		int mid = (start + end) / 2;

		if (target == arr[mid]) {
			return mid;
		} else if (mid - 1 >= start && target == arr[mid - 1]) {
			return mid - 1;
		} else if (mid + 1 <= end && target == arr[mid + 1]) {
			return mid + 1;
		} else if (target > arr[mid])
			return findElement(arr, mid + 2, end, target);
		else
			return findElement(arr, start, mid - 2, target);

	}

}
