package Array_InterviewBit;

/*You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2,..... SN. In a single operation, you can choose two indices L and R
such that 1 ≤ L ≤ R ≤ N  and flip the characters SL, SL+1,.....,
 SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximized. If you do not want to perform the operation, return an empty array. 
Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return  [1, 1].
package Array_InterviewBit;*/

/*Note what is the net change in number of 1s in string S when we flip bits of string S. 
Say it has A 0s and B 1s. Eventually, there are B 0s and A 1s.

So, number of 1s increase by A - B. We want to choose a subarray which maximizes this. Note, if we change 1s to -1, 
then sum of values will give us A - B. Then, we have to find a subarray with maximum sum, which can be done via Kadaneâ€™s Algorithm.
*/

public class FlipBits {

	public Pair flipBits(String bits) {
		// Convert String to array, also convert '1' bit to '-1' and '0' bit to
		// '1'
		int n = bits.length();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			if (bits.charAt(i) == 1) {
				arr[i] = -1;
			} else
				arr[i] = 1;
		}

		Pair ans = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);

		int max_till_now = 0, max_ending_here = 0, l = 0;

		// apply kadane algorithm to find best solution

		for (int i = 0; i < n; i++) {

			if (max_ending_here + arr[i] < 0) {
				max_ending_here = 0;
				l = i + 1;
			} else {
				max_ending_here += arr[i];
			}

			if (max_ending_here > max_till_now) {

				max_till_now = max_ending_here;
				ans.leftIndex = l;
				ans.rightIndex = i;
			}

		}
	
		if(ans.leftIndex ==Integer.MAX_VALUE) return new Pair(0,0);
		else
			return ans;

	}

	class Pair {
		int leftIndex;
		int rightIndex;

		public Pair(int leftIndex, int rightIndex) {

			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
		}

	}

	public static void main(String[] args) {

		FlipBits flipbits = new FlipBits();
		
		Pair ans = flipbits.flipBits("010");
		
		System.out.println("Left "+ans.leftIndex+ " Right "+ans.rightIndex);
		
	}

}
