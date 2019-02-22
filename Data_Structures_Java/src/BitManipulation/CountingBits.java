package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/*Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]*/

public class CountingBits {

	public static void main(String[] args) {

		System.out.println(countBits(5));

	}

	public static int[] countBits(int num) {

		List<Integer> list = new ArrayList<Integer>();
		int[] result;
		for (int i = 0; i <= num; i++) {
			list.add(countBitsN(i));
		}

		result = new int[list.size()];
		int j = 0;
		for (int i : list) {
			result[j++] = i;
		}

		return result;
	}

	public static int countBitsN(int n) {

		int sum = 0;

		if (n == 0)
			return sum;
		else {

			while (n > 0) {
				if (n % 2 == 1)
					sum +=n ^ 1;
				n >>= 1;
			}

		}

		return sum;
	}

}
