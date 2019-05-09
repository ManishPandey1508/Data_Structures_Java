import java.util.*;
import java.util.Map.Entry;

class Solution {
	static Map<Character, Integer> map = new HashMap<>();

	

	class LinkedListNode {
		int val;
		LinkedListNode next;
	}

	public static LinkedListNode distinct(LinkedListNode head) {

		LinkedListNode root = head;
		LinkedListNode pre = null;

		Set<Integer> values = new HashSet<>();

		while (root != null) {

			if (values.contains(root.val)) {

				LinkedListNode temp = root.next;
				pre.next = root.next;
				root = temp;

			} else {
				values.add(root.val);
				pre = root;
				root = root.next;

			}

		}

		return head;

	}

	
}
