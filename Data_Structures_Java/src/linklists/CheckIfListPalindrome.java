package linklists;

// We can also do it by using one stack

/*METHOD 2 (By reversing the list)
This method takes O(n) time and O(1) extra space.
1) Get the middle of the linked list.
2) Reverse the second half of the linked list.
3) Check if the first half and second half are identical.
4) Construct the original linked list by reversing the second half again and attaching it back to the first half
*/
public class CheckIfListPalindrome {

	Node head, slow_pointer, fast_pointer, secondHalf;

	class Node {
		char data;
		Node next;

		Node(char d) {
			data = d;
			next = null;
		}

	}

	boolean isPalindrome(Node head) {

		Node midNode = null;
		slow_pointer = head;
		fast_pointer = head;
		Node prevOfSlowPointer = head;
		boolean result = false;

		while (fast_pointer != null && fast_pointer.next != null) {

			prevOfSlowPointer = slow_pointer;
			slow_pointer = slow_pointer.next;
			fast_pointer = fast_pointer.next.next;
		}

		if (fast_pointer != null) {
			midNode = slow_pointer;
			slow_pointer = slow_pointer.next;
		}

		secondHalf = slow_pointer;
		prevOfSlowPointer.next = null;

		reverse();
		result = compareLists(head, secondHalf);
		reverse();

		if (midNode != null) {
			prevOfSlowPointer.next = midNode;
			midNode.next = secondHalf;
		} else {
			prevOfSlowPointer.next = secondHalf;
		}

		return result;
	}

	void reverse() {
		Node prev = null;
		Node current = secondHalf;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		secondHalf = prev;
	}

	boolean compareLists(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null && temp2 != null) {

			if (temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else {
				return false;
			}

		}
		if (temp1 == null && temp2 == null) {
			return true;
		}
		return false;
	}

	/*
	 * Push a node to linked list. Note that this function changes the head
	 */
	public void push(char new_data) {
		/*
		 * Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* link the old list off the new one */
		new_node.next = head;

		/* Move the head to point to new Node */
		head = new_node;
	}

	// A utility function to print a given linked list
	void printList(Node ptr) {
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.println("NULL");
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {

		/* Start with the empty list */
		CheckIfListPalindrome llist = new CheckIfListPalindrome();

		char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' ,'d'};
		String string = new String(str);
		for (int i = 0; i < str.length; i++) {
			llist.push(str[i]);
			llist.printList(llist.head);
			}
		if (llist.isPalindrome(llist.head) != false) {
			System.out.println("Is Palindrome");
			System.out.println("");
		} else {
			System.out.println("Not Palindrome");
			System.out.println("");
		}
	}
}
