package Math;

/*Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false

*/

public class PerfectSquare {

	public static void main(String[] args) {
		
		int n =25;
		
		System.out.println("is Number "+n+" perfect square "+isPerfectSquare(n) );
		
	}
	
	
	
	public static boolean isPerfectSquare(int x) {

		if (x <= 0)
			throw new IllegalArgumentException();

		if (x == 1)
			return true;

		int low = 1;
		int high = x;

		while (low <=high) {

			int mid = low + (high - low) / 2;
			if (mid * mid == x)
				return true;
			else {
				int div = x / mid;
				if (div >= mid) {
					low = mid + 1;
				} else
					high = mid - 1;

			}

		}

		return false;

	}

}
