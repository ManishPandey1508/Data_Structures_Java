/*Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and 
skipping the third element is invalid.
Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than 
sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index*/
package Array_InterviewBit;

import java.util.ArrayList;

public class MaximumNonNegativeSubArraySum {

	public static ArrayList<Integer> maxNonNegativeSubarraySum(ArrayList<Integer> a) {

		long maxSum = 0;
		long newSum = 0;
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for (Integer i : a) {
			if (i >= 0) {
				newSum += i;
				newArray.add(i);
			} else {
				newSum = 0;
				newArray = new ArrayList<Integer>();
			}
			if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
				maxSum = newSum;
				maxArray = newArray;
			}
		}
		return maxArray;
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(5);
		list.add(-7);
		list.add(2);
		list.add(3);
		list.add(5);

		System.out.println("Answer " + maxNonNegativeSubarraySum(list));

	}

}
