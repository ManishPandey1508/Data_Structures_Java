/*F(i, n) = G(i-1) * G(n-i)	1 <= i <= n 
Combining the above two formulas, we obtain the recursive formula for G(n). i.e.

G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) */

package DynamicProgramming;

public class UniqueBinarySearchTree {

	public static void main(String[] args) {

		int n = 5;

		System.out.println("Total unique BST of 5 Nodes are :-   " + uniqueBST(5));

	}

	static int uniqueBST(int n) {

		if (n == 0 || n == 1)
			return 1;

		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {

			for (int j = 1; j <= i; j++) {

				dp[i] += dp[j - 1] * dp[i - j];

			}

		}

		return dp[n];
	}

}
