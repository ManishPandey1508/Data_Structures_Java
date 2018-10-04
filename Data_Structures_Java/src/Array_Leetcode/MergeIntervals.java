package Array_Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.*/
public class MergeIntervals {

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

	public List<Interval> merge(List<Interval> intervals) {

		if (intervals.size() == 0)
			return intervals;
		// Sort the Intervals List on the basis of start point
		// Using Lambda Comporator in Java 8
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		List<Interval> result = new LinkedList<Interval>();

		for (Interval interval : intervals) {

			if (interval.start <= end) {
				end = Math.max(end, interval.end);

			} else {
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;

			}

		}result.add(new Interval(start,end));
		
		return result;
	
    }

}
