package linklists;

import java.util.Stack;

/*METHOD 2 (By reversing the list)
This method takes O(n) time and O(1) extra space.
1) Get the middle of the linked list.
2) Reverse the second half of the linked list.
3) Check if the first half and second half are identical.
4) Construct the original linked list by reversing the second half again and attaching it back to the first half
*/
public class PalindromeLinkedList {

	public static void main(String[] args) {

	}

	public static boolean isPalindromeWithoutStack(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode walker = head;
		ListNode runner = head;
		ListNode pre = null;
		while (runner != null && runner.next != null) {
			runner = runner.next.next; // move runner first, otherwise the next of the head will be already changed
			// reverse linked list
			ListNode nextWalker = walker.next;
			walker.next = pre;
			pre = walker;
			walker = nextWalker;
		} // after this the pre would be the head of our first half, while walker at the
			// head of second half
		if (runner != null) { // odd number length
			walker = walker.next;
		}
		while (pre != null && walker != null) {
			if (pre.val != walker.val)
				return false;
			pre = pre.next;
			walker = walker.next;
		}
		return true;

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		if (head.next == null)
			return true;
		ListNode fast = head;
		ListNode slow = head;

		Stack<Integer> stack = new Stack<>();

		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.val != stack.pop())
				return false;
			slow = slow.next;
		}

		return true;
	}

	public boolean isPalindromeReverse(ListNode head) {

		ListNode start = head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = null;
		while (fast.next != null || fast != null) {
			fast = fast.next.next;
			ListNode temp = slow.next;
			 slow.next=pre;
			pre = slow;
			slow = temp;
		}

		if(fast!=null)
			slow = slow.next;
		
		while (slow.next != null) {
			if (slow.val != pre.val)
				return false;
			else {
				slow = slow.next;
				pre = pre.next;
			}
		}
		return true;
	}

}
