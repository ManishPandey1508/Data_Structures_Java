package linklists;

public class ReverseEveryKElements {

  public static ListNode reverse(ListNode head, int k) {
	  
	  ListNode result = new ListNode(-1);
	  result.next = head;
	  
	 ListNode  prev = result;
	 ListNode  curr = head;
	
	
	 boolean isReverse = true;
	  
	 while(curr!=null) {
		 int index = 0;
		 ListNode tail = curr;
		 while(curr!=null && index < k ) {
			 curr = curr.next;
			 index++; 
		 }
		 if(index ==k) {
			 if(isReverse) {
				 prev.next = reverseSimple(tail,k);
				 prev = tail;
				 isReverse = false;
			 }
			 else {	
				 while(tail!=curr) {
					 prev.next = tail;
					 prev =tail;
					 tail = tail.next;
				 }
				 
				 isReverse = true;
			 }
		 }
		else {
			 if(isReverse) {
				 prev.next = reverseSimple(tail,k);
			 }
			 else {
				 prev.next = tail;
			 }
			
		 }
		 
	 }
	 
	  
    return result.next;
  }

  
  public static ListNode reverseSimple(ListNode head , int k){
      ListNode prev = null;
      int i=0;
      while(head !=null && i < k ){
          ListNode temp = head.next;
          head.next = prev;
          prev = head;
          head = temp;
          i++;
      }
      return prev;
  }
  
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseEveryKElements.reverse(head, 2);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }
}