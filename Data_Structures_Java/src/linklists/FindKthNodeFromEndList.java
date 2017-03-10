package linklists;

public class FindKthNodeFromEndList {

	Node head;

	class Node {
		int value;
		Node next;

		Node(int data) {
			value = data;
			next = null;
		}
	}

	void printList() {
		Node temp;
		if (head == null)
			return;
		else {
			System.out.println("");
			System.out.println(head.value);
			temp = head.next;

		}
		while (temp != null) {
			System.out.println("-->" + temp.value);
			temp = temp.next;
		}

	}

	int countListSize(Node head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	/* Utility function to insert a node at the beginning */
	void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	 Node findKthNodeFromLast(int k) {

		Node temp = head;
		Node kthNode = null;
		int count=countListSize(head);
		if(k>count){
			return new Node(0);
		}
		if(count== k ){
			return head;
		}
		
		for (int i = 1; i < k; i++) {
			if (temp != null)
				temp = temp.next;
		}
		if(temp!=null)
		{
			kthNode=head;
			while(temp.next!=null){
				temp=temp.next;
				kthNode=kthNode.next;
			}
		}
		
		return kthNode;
	}

	public static void main(String[] args) {
		 FindKthNodeFromEndList llist = new FindKthNodeFromEndList();
	        for (int i = 8; i >= 1; i--)
	            llist.push(i);
	 
	        System.out.print("Original linked list: ");
	        llist.printList();
	        System.out.println("");
	        int k = 8;
	        Node resultNode =llist.findKthNodeFromLast(k);
	        
	        System.out.println(k+"  Node from the last is  -->"+ resultNode.value);
	 
	}

}
