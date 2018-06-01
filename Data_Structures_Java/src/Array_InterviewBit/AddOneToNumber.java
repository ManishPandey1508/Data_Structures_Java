/*Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.*/
package Array_InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class AddOneToNumber {

	public static List<Integer> addOneToNumber(List<Integer> nums) {

		int i = 0;
		// 	Remove front zeroes
		while (i <nums.size() -1 && nums.get(i) == 0) {
			nums.remove(i);
		}

		int carry = 1;

		for (int j = nums.size()-1; j >=0; j--) {

			int num = nums.get(j) + carry;
			if (num > 9) {
				nums.set(j, num % 10);
				carry = num / 10;
			} else {
				nums.set(j, num);
				carry = 0;
			}

		}
		// check if any carry left like in number 99999 
		if(carry!=0) {
			nums.add(0, carry);
		}
		
		return nums;
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		
		System.out.println(addOneToNumber(list));
		
	}

}
