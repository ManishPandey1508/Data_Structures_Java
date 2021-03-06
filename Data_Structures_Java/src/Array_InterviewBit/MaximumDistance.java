/*Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)*/

package Array_InterviewBit;

public class MaximumDistance {

	public int findMaxDistance(int[] arrA) {
		int[] Lmin = new int[arrA.length];
		int[] Rmax = new int[arrA.length];
		int leftMinIndex = 0;
		int leftMinValue = arrA[0];
		int rightMaxValue = arrA[arrA.length - 1];
		int rightMaxIndex = arrA.length - 1;

		// traverse the main array and fill the Lmin array with the index
		// position which has the minimum value so far
		for (int i = 0; i < arrA.length; i++) {
			if (leftMinValue > arrA[i]) {
				leftMinIndex = i;
				leftMinValue = arrA[i];
			}
			Lmin[i] = leftMinValue;
		}
		// for(int i=0;i<Lmin.length;i++){
		// System.out.print("  " + Lmin[i]);
		// }
		// System.out.println("");
		// traverse the main array backwords and fill the Rmax array with the
		// index position which has the maximun value so far
		for (int i = arrA.length - 1; i >= 0; i--) {
			if (rightMaxValue < arrA[i]) {
				rightMaxIndex = i;
				rightMaxValue = arrA[i];
			}
			Rmax[i] = rightMaxValue;
		}
		// for(int i=0;i<Rmax.length;i++){
		// System.out.print("  " + Rmax[i]);
		// }
		System.out.println("");
		// Initialize distance_so_far = -1
		int distance_so_far = -1;
		int i = 0, j = 0;
		// Then check if (Rmax[i]-Lmin[i])>distance_so_far then distance_so_far
		// = Rmax[i]-Lmin[i]
		while (i < arrA.length && j < arrA.length) {
			if (Lmin[i] < Rmax[j]) {
				if ((j - i > distance_so_far)) {
					distance_so_far = j - i;

				}
				j++;
			} else {
				i++;
			}
		}
		return distance_so_far;
	}

	public static void main(String args[]) {
		int[] arrA = { 12, 3, 1, 5, 6, 4, 10, 9, 8, 0 };
		MaximumDistance m = new MaximumDistance();
		int x = m.findMaxDistance(arrA);
		System.out.println("Max(j-i) where j>i and A[j]>A[i] is : " + x);
	}

}
