package Binary_Search;

import java.util.Arrays;

/*Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

Example :

Input : pages[] = {12, 34, 67, 90}
        m = 2
Output : 113
Explanation:
There are 2 number of students. Books can be distributed 
in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 
      2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student
      2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 
      1 with 12 + 34 + 67 = 113 pages
*/
public class MinimumNoOfPages {

	public static void main(String[] args) {
		int nums[] = {1,2,3,1,1};
		Arrays.sort(nums);
		int k = 4;
		System.out.println("Minimum No of pages " + findMinMaxAllocationPages(nums, k));
	}

	private static int findMinMaxAllocationPages(int[] nums, int k) {

		int sum = 0;
		int max=-1;
		for (int i : nums)
		{
			sum += i;
			max=Math.max(max, i);
		}
		int res = -1;
		return helper(nums, k, max, sum, res);
	}

	private static int helper(int[] nums, int k, int start, int end, int res) {

		if (start > end)
			return res;

		int mid = start + (end - start) / 2;

		if (isValid(nums, k, mid)) {
			res = mid;
			return helper(nums, k, start, mid -1 , res);
		} else {
			return helper(nums, k, mid+1, end, res);
		}

	}

	private static boolean isValid(int[] nums, int k, int mid) {

		int n = 1;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > mid) {
				n++;
				sum = nums[i];
			}
			if (n > k)
				return false;
		}
		
		
		return true;
	}

}
