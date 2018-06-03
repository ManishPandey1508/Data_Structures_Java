/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
*/
package Array_InterviewBit;
/*This is more of a simulation problem.

You need to maintain state indicating which direction you are traversing to ( left to right, right to left,
 top to down, down to top ) and then know when to change the directions.

Note that in each direction, either row or column remains constant.

Based on the constant row or column, you can predict when to change the direction.*/

public class SpiralOrderMatrix2 {

	public static int[][] spiralOrderMatrix(int n) {

		int[][] matrix = new int[n][n];

		// i and j is used to trace row and column and k is used to trace value
		// that goes in particular matrix cell
		int i = 0, j = 0, k = 1;
		// dir variable is used to track direction.. direction can either be
		// 0,1,2,3 mean left to right, top to bottom, right to left
		// and bottom to top
		int dir = 0;

		// While all matrix column is filled
		while (k <= n * n) {

			matrix[i][j] = k++;

			if (dir == 0) {
				j++;
				if (j == n || matrix[i][j] != 0) {
					dir = 1;
					j--;
					i++;
				}
			} else if (dir == 1) {
				i++;
				if (i == n || matrix[i][j] != 0) {
					dir = 2;
					i--;
					j--;
				}
			} else if (dir == 2) {
				j--;
				if (j < 0 || matrix[i][j] != 0) {
					dir = 3;
					j++;
					i--;
				}
			} else if (dir == 3) {
				i--;
				if (i < 0 || matrix[i][j] != 0) {
					dir = 0;
					i++;
					j++;
				}
			}

		}
		return matrix;
	}

	public static void main(String[] args) {

		int[][] resultMatrix = spiralOrderMatrix(3);

		for (int i = 0; i < resultMatrix.length; i++) {

			for (int j = 0; j < resultMatrix[0].length; j++) {

				System.out.println(resultMatrix[i][j]);

			}
			System.out.println(" ");
		}

	}

}
