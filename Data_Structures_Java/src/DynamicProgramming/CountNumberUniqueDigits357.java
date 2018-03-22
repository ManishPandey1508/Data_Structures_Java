package DynamicProgramming;

public class CountNumberUniqueDigits357 {

	public static void main(String[] args) {

		int res = countNumbersWithUniqueDigits(3);
		
		System.out.println("Result "+ res);
		
	}

	static int countNumbersWithUniqueDigits(int n) {

		if (n == 0)
			return 1;

		int count =9;
		int available = 9;
		int res =10;

		while (n-- > 1 && available > 0) {

			count =  count * (available--);
			res+= count;	
		}
		return res;
	}

}
