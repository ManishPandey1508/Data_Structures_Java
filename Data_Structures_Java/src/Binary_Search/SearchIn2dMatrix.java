package Binary_Search;

/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.*/

public class SearchIn2dMatrix {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

		int row = arr.length;
		int col = arr[0].length;

		int r = 0;
		int c = col - 1;

		System.out.println("Element found  " + searchIn2DArray(arr, 13, r, c, row, col));

	}

	private static boolean searchIn2DArray(int[][] arr, int target, int r, int c, int Row, int Col) {
		// if scanned all values return false
		if (r < 0 || r > Row - 1 || c < 0 || c > Col - 1)
			return false;

		// if found return true
		if (arr[r][c] == target)
			return true;
		// if current is bugger thn target go down
		else if (target > arr[r][c])
			return searchIn2DArray(arr, target, r + 1, c, Row, Col);
		else
			return searchIn2DArray(arr, target, r, c - 1, Row, Col);

	}

}
