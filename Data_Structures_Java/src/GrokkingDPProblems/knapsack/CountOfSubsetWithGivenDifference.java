package GrokkingDPProblems.knapsack;

public class CountOfSubsetWithGivenDifference {

	public static void main(String[] args) {
		

		int[] nums = {1,1,2,3};
		
		
		int count = countOfSubsetWithGivenDifference(nums,1);
		
		System.out.println("Total subset present are  " + count);
		
		int[][] dp = new int[nums.length+1][count+1];
	}

	private static int countOfSubsetWithGivenDifference(int[] nums, int diff) {
		
		//S1 subset + S2 subset = sum
		// s1 - s2 = diff
		// s1= sum+ diff /2 
		// find all subset with given sum 
		
		int sum =0;
		
		for(int j : nums) {
			sum+=j;
		}
		
		int requiredSum = (sum+diff)/2;
		
		
		return recursionHelper(nums,requiredSum,nums.length);
	}

	private static int recursionHelper(int[] nums, int target,int length) {
		
		
		if(length==0 && target !=0)
			return 0;
		
		if(target==0 )
			return 1;
		else {
			
			if(nums[length-1] <=target) {
				int a = recursionHelper(nums, target-nums[length-1], length -1);
				int b = recursionHelper(nums, target, length-1);
				return a+b;
			}else {
				return  recursionHelper(nums, target, length-1);
			}
		}
			
	}


	
	
	
	
	
	
}
