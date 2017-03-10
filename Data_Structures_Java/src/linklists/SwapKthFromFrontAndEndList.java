package linklists;

/*Swap Kth node from beginning with Kth node from end in a Linked List

The problem seems simple at first look, but it has many interesting cases.

Let X be the kth node from beginning and Y be the kth node from end. Following are the interesting cases that must be handled.
1) Y is next to X
2) X is next to Y
3) X and Y are same
4) X and Y don’t exist (k is more than number of nodes in linked list)
*/
public class SwapKthFromFrontAndEndList {
	
	Node head;
	
	class Node{
		int value;
		Node next;
		Node(int data){
			value= data;
			next=null;
		}
	}
	
	void printList(){
		Node temp;
		if(head==null)
			return;
		else{	
			System.out.println("");
			System.out.println(head.value);
			temp = head.next;
			
		}
		while(temp!=null){
			System.out.println("-->"+temp.value);
			temp=temp.next;
		}

	}
	
	int countListSize(Node head){
		int count=0;
		while(head!=null){
			count++;
			head = head.next;
		}
		return count;
	}
	
	 /* Utility function to insert a node at the beginning */
    void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
	
	void swapKthNode(int k){
		
		Node kthFrontNode,KthBackNode;
		
		// Take out the list legth
		int n=countListSize(head);
		
		// if k is more than list length swapping is not possible 
		if(k>n){
			System.out.println("Swapping is not possible because K is more then List Length");
		return ;
		}
		// if list has just one node swapping isnt possible
		if(n==1){
			return ;
		}
		// If kth Node from front and end are same 
		if(k==(2*n-1)){
			System.out.println("Kth node from front and end are same;");
			
		}
		
		Node x= head;
		Node x_prev=null;
		
		for (int i = 1; i <k; i++) {
		 x_prev=x;
		 x=x.next;
		}
		
		Node y= head;
		Node y_prev=null;
		
		for (int i = 1; i <(n-k+1); i++) {
		 y_prev=y;
		 y=y.next;
		}
		
		if(x_prev!=null){
			x_prev.next=y;
		}
		if(y_prev!=null){
			y_prev.next=x;
		}
		
		Node temp= x.next;
		x.next=y.next;
		y.next=temp;
	
		if(k==1){
			head=y;
		}
	if(k==n){
		head=x;
	}
	}
	

	public static void main(String[] args) {
		  SwapKthFromFrontAndEndList llist = new SwapKthFromFrontAndEndList();
	        for (int i = 8; i >= 1; i--)
	            llist.push(i);
	 
	        System.out.print("Original linked list: ");
	        llist.printList();
	        System.out.println("");
	 
	        for (int i = 1; i < 9; i++)
	        {
	            llist.swapKthNode(i);
	            System.out.println("Modified List for k = " + i);
	            llist.printList();
	            System.out.println("");
	        }
	    }

	}

