package Array_Leetcode;

import java.util.Arrays;

/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

0    5   15
10   20  30
Input: [[7,10],[2,4]]
Output: 1



*/

public class MeetingsRooms2 {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public int minMeetingRooms(Interval[] intervals) {   


		int n = intervals.length;
		int[] start = new int[n];
		int[] end = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		
		int noofRooms = 0;
		int endIndex = 0;

		for (int i = 0; i < n; i++) {

			if (start[i] < end[endIndex]) {
				noofRooms++;
			} else
				endIndex++;

		}

		return noofRooms;
	
	}
}
