package linklists;

public class MiddleOfThelist{

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

 
 public static Node insertNodeInSortedList(Node head, Node newNode) {
	 
	 if(head == null){		
		 
		 return newNode;
	 }
	 Node current=head;
	 Node temp=null;
	 while(current.next!=null && current.value<newNode.value){
		 temp=current;
		 current= current.next;
	 }
 
	 temp.next=newNode;
	 newNode.next=current;
	 
	 return head;
}
 
 public static void main(String[] args) {
  MiddleOfThelist list1 = new MiddleOfThelist();
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
  
  
  // Finding 3rd node from end
  Node headNodeMergedList= insertNodeInSortedList(head1,new Node(23));
    while(headNodeMergedList.next!=null){
    	System.out.println(headNodeMergedList.value);
    	headNodeMergedList=headNodeMergedList.next;
    }
    

 }

}

