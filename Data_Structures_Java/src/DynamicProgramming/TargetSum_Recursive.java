package DynamicProgramming;

public class TargetSum_Recursive {

	public static void main(String[] args) {

		int[] nums = {1,1,1,1,1};
		int res = findTargetSumWays(nums, 3);
		System.out.println("Result is   "+ res);
		
		
	}

	static int findTargetSumWays(int[] nums, int S) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (nums == null || nums.length == 0 || S > sum)
			return 0;
		else
			return targetSum(nums, 0, 0, S);

	}

	static int targetSum(int[] nums, int start, int sum, int target) {

		if (start >= nums.length) {

			return sum == target ? 1 : 0;

		} else {

			return targetSum(nums,start+1,sum+nums[start],target) + targetSum(nums,start+1,sum- nums[start],target);
			
		}

	}

}
