/*Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.*/
package linklists;

public class IntersectionOfLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// One approach is to find length from both end and find the difference and ..
	// move longer end node for about the difference and then
	// find intersection node.

	/*
	 * I found most solutions here preprocess linkedlists to get the difference in
	 * len. Actually we don't care about the "value" of difference, we just want to
	 * make sure two pointers reach the intersection node at the same time.
	 * 
	 * We can use two iterations to do that. In the first iteration, we will reset
	 * the pointer of one linkedlist to the head of another linkedlist after it
	 * reaches the tail node. In the second iteration, we will move two pointers
	 * until they points to the same node. Our operations in first iteration will
	 * help us counteract the difference. So if two linkedlist intersects, the
	 * meeting point in second iteration must be the intersection point. If the two
	 * linked lists have no intersection at all, then the meeting pointer in second
	 * iteration must be the tail node of both lists, which is null
	 */

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		ListNode a = headA;
		ListNode b = headB;
		
		while(a!=b) {
			
			if(a==null) {
				a=headB;
			}else {
				a = a.next;
			}
			
			if(b==null) {
				b=headA;
			}else
				b=b.next;
		}
		
		return a;
		
	}

}
