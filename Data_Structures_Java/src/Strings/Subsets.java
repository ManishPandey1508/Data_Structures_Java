package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/

public class Subsets {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3,4 };
		System.out.println(subsets(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
			List<Integer> tempList = new ArrayList<>();
		backtrack(list, tempList, nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {

		if(start >= nums.length)
		{	
	    list.add(tempList);
		return;
		}
		
		List<Integer> temp1 = new ArrayList<>();
		List<Integer> temp2 = new ArrayList<>();
		temp1.addAll(tempList);
		temp2.addAll(tempList);
		temp2.add(nums[start]);
		start++;
		
		backtrack(list, temp1, nums, start);
		backtrack(list, temp2, nums, start);
	}

}
