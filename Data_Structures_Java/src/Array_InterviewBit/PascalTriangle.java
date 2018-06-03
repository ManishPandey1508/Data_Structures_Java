/*Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]*/
package Array_InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static List<List<Integer>> pascalTriangle(int rowNum) {

		if (rowNum == 0)
			throw new IllegalArgumentException();

		List<List<Integer>> pt = new ArrayList<List<Integer>>();

		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(1);
		pt.add(row1);

		if (rowNum == 1)
			return pt;

		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(1);
		row2.add(1);
		pt.add(row2);
		if (rowNum == 2)
			return pt;

		for (int i = 2; i < rowNum; i++) {

			List<Integer> prevRow = pt.get(i - 1);
			List<Integer> currentRow = new ArrayList<>();
			currentRow.add(1);
			for (int j = 1; j < prevRow.size(); j++) {
				int a = prevRow.get(j - 1);
				int b = prevRow.get(j);
				int sum = a + b;
				currentRow.add(sum);
			}
			currentRow.add(1);
			pt.add(currentRow);
		}
		
		return pt;
	}

	public static void main(String[] args) {

		List<List<Integer>> pt = pascalTriangle(5);

		for (List<Integer> list : pt) {
			System.out.print("[");
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.print("]");
		}

	}

}
