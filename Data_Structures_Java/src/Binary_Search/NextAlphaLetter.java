package Binary_Search;

public class NextAlphaLetter {

	public static void main(String[] args) {

		char[] arr = { 'a', 'c', 'g', 'h', 'k' };

		char t = 'k';

		System.out.println(findNextElement(arr, t));

	}

	private static char findNextElement(char[] arr, char target) {

		int start = 0;
		int end = arr.length - 1;

		char result = 0;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				if (mid == arr.length - 1)
					return 0;
				return arr[mid + 1];

			} else if (arr[mid] > target) {
				result = arr[mid];
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return result;

	}
}
