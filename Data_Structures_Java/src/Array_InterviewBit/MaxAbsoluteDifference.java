/*You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.*/
/*We can surely use some math here. Try to Expand the Function you are trying to maximise. F(i,j) = |A[i] - A[j]| + |i - j| Expanding it will give us 4 values of F.

A[i] - A[j] + i - j equals to [A[i] + i] - [A[j]+j]
-A[i] + A[j] + i - j equals to [-A[i] + i] - [-A[j]+j]
A[i] - A[j] + j - i equals to [A[i] - i] - [A[j]-j]
-A[i] + A[j] + j - i equals to [-A[i] - i] - [-A[j]-j]
Compute the Maximum and Minimum Value of [A[i] + i],[-A[i] + i],[A[i] - i],[-A[i] - i] for all elements in vector/array. call it max1,max2,max3,max4 and min1,min2,min3,min4.

Your Answer is Max((max1-min1),(max2-min2),(max3-min3),(max4-min4)).
*/

package Array_InterviewBit;

public class MaxAbsoluteDifference {

	public static int maxAbsDifference(int[] nums) {
	
		
		
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		

	}

}
