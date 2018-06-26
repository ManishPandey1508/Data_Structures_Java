package Array_InterviewBit;

public class RotateArray90Degree {

	public static int[][] rotatearray(int[][] arr) {

		int n = arr.length;

		for (int i = 0; i < arr.length / 2; i++) {

			for (int j = i; j < n - i - 1; j++) {

				int temp = arr[i][j];

				arr[i][j] = arr[n - 1 - j][i];
				arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
				arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
				arr[j][n-1-i] = temp;
			}

		}

		return arr;

	}

	public static void main(String[] args) {
		
	int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
	
	int[][] result = rotatearray(arr);
	
	for (int[] is : result) {
		System.out.println("-----");
		for (int i : is) {
			System.out.println(i+",");
		}
	}
	
	

	}

}
