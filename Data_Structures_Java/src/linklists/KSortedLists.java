package linklists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// With Lists
	public ListNode mergeKSortedLists(ListNode[] lists) {

		if (lists == null || lists.length == 0)
			return null;

		ListNode result = new ListNode(-1);
		ListNode current = result;
		int k = lists.length;

		// Make Priority Queue

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});

		for (ListNode list : lists) {
			if (list != null)
				pq.offer(list);
		}

		while (!pq.isEmpty()) {

			current.next = pq.remove();
			current = current.next;

			if (current.next != null)
				pq.offer(current.next);

		}

		return result.next;

	}
	// With Arrays



}
