package Array_Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

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
class MeetingsRoom2 {
    
    public class Interval{
        int startTime;
        int endTime;
        public Interval(int start,int end){
           startTime=start; 
            endTime=end;
        }    
    }
    
    
    public int minMeetingRooms(int[][] intervals) {
        
        //We will short intervals as per start time and , we will use Priority queue(As per end time) to store meeting interval 
        
        // Short the intervals as per  start time 
        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]));
        
        Interval[] intrvls = new Interval[intervals.length];
        
        // Convert Intevrals int Array to Intervals objects array
        
        for(int i=0;i<intervals.length;i++){
            intrvls[i] = new Interval(intervals[i][0],intervals[i][1]);
            System.out.println(" Interval at "+ i + " :  " + intrvls[i].startTime + " , " + intrvls[i].endTime );
        }
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.endTime == b.endTime)
                    return 0;
                else if(a.endTime>b.endTime)
                    return 1;
                else 
                    return -1;
            }
        });
        
        int meetingRoom =0;
        
        for(Interval i:intrvls){
         
            if(pq.isEmpty())
            {
                pq.add(i);
                meetingRoom++;
                
            }else{      
                Interval top = pq.peek();
                
                if(top.endTime > i.startTime)
                {
                    meetingRoom++;
                    pq.add(i);
                }
                else
                {
                 pq.poll();
                 pq.add(i);
                }
            }   
            
            
        }
        return meetingRoom;
        
    }
}