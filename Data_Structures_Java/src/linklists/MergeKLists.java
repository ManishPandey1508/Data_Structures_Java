package linklists;

import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {

		int k = lists.length;

		ListNode head = new ListNode(-1);

		ListNode current = head;
		head.next = current;

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {

			public int compare(ListNode w1, ListNode w2) {
				return Integer.compare(w1.val, w2.val);
			}
		});

		for (int i = 0; i < k; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}

		while (!pq.isEmpty()) {

			current.next = pq.remove();
			current = current.next;
			if (current.next != null)
				pq.add(current.next);

		}

		return head.next;
	}

}
