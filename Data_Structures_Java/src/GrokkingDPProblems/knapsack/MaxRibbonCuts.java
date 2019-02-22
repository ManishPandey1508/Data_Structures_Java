package GrokkingDPProblems.knapsack;

public class MaxRibbonCuts {

	/*
	 * We are given a ribbon of length ‘n’ and a set of possible ribbon lengths. Now
	 * we need to cut the ribbon into the maximum number of pieces that comply with
	 * the above-mentioned possible lengths. Write a method that will return the
	 * count of pieces.
	 * 
	 * Example 1:
	 * 
	 * 
	 * n: 5 Ribbon Lengths: {2,3,5} Output: 2 Explanation: Ribbon pieces will be
	 * {2,3}.
	 */

	public static void main(String[] args) {

		int[] ribbonLengths = { 2, 3, 5 };
		System.out.println(countRibbonPiecesRecursive(ribbonLengths, 5, 0));
		System.out.println(countRibbonPieceBottomUPDP(ribbonLengths, 5));
	}

	public static int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int currentIndex) {

		if (currentIndex < 0 || currentIndex >= ribbonLengths.length || total < 0) {
			return 0;
		}
		if (total == 0)
			return 1;
		int total1 = 0;
		if (ribbonLengths[currentIndex] <= total)
			total1 = countRibbonPiecesRecursive(ribbonLengths, total - ribbonLengths[currentIndex], currentIndex);

		int total2 = countRibbonPiecesRecursive(ribbonLengths, total, currentIndex + 1);

		return total1 + total2;

	}

	public static int countRibbonPieceBottomUPDP(int[] ribbonLengths, int total) {

		if (ribbonLengths.length == 0 || total == 0)
			return 0;
		int[][] dp = new int[ribbonLengths.length][total + 1];

		for (int i = 0; i < ribbonLengths.length; i++) {

			for (int t = 0; t <= total; t++) {
				dp[i][t] = Integer.MIN_VALUE;
			}
		}

		for (int i = 0; i < ribbonLengths.length; i++) {
			dp[i][0] = 0;
		}

		for (int i = 0; i < ribbonLengths.length; i++) {

			for (int t = 1; t <= total; t++) {

				if (i > 0) {
					dp[i][t] = dp[i - 1][t];
				}
				if (ribbonLengths[i] <= t && dp[i][t - ribbonLengths[i]] != Integer.MIN_VALUE) {
					dp[i][t] = Math.max(dp[i][t], 1 + dp[i][t - ribbonLengths[i]]);
				}

			}

		}

		return dp[ribbonLengths.length - 1][total];

	}

}