package Binary_Search;

public class Count_No_Occurances_Sorted {

	static int first=-1;
	static int last=-1;
	public static void main(String[] args) {
		
		int arr[] = {1, 1, 2, 2, 2, 2, 3,4,5,6,7,8,9,9,9,10,11,22,22,44};
		int x =9;
		System.out.println(occurances(arr, x));
	}
	
	
	public static int occurances(int[] arr, int x) {
		firstIndex(arr, x, 0, arr.length-1);
		lastIndex(arr, x, 0, arr.length-1);	
		
		return last -first+1;
	}
	
	public static void firstIndex(int[] arr,int x,int start,int end) {

		int mid = start + (end-start)/2;
		if(start>end)
			return;
		
		if(arr[mid]==x) {
			first = mid;
			firstIndex(arr, x, start, mid-1);
		}
		else if(arr[mid]>x)
		{
			firstIndex(arr, x, start, mid-1);
		}
		else {
			firstIndex(arr, x, mid+1, end);
		}
		
	}
	
	public static void lastIndex(int[] arr,int x,int start,int end) {

		int mid = start + (end-start)/2;
		if(start>end)
			return;
		
		if(arr[mid]==x) {
			last = mid;
			lastIndex(arr, x, mid+1, end);
		}
		else if(arr[mid]>x)
		{
			lastIndex(arr, x, start, mid-1);
		}
		else {
			lastIndex(arr, x, mid+1, end);
		}
		
	}
	
}
