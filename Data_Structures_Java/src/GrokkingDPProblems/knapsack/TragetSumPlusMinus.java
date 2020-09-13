package GrokkingDPProblems.knapsack;

import java.util.Arrays;
import java.util.Collections;

public class TragetSumPlusMinus {

	public static void main(String[] args) {

		Integer[] num = {0,0,0,0,0,1 };
		System.out.println("Answer using brutforce " + findTargetSubsetSumRecursive(num, 1, 0));
		Arrays.sort(num, Collections.reverseOrder());
		System.out.println("Answer using brutforce " + targetSumUsingDP(num, 1));
		
		
		// Test This Approach 
		
		System.out.println(findTargetSumWays(new int[] {0,0,0,0,0,1}, 1));
	}

	public static int findTargetSubsetSumRecursive(Integer[] num, int target, int index) {

		if (index >= num.length) {
			return target == 0 ? 1 : 0;
		}

		int plusCount = findTargetSubsetSumRecursive(num, target - num[index], index + 1);

		int minusCount = findTargetSubsetSumRecursive(num, target + num[index], index + 1);

		return plusCount + minusCount;

	}

	// two set s1-s2 = target
	// s1+s1 = sum --> 2*s1 = target+sum , s1 = target+sum /2;

	public static int targetSumUsingDP(Integer[] num, int target) {
		int sum = 0;

		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}

		int s1 = (target + sum) / 2;

		Integer[][] dp = new Integer[num.length][s1 + 1];

		for (int i = 0; i < num.length; i++) {
			dp[i][0] = 1;
		}

		// if just one element thn it should equal to sum s

		for (int s = 1; s <= s1; s++) {
			dp[0][s] = num[0] == s ? 1 : 0;
		}

		for (int i = 1; i < num.length; i++) {

			for (int s = 1; s <= s1; s++) {

				dp[i][s] = dp[i-1][s];
				if(num[i]<=s) {
					dp[i][s]+= dp[i-1][s-num[i]];
				}
				
			}

		}

		return dp[num.length-1][s1];
		
	}
	
	
	public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(S > sum || (sum + S) % 2 == 1)   return 0;
        return subsetSum(nums, (sum + S) / 2);
    }

    private static int subsetSum(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }

}
