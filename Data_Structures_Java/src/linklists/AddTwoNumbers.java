package linklists;
//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Example:
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        

		int carry = 0;

		ListNode result = new ListNode(0);
		ListNode tempnode = result;
        ListNode nextNode = new ListNode(0);
		while (l1 != null && l2 != null) {
			
             nextNode = new ListNode(0);
			int temp = l1.val + l2.val + carry;
			if (temp <= 9) {
				nextNode.val = temp;
				carry = 0;
			} else if (temp == 10) {
				nextNode.val = 0;
				carry = 1;
			} else {
				nextNode.val = temp / 10;
				carry = temp % 10;
			}
			result.next = nextNode;
			result = nextNode;
			l1=l1.next;
			l2=l2.next;
		}
		while (l1 != null) {
			 nextNode= new ListNode(0);
			int temp = l1.val + carry;
			if (temp <= 9) {
				nextNode.val = temp;
				carry = 0;
			} else if (temp == 10) {
				nextNode.val = 0;
				carry = 1;
			} else {
				nextNode.val = temp / 10;
				carry = temp % 10;
			}
			result.next = nextNode;
			result = nextNode;
			l1=l1.next;
		}
		while (l2 != null) {
			 nextNode= new ListNode(0);
			int temp = l2.val + carry;
			if (temp <= 9) {
				nextNode.val = temp;
				carry = 0;
			} else if (temp == 10) {
				nextNode.val = 0;
				carry = 1;
			} else {
				nextNode.val = temp / 10;
				carry = temp % 10;
			}
			result.next = nextNode;
			result = nextNode;
			l2=l2.next;
		}
        if(carry!=0)
            nextNode.next = new ListNode(1);
		tempnode = tempnode.next;
        return tempnode;
	}

}
