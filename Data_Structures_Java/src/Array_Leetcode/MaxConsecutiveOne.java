/*Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000*/
package Array_Leetcode;

public class MaxConsecutiveOne {

	public static void main(String[] args) {
	int[] arr = {1,1,0,1,1,1,0,0,0,1,1,1,1,1,1,0,1,1};
	System.out.println("Max Ones "+ maxOnes(arr));
	}
	
	public static int maxOnes(int[] arr) {
		
		int currentMax=0;
		int totalMax =0;
		
		for(int i =0; i< arr.length;i++) {
			if(arr[i]!=1) {
				currentMax=0;
				continue;
			}
			
			if(arr[i]==1) {
				currentMax++;
			}
			totalMax = Math.max(totalMax, currentMax);
		}	
		return totalMax;
	}

}
