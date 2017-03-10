package linklists;

//Java program to delete a node from doubly linked list

// code is still not working need to fix it properly

class SplitCircularList {

 static Node head, head1, head2;

 static class Node {

     int data;
     Node next, prev;

     Node(int d) {
         data = d;
         next = prev = null;
     }
 }

 /* Function to split a list (starting with head) into two lists.
  head1_ref and head2_ref are references to head nodes of 
  the two resultant linked lists */
 void splitList() {

	 Node slow_Pointer = head, fast_Pointer = head;
     /* If there are odd nodes in the circular list then
      fast_ptr->next becomes head and for even nodes 
      fast_ptr->next->next becomes head */
	 if(head==null){
		 return;
	 }
	 while(fast_Pointer.next!=head || fast_Pointer.next.next!=head){
		 fast_Pointer = fast_Pointer.next.next;
		 slow_Pointer = slow_Pointer.next;	 
	 }

     /* If there are even elements in list then move fast_ptr */
   if(fast_Pointer.next.next==head){
	   fast_Pointer= fast_Pointer.next;
   }
	 
     /* Set the head pointer of first half */
  
	   head1 = head;
   
     /* Set the head pointer of second half */
   
	   if(head.next!=head){
	   head2 = slow_Pointer.next;
	   }
     /* Make second half circular */

   fast_Pointer.next= slow_Pointer.next;
   
     /* Make first half circular */

   	slow_Pointer.next = head;
 }

 /* Function to print nodes in a given singly linked list */

 public void printList(Node headNode) {
		Node temp = headNode.next;
		while (temp !=headNode ) {
			System.out.format("%d ", temp.data);
			System.out.println("-->>");
			temp = temp.next;
		}
		System.out.println();
	}
 
/* void printList(Node node) {
     Node temp = node;
     if (node != null) {
         do {
             System.out.print(temp.data + "--> ");
             temp = temp.next;
         } while (temp != node);
     }
 }*/

 public static void main(String[] args) {
     SplitCircularList list = new SplitCircularList();

     //Created linked list will be 12->56->2->11
     list.head = new Node(12);
     list.head.next = new Node(56);
     list.head.next.next = new Node(2);
     list.head.next.next.next = new Node(11);
     list.head.next.next.next.next = list.head;

     System.out.println("Original Circular Linked list ");
     list.printList(head);

     // Split the list
     list.splitList();
     System.out.println("");
     System.out.println("First Circular List ");
     list.printList(head1);
     System.out.println("");
     System.out.println("Second Circular List ");
     list.printList(head2);
      
 }
}

