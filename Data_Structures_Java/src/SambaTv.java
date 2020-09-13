import java.util.ArrayList;
import java.util.List;

public class SambaTv {

	public static void main(String[] args) {

		//int[] A = {1,6,6,3,0,5 };
		//int[] B = {6,2,0,0,4,0 };
		//int[] A = {0,2,2,3 };
		//int[] B = { 1,1,4,4 };
		int[] A = {0,1,1,1,1 };
		int[] B =  {1,2,3,4,5 };
		int result = solution(A, B);

		System.out.println("Result     " + result);
	}

	public static int solution(int[] A, int[] B) {

		List<Integer> list1 = new ArrayList<Integer>();
		for (int text : A) {
			list1.add(text);
		}
		System.out.println(list1);

		List<Integer> list2 = new ArrayList<Integer>();
		for (int text : B) {
			list2.add(text);
		}
		System.out.println(list2);

	
		int count = 0;
		for (int i = 0; i < B.length; i++) {
			if (list1.get(i) == 0) {
				
				 int temp = list2.get(i); list2.set(i, list1.get(i)); list1.set(i, temp);
				 
				count++;

			} else if (!list1.contains((list2.get(i))) && list2.get(i) !=0) {

				
				 int temp = list2.get(i); list2.set(i, list1.get(i)); list1.set(i, temp);
				 
				count++;

			}

		}

		return count;

	}
}
