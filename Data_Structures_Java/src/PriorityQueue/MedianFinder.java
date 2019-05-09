package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.*/

public class MedianFinder {

	/** initialize your data structure here. */
	
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	
	public MedianFinder()
	{
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	}

	public void addNum(int num) {
		
		minHeap.offer(num);
		maxHeap.offer(minHeap.poll());
		if(minHeap.size()<maxHeap.size())
			minHeap.offer(maxHeap.poll());
	}

	public double findMedian() {

		if(minHeap.size()==maxHeap.size())
			return (minHeap.peek()+maxHeap.peek()) / 2;
		else 
			return minHeap.size()>maxHeap.size()?minHeap.peek():maxHeap.peek(); 
		
		
	}

}
