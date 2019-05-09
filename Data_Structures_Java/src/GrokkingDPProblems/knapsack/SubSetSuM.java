package GrokkingDPProblems.knapsack;
//Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.

public class SubSetSuM {

	public static void main(String[] args) {
		int[] num = {1, 2, 7, 1, 5};

		System.out.println(canPartition(num, 10));
		System.out.println(canPartitionBottomUP(num, 10));
		System.out.println("Recursive "+ canPartitionRecursive(num,10,0));
	}

	public static boolean canPartition(int[] num, int sum) {

		if (num == null || num.length == 0)
			return false;

		if (sum == 0)
			return true;

		int[][] dp = new int[num.length][sum + 1];

		for (int i = 0; i < dp.length; i++) {

			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}

		boolean result = canPartitionDPTopDown(num, dp, sum, 0);
				
		return result;

	}
	
	private static boolean canPartitionRecursive(int[] num,int target,int index) {
		
		
		if(index>=num.length)
			return target==0;
		if(target==0)
			return true;
		boolean bool1 = false,bool2 = false;
		if(num[index]<= target)
			bool1= canPartitionRecursive(num, target-num[index], index+1);
		bool2 = canPartitionRecursive(num, target, index+1);
		
		return bool1 || bool2;
	}
	
	

	private static boolean canPartitionDPTopDown(int[] num, int[][] dp, int sum, int index) {

		if (sum == 0)
			return true;

		if (index < 0 || index >= num.length)
			return false;

		if (dp[index][sum] != -1)
			return dp[index][sum] == 1 ? true : false;

		// if we include current element in result set
		boolean result = false;
		if (canPartitionDPTopDown(num, dp, sum, index + 1)) {
			dp[index][sum] = 1;
			return true;
		} else if (num[index] <= sum) {
			if (canPartitionDPTopDown(num, dp, sum - num[index], index + 1)) {
				dp[index][sum] = 1;
				result = true;
			} else {
				dp[index][sum] = 0;
			}
		}

		return result;
	}

	
	
	private static boolean canPartitionBottomUP(int[] num, int sum) {

		boolean[][] dp = new boolean[num.length][sum + 1];
		
		// Fill edge scenarios of DP
		// if sum is 0
		for (int i = 0; i < num.length; i++) {
			dp[i][0] = true;
		}

		// if there is just one no , that no should be equal to the sum 
		for (int s = 1; s < sum; s++) {
			
				 dp[0][s] = (num[0] == s ? true : false);
			
		}

		 for (int i = 1; i < num.length; i++) {
		      for (int s = 1; s <= sum; s++) {
		        // if we can get the sum 's' without the number at index 'i'
		        if (dp[i - 1][s]) {
		          dp[i][s] = dp[i - 1][s];
		        } else if (s >= num[i]) {
		          // else include the number and see if we can find a subset to get the remaining
		          // sum
		          dp[i][s] = dp[i - 1][s - num[i]];
		        }
		      }
		    }

		return dp[num.length-1][sum];
	}

}
