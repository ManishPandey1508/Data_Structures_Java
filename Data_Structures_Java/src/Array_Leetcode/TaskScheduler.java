package Array_Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.*/

public class TaskScheduler {

	public static void main(String[] args) {

	}

	public int leastInterval(char[] tasks, int n) {

		if (n == 0)
			return tasks.length;
		int count = Integer.MAX_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (char ch : tasks) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				set.add(ch);
				map.put(ch, 1);
			}
		}

		

	}

	private int helper(char[] tasks, int n, int count, Map<Character, Integer> map) {
		
		
		
		
		
	}

}
