package Math;

public class TrailingZeroes {

	public static void main(String[] args) {
		int n = 25;
		System.out.println("No Of 0 "+ trailingZeroes(n));
		
		
	}

	public static int trailingZeroes(int n) {

		if (n == 0)
			return 0;
		
		int noOF5 = 0;
		
		while (n >= 5) {			
			n = n/5;
			noOF5=noOF5+n;
		}

	return noOF5;
	}

}
