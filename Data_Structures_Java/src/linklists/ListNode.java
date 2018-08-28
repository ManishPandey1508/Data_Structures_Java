package linklists;

public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static void printList(ListNode root) {
		
		while(root!=null) {
			if(root.next ==null) {
				System.out.print(root.val+" ");
			}
			else
			System.out.print(root.val+" --> ");
			root = root.next;
		}
		
		
	}
	
}
