package DynamicProgramming;
/*Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
 *  and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any bulletin function like __builtin_popcount in c++ or in any other language.*/
public class CountingBits338 {

	public static void main(String[] args) {

		int num = 5;
		String binaryForm = decimalToBinary(num);
		System.out.println("Decimal To Binary of  " + num + " is " + binaryForm);

		int[] res = countBits(num);

		System.out.println("Bot Count of " + num);

		for (int i = 0; i < res.length; i++) {

			System.out.println(res[i]);
		}

	}

	/*
	 * This uses the hint from the description about using ranges. Basically, the
	 * numbers in one range are equal to 1 plus all of the numbers in the ranges
	 * before it. If you write out the binary numbers, you can see that numbers 8-15
	 * have the same pattern as 0-7 but with a 1 at the front.
	 */

	// My logic was to copy the previous values (starting at 0) until a power of
	// 2 was hit (new range), at which point we just reset the t pointer back to 0
	// to begin the new range.

	static int[] countBits(int num) {

		int[] rem = new int[num + 1];
		int pow = 1;// to track power of two
		int t = 0;// Pointer to start from 0 till next power of two
		rem[0] = 0;

		for (int i = 1; i <= num; i++) {
			if (i == pow) {
				pow = 2 * pow;
				t = 0;
			}

			rem[i] = rem[t] + 1;
			t++;

		}
		
		return rem;
	}

	static String decimalToBinary(int num) {

		StringBuffer result = new StringBuffer();
		int count = 0;
		while (num > 0) {

			if (num % 2 == 0)
				result.append(0);
			else {
				result.append(1);
				count++;
			}

			num = num / 2;

		}
		return result.reverse().toString();
	}

}
