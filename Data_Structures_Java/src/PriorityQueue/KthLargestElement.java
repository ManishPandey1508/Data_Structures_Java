package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,5,6,4};
		System.out.println("Answer "+ findKthLargest(nums, 2));
	}

	public static int findKthLargest(int[] nums, int k) {

		// create max pq of initial capacity of k
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

		for (int i = 0; i < nums.length; i++) {

			pq.offer(nums[i]);

		}
		for(int i=0;i<k-1;i++)
			pq.remove();
		return pq.remove();

	}

}
