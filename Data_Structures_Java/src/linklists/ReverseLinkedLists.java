package linklists;

public class ReverseLinkedLists {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode.printList(head);
		
		head = reverseList(head);
		
		System.out.println("After Reversal");
		ListNode.printList(head);
		
	}

	public static ListNode reverseList(ListNode head) {

		if(head==null) {
			return null;
		}
		ListNode prev = null;
		
		while(head.next!=null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		
		head.next = prev;
		
		
		return head;
		
		
	}

}
