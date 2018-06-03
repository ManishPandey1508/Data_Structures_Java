/*Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]
*/
package Array_InterviewBit;

import java.util.ArrayList;

public class AntiDiagnols {
	/*
	 * Lets look at how the co-ordinates change when you move from one element
	 * to the other in the anti-diagonal.
	 * 
	 * With every movement, row increases by one, and the column decreases by
	 * one ( or in other words (1, -1) gets added to the current co-ordinates ).
	 * 
	 * Now, all we need to know is the start ( or the first element ) in each
	 * diagonal.
	 * 
	 * Can you figure out which elements qualify as the first elements in each
	 * diagonal ?
	 */

	public static ArrayList<ArrayList<Integer>> antiDiagonal(int[][] matrix) {

		ArrayList<ArrayList<Integer>> diagonals = new ArrayList<ArrayList<Integer>>();

		int len = matrix.length;
		// Add first element of each diagonal starting with the topmost row
		for (int i = 0; i < len; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			row.add(0);
			row.add(i);
			diagonals.add(row);
		}
		// Add first point of those diagonals starting for second row and last
		// column
		for (int i = 1; i < len; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			row.add(i);
			row.add(len-1);
			diagonals.add(row);
		}

		ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
		
		// Now use the logic of +1 -1 as mentioned above... 
		
		for (int i = 0; i < diagonals.size(); i++) {

			ArrayList<Integer> digonal = diagonals.get(i);
			
			int row = digonal.get(0);
			int col = digonal.get(1);
			ArrayList<Integer> resultRow = new ArrayList<>();
			
			while (row < len && col >= 0) {
				resultRow.add(matrix[row][col]);
				row++;
				col--;
				
			}
			finalResult.add(resultRow);

		}

		return finalResult;

	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		ArrayList<ArrayList<Integer>> result = antiDiagonal(matrix);
		
		for (ArrayList<Integer> arrayList : result) {
			
			System.out.print(" { ");
			for (Integer integer : arrayList) {
				System.out.print(" "+ integer);
			}
			System.out.print(" } ");
			System.out.println();
		}
		
	}

}
