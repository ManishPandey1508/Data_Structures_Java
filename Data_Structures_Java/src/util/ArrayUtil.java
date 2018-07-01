package util;

public class ArrayUtil {

	public static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				if (j != matrix[0].length - 1)
					System.out.print(",");

			}
			System.out.println("]");
		}

	}
}
