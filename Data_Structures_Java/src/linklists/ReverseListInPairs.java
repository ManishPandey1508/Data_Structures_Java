package linklists;



public class ReverseListInPairs{

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
   System.out.println("-->>");
   temp = temp.next;
  }
  System.out.println();
 }

 
 public static Node revrseListInPair(Node head) {
   
	if(head==null || head.next==null){
		return head;
	}
		
		Node temp= head.next;
		
		head.next=temp.next;	
		temp.next= head;
		
		head.next = revrseListInPair(head.next);
		
		
		return temp;
	
	 
}
 
 public static void main(String[] args) {
  ReverseListInPairs list1 = new ReverseListInPairs();
  // Creating a linked list
  Node head1=new Node(5);
  list1.addToTheLast(head1);
  list1.addToTheLast(new Node(13));
  list1.addToTheLast(new Node(21));
  list1.addToTheLast(new Node(45));
  list1.addToTheLast(new Node(101));
  list1.addToTheLast(new Node(103));
  list1.addToTheLast(new Node(109));
 System.out.println("First Sorted List");
  list1.printList();
    Node headNodeOfReversedList= revrseListInPair(head1);
    while(headNodeOfReversedList.next!=null){
    	System.out.println(headNodeOfReversedList.value+"-->>");
    	headNodeOfReversedList=headNodeOfReversedList.next;
    }
    

 }

}

