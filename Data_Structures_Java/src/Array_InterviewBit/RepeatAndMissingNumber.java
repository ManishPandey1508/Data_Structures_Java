/*You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4*/

/* Sum(Actual) = Sum(1...N) + A - B

    Sum(Actual) - Sum(1...N) = A - B. 

    Sum(Actual Squares) = Sum(1^2 ... N^2) + A^2 - B^2

    Sum(Actual Squares) - Sum(1^2 ... N^2) = (A - B)(A + B) 

    = (Sum(Actual) - Sum(1...N)) ( A + B). */


package Array_InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {
	
	// DO NOT MODIFY THE LIST
		public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
		    int arraySize = a.size();
		    long sumOfNumbers = getSumOfNumbers(arraySize);
		    long sumOfSquares = getSumOfSquares(arraySize);
		    long differenceNumber =  getDifferenceofNumbers(a,sumOfNumbers);
		    long differenceSquare = getDifferenceofSquares(a,sumOfSquares);
		    long sumNumber =  differenceSquare/differenceNumber;
		    int repeatedNumber = (int)((sumNumber+differenceNumber)/2);
		    int missingNumber = (int)(sumNumber-repeatedNumber);
		    ArrayList<Integer> result = new ArrayList<>();
		    result.add(repeatedNumber);
		    result.add(missingNumber);
		    return result;
		}
		
		private long getDifferenceofNumbers(List<Integer> a,long sumOfNumbers){
		    long sum = sumOfNumbers*-1;
		    for(Integer number:a){
		        long num = (long)number;
		        sum+=num;;
		    }
		    return sum;
		}
		
		private long getDifferenceofSquares(List<Integer> a, long sumOfSquares){
		    long sumSquares = sumOfSquares*-1;
		    for(Integer number:a){
		         long num = (long)number;
		        sumSquares+=(num*num);
		    }
		    return sumSquares;
		}
		
		private long getSumOfNumbers(double n){
		    return (long)(n*(n-1)/2+n);
		}
		
		private long getSumOfSquares(double n){
		    return (long)(n*(n+1)*(2*n+1)/6);
		}

	
	
	
}
