package DynamicProgramming;

/*If we sort all the numbers into buckets indexed by these numbers, this is essentially asking you to repetitively take an bucket while giving up the 2 buckets next to it. (the range of these numbers is [1, 10000])

The optimal final result can be derived by keep updating 2 variables skip_i, take_i, which stands for:
skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you skip the ith bucket.
take_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you take the ith bucket.

DP formula:
take[i] = skip[i-1] + values[i];
skip[i] = Math.max(skip[i-1], take[i-1]);
take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;*/

public class DeleteAndEarn {

	public static void main(String[] args) {
		int[] nums = {};
		int res =deleteAndEarn(nums); 
		System.out.println("Result   "+ res);
	}

	static int deleteAndEarn(int[] nums) {

		int[] bucket = new int[1001];
		// Creating Buckets
		for (int num : nums) {
			bucket[num] += num;
		}

		int take = 0, skip = 0;
		for (int i = 0; i < bucket.length; i++) {

			int take_i = skip + bucket[i];
			int skip_i = Math.max(skip, take);
			take = take_i;
			skip = skip_i;

		}
		
		return Math.max(take, skip);
	}

}
