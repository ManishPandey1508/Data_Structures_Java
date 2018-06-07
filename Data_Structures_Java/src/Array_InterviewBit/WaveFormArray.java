/*Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]*/
package Array_InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

public class WaveFormArray {

	public static ArrayList<Integer> wave(ArrayList<Integer> list) {
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i = i + 2) {
			int temp = list.get(i);
			list.set(i, list.get(i + 1));
			list.set(i + 1, temp);

		}
		return list;

	}

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
						list.add(45);
						list.add(55);
						list.add(95);
						list.add(15);
						list.add(65);
						list.add(05);
						list.add(02);
						
						System.out.println("Waver form List" + wave(list));
						
		
	}

}
