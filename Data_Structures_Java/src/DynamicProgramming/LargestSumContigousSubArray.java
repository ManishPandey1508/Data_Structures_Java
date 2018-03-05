package DynamicProgramming;

public class LargestSumContigousSubArray {

	static int ContigousSumArray(int[] arr) {

		int maxSoFar = 0;
		int maxCurrent = 0;
//{-2,-3,4, -1,-2,1,5,3}
		for (int i = 0; i < arr.length; i++) {

			maxCurrent = maxCurrent + arr[i];
			if (maxCurrent < 0)
				maxCurrent = 0;

			if (maxCurrent > maxSoFar)
				maxSoFar = maxCurrent;

		}
		return maxSoFar;
	}

	public static void main(String[] args) {

		int[] arr ={-2,-3,4, -1,-2,1,5,-3};
		System.out.println("Result " + ContigousSumArray(arr));
		
	}

}
