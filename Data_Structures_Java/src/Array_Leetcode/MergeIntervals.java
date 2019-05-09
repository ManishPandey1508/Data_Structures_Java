package Array_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

	
	public static void main(String[] args) {
		
		
		int[][] arr = {{1,4},{2,3}};
		int[][] result = merge(arr);
		for(int[] temp:result) {
			System.out.println(temp[0]+" , "+temp[1]);
		}
		
	}
	
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

		List<Interval> result = new ArrayList<>();

		if (intervals == null || intervals.isEmpty())
			return result;

		intervals.sort((i1, i2) -> new Integer(i1.start).compareTo(new Integer(i2.start)));

		Stack<Interval> stack = new Stack<>();

		stack.push(intervals.get(0));

		for (int i = 1; i < intervals.size(); i++) {

			Interval top = stack.peek();
			System.out.println("Top Start "+ top.start+ "  Top End  "+ top.end);
			System.out.println("Intervals ith Start "+ intervals.get(i).start+ "  Intervals ith End  "+ intervals.get(i).start);
			if (intervals.get(i).start < top.end) {
				stack.pop();
				Interval interval = new Interval(Math.min(top.start, intervals.get(i).start),
						Math.max(top.end, intervals.get(i).end));
				stack.push(interval);
			} else {
				stack.push(intervals.get(i));
			}

		}

		while(!stack.isEmpty()) {
			result.add(stack.pop());
		}
		
		return result;
	}
	
public static int[][] merge(int[][] intervals) {
				
	if(intervals==null || intervals.length <=1)		
        return intervals;
	
	 Integer[][] temparr = new Integer[intervals.length][intervals[0].length];
	 
	 	for(int i=0;i< intervals.length;i++) {
	 		for(int j=0;j<intervals[0].length;j++)
	 		{
	 			temparr[i][j]= intervals[i][j];
	 		}
	 	}
	 
        Arrays.sort(temparr, new Comparator<Integer[]>() {
			public int compare(Integer[] o1, Integer[] o2) {
      		Integer itemIdOne = o1[0];
				Integer itemIdTwo = o2[0];
				return itemIdOne.compareTo(itemIdTwo);
			}
		});
       
        
        List<Integer[]> result = new ArrayList<>();
        
            int i=1;
            
            result.add(temparr[0]);
        
            while(i<intervals.length)
            {
                Integer[] last= result.get(result.size()-1);
                
                Integer[] current = temparr[i];
                
                if(last[1] >= current[0] && last[1]<current[1]){
                    Integer[] temp = {last[0],current[1]};
                    result.remove(result.size()-1);
                    result.add(temp);
                }
                else if(last[1] >= current[0] && last[1]>= current[1])
                {
                	i++;
                	continue;
                	
                }
                else
                    result.add(current);
                i++;
            }
        
        int[][] finalresult = new int[result.size()][2];
        
        for(int i1=0;i1<result.size();i1++){
        	finalresult[i1][0]= result.get(i1)[0];
        	finalresult[i1][1]= result.get(i1)[1];
        }
        
        return finalresult;
    }
}
	


