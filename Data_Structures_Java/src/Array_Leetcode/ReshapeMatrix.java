/*In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted
 reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.*/
package Array_Leetcode;

import util.ArrayUtil;

public class ReshapeMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2},{3,4}};
		
		reShapeMatrix(matrix, 1, 4);
	}

	public static void reShapeMatrix(int[][] matrix, int r, int c) {

		int row = matrix.length;
		int col = matrix[0].length;

		int no_elem = row * col;

		if (r * c != no_elem) {
			System.out.println("Re - Shape not possible");
			return;
		}

		int[][] result = new int[r][c];
		int count = 0;
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {
				int reshapeRow = count / c;
				int reshapeCol = count % c;
				result[reshapeRow][reshapeCol] = matrix[i][j];
				count++;
			}

		}
		
		ArrayUtil.printMatrix(result);

	}

}
