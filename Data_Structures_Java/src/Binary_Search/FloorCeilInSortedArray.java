package Binary_Search;

public class FloorCeilInSortedArray {

	static int floor =-1;
	static int ceil = -1;
	public static void main(String[] args) {

		int[] arr = { 1, 3, 8, 10 };

		int num = 15;

		
		
		findFloor(arr, num, 0, arr.length - 1);

		
		System.out.println("Floor Of "+num+ " is " + floor);
		
		findCeil(arr, 5, 0, arr.length - 1);
		
		System.out.println("Ceil of  5 is " + ceil);

	}

	private static void findFloor(int[] arr, int target, int start, int end) {

		if (start > end)
			return ;

		int mid = start + (end - start) / 2;
		if (arr[mid] == target)
			 floor = arr[mid];
		else if (arr[mid] > target)
			 findFloor(arr, target, start, mid - 1);
		else {
			floor = arr[mid];
			  findFloor(arr, target, mid+1, end);
		}

	}
	
	private static void findCeil(int[] arr, int target, int start, int end) {

		if (start > end)
			return ;

		int mid = start + (end - start) / 2;
		if (arr[mid] == target)
			 ceil = arr[mid];
		else if (arr[mid] < target)
			findCeil(arr, target, mid+1, end);
		else {
				ceil = arr[mid];
				findCeil(arr, target, start, mid-1);
		}

	}
	

}
