/*Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
		*/

package Array_InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import linklists.FindKthNodeFromEndList;

/*Sorting all numbers in descending order is the simplest solution that occurs to us. But this doesn’t work.

For example, 548 is greater than 60, but in the output, 60 comes before 548. As a second example, 98 is greater than 9, but 9 comes before 98 in the output.

The solution is to use any comparison based sorting algorithm. Thus, instead of using the default comparison, write a comparison function myCompare() and use it to sort numbers.

Given two numbers X and Y, how should myCompare() decide which number to put first – we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y).

If XY is larger, then, in the output, X should come before Y, else Y should come before X.

For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542. Since 60542 is greater than 54260, we put Y first.*/

public class LargestNumber {

	public static void main(String[] args) {

		int[] arr = {0,3, 30, 34, 5, 9,0,0,0};
		
		LargestNumber ln = new LargestNumber();
		System.out.println(" Result String of  "+ ln.findLargestNumber(arr));
		
		
	}

	public String findLargestNumber(int[] arr) {

		List<Node> list = new ArrayList<Node>();

		for (int i : arr) {		
			Node n = new Node(i);
			list.add(n);
		}
		
		Collections.sort(list);
		
		StringBuffer sf = new StringBuffer();
		
		for (Node node : list) {
			   if (node.n =="0" && sf.length() != 0)
		            continue;
			sf.append(node.n);
			
		}
		
		return sf.toString();
		
	}

	class Node implements Comparable<Node> {
		String n;

		public Node(int n) {

			this.n = Integer.toString(n);

		}

		@Override
		public int compareTo(Node arg0) {
			String XY = arg0.n + this.n;
			String YX = this.n + arg0.n;
				
			return XY.compareTo(YX);
		}

	

	}

}
