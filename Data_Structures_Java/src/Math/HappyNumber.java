/*Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of
 its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
  Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
1 + 81 = 82
64 + 4 = 68
36 + 64 = 100
1 + 0 + 0 = 1*/
package Math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		
		int n = 2;
		
		System.out.println("Lucky Number "+ isHappy(n));
		
	}
	
	
	
	
	public static boolean isHappy(int n) {
		 Set<Integer> inLoop = new HashSet<Integer>();
		if (n == 1)
			return true;
		if (n == 0)
			return false;

		// Run Infinite
		int squareSum = 0;
		int remainingNo = n;
		while (inLoop.add(squareSum)) {
			squareSum =0;
			while (remainingNo != 0) {
				int lastDigit = remainingNo % 10;
				squareSum += lastDigit * lastDigit;
				remainingNo = remainingNo / 10;
			}

			remainingNo = squareSum;
		}
		
		if(squareSum ==1) {
			return true;
		}
		
		return false;
	}

}
