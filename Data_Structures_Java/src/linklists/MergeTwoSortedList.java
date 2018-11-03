package linklists;

public class MergeTwoSortedList {

	private Node head;

	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	// recursive(in space)
	public static Node MergeLists(Node headA, Node headB) {
		// This is a "method-only" submission.
		// You only need to complete this method
		if (headA == null) {
			return headB;
		}
		if (headB == null) {
			return headA;
		}
		if (headA.value < headB.value) {
			headA.next = MergeLists(headA.next, headB);

			return headA;
		} else {
			headB.next = MergeLists(headA, headB.next);
			return headB;
		}
	}

	
// Iterative (not in space)	
	 public Node mergeTwoLists(Node headA, Node headB) {
	      
	        if(headA==null && headB ==null)
	            return null;
	        if(headA ==null)
	            return headB;
	        if(headB ==null)
	        return headA;
	        
	        Node result = new Node(0);
	        Node prev= result;

	        while(headA !=null && headB!=null){
	            if(headA.value <= headB.value){
	                prev.next = headA;
	                headA = headA.next;
	            }
	            else{
	                prev.next= headB;
	                headB = headB.next;
	            }
	            prev=prev.next;
	            
	        }
	        if(headA!=null)
	            prev.next= headA;
	        
	        if(headB!=null)
	            prev.next= headB;
	        
	        return result.next;
	    }
	
	
	public static void main(String[] args) {
		MergeTwoSortedList list1 = new MergeTwoSortedList();
		// Creating a linked list
		Node head1 = new Node(5);
		list1.addToTheLast(head1);
		list1.addToTheLast(new Node(13));
		list1.addToTheLast(new Node(21));
		list1.addToTheLast(new Node(45));
		list1.addToTheLast(new Node(101));
		list1.addToTheLast(new Node(103));
		list1.addToTheLast(new Node(109));
		System.out.println("First Sorted List");
		list1.printList();

		MergeTwoSortedList list2 = new MergeTwoSortedList();
		// Creating a linked list
		Node head2 = new Node(12);
		list2.addToTheLast(head2);
		list2.addToTheLast(new Node(15));
		list2.addToTheLast(new Node(23));
		list2.addToTheLast(new Node(39));
		list2.addToTheLast(new Node(99));
		System.out.println("First Sorted List");
		list2.printList();

		// Finding 3rd node from end
		Node headNodeMergedList = MergeLists(head1, head2);
		while (headNodeMergedList.next != null) {
			System.out.println(headNodeMergedList.value);
			headNodeMergedList = headNodeMergedList.next;
		}

	}

}
