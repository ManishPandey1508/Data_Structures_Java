package linklists;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomNumber {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {

		Map<RandomListNode, RandomListNode> map = new HashMap<>();

		RandomListNode iter = head;
		RandomListNode node = head;

		while (iter != null) {
			map.put(iter, new RandomListNode(iter.label));
			iter = iter.next;
		}

		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
		
	}

}
