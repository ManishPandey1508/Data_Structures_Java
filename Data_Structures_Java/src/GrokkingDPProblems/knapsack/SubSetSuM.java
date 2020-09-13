package GrokkingDPProblems.knapsack;
//Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.

public class SubSetSuM {

	public static void main(String[] args) {
		int[] num = { 3, 34, 4, 12, 5, 2 };

		System.out.println(subSetSumRecurBottomUP(num, 13));
		System.out.println("Recursive " + subSetSumRecur(num, 13, num.length));
	}

	private static boolean subSetSumRecur(int[] num, int target, int size) {

		if (size == 0 && target != 0)
			return false;
		else if (target == 0)
			return true;
		else {
			if (num[size - 1] <= target) {
				boolean a = subSetSumRecur(num, target - num[size - 1], size - 1);
				boolean b = subSetSumRecur(num, target, size - 1);
				return a || b;
			} else {
				return subSetSumRecur(num, target, size - 1);
			}
		}

	}
	
	
	private static boolean subSetSumRecurBottomUP(int[] num, int sum) {

		boolean[][] dp = new boolean[num.length + 1][sum + 1];

		for (int i = 0; i < num.length + 1; i++) {

			for (int j = 0; j < sum + 1; j++) {
				if(i==0 && j!=0)
					dp[i][j]=false;
				else if(j==0)
					dp[i][j] = true;

				else {
					if (num[i - 1] <= j) {
						dp[i][j] = dp[i - 1][j - num[i - 1]] || dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j];
					}

				}

			}
		}

		return dp[num.length][sum];
	}

}
