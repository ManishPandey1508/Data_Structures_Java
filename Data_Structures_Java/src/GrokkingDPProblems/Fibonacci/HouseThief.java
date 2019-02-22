package GrokkingDPProblems.Fibonacci;
/*There are ‘n’ houses built in a line. A thief wants to steal maximum possible money from these houses. The only restriction the thief has is that he can’t steal from two consecutive houses, as that would alert the security system. How should the thief maximize his stealing?

Problem Statement
Given a number array representing the wealth of ‘n’ houses, determine the maximum amount of money the thief can steal without alerting the security system.

Example 1:

Input: {2, 5, 1, 3, 6, 2, 4}
Output: 15
Explanation: The thief should steal from houses 5 + 6 + 4
Example 2:

Input: {2, 10, 14, 8, 1}
Output: 18
Explanation: The thief should steal from houses 10 + 8
Let’s first start with a recursive brute-force solution.*/

public class HouseThief {

	public static void main(String[] args) {
		int[] wealth = {2, 10, 14, 8, 1};
		System.out.println("Total Wealth "+houseTheifRecursive(wealth, 0));
	}

	public static int houseTheifRecursive(int[] houses, int index) {

		if (index >= houses.length)
			return 0;
		int rob = houses[index] + houseTheifRecursive(houses, index + 2);
		int noRob = houseTheifRecursive(houses, index + 1);
		return Math.max(rob, noRob);
	}

}
