package Binary_Search;

public class FirstOneInBinaryInfiniteSortArr {

	public static void main(String[] args) {

		int[] arr = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1 };

		System.out.println("Index of first 1   : " + findFirstOne(arr));

	}

	private static int findFirstOne(int[] arr) {

		if(arr.length==1)
			return 0;
		int start = 0;
		int end = 1;

		while (arr[end] != 1) {
			start = end;
			end = 2 * end;
		}
		int res = end;
		while (start < end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] == 1) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		return res;

	}
}
