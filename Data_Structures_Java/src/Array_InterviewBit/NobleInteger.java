/*Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.*/
package Array_InterviewBit;

import java.util.Arrays;


public class NobleInteger {
// first of all we have to ask if there is any duplicate or not ..if there are duplicate we have to check for the right most number 
// simple way to solve this problem is to sort the array and check if number is equal to its index.	
	public static int solve(int[] A) {
    
		Arrays.sort(A);
		
		for (int i = 0; i < A.length; i++) {
			// check for duplicate
			if(i< A.length-1 && A[i]==A[i+1]) {
				continue;
			}
			
			if(A[i] == A.length -1 -i) {
				return 1;
			}
			
			
		}
		return -1;
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] A = {4,2,41,3,5,0,35};
		
		System.out.println(solve(A));
		
		
		
	}

}
