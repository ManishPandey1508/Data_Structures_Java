/*A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.*/
package Array_Leetcode;

import util.ArrayUtil;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,2,3,4},{5,1,2,3},{9,5,1,2}
		};
		ArrayUtil.printMatrix(matrix);
		
		System.out.println("Is given Matrix is Toeplitz Matrix ?? " + isToeplitz(matrix));
		

	}

	public static boolean isToeplitz(int[][] matrix) {
		
		int row= matrix.length;
		int col = matrix[0].length;
		boolean isToeplitz = false;
		// Check for top row 
		for(int i=0; i<col;i++) {
			int j=0;
			while(j<row-1 && i<col-1) {
				if(matrix[i][j] != matrix[i+1][j+1])
				{
					return isToeplitz;
				}
				j++;i++;
			}
		}
		// Check for first column 
		
		for (int i = 1; i <row; i++) {
			int j =0;
			while(i<row-1 && j<col-1) {
				if(matrix[i][j]!= matrix[i+1][j+1]) {
					return isToeplitz;	
				}
				i++;j++;
			}
			
			
			
		}
		
		return true;
	}
	
	
	
}
