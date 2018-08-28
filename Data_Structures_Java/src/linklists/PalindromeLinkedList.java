package linklists;

import java.util.Stack;

public class PalindromeLinkedList {

	public static void main(String[] args) {

	}

	public static boolean isPalindromeWithoutStack(ListNode head) {
		 if(head==null || head.next==null) return true;
	        ListNode walker = head;
	        ListNode runner = head;
	        ListNode pre = null;
	        while(runner!=null && runner.next!=null) {
	            runner = runner.next.next; //move runner first, otherwise the next of the head will be already changed
	            //reverse linked list
	            ListNode nextWalker = walker.next;
	            walker.next = pre;
	            pre = walker;
	            walker = nextWalker;
	        }//after this the pre would be the head of our first half, while walker at the head of second half
	        if(runner != null) { // odd number length
	            walker = walker.next;    
	        }
	        while(pre!=null && walker!=null) {
	            if(pre.val != walker.val) return false;
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

}
