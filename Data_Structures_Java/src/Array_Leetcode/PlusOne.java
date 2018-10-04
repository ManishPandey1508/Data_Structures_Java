package Array_Leetcode;

import java.util.ArrayList;

public class PlusOne {
	public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0) {
			return new int[] { 1 };
		}
		int carry = 1;
		ArrayList<Integer> myList = new ArrayList<>();
		for (int i = digits.length - 1; i >= 0; i--) {

			if (digits[i] == 9 && carry == 1) {
				myList.add(0, 0);
				carry = 1;
			} else {
				myList.add(0, digits[i] + carry);
				carry = 0;
			}

		}
		if (carry == 1)
			myList.add(0, 1);

		int[] arr = new int[myList.size()];

		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i) != null) {
				arr[i] = myList.get(i);
			}
		}
		return arr;
	}
}
