package Math;

public class ReverseInteger {

	public static void main(String[] args) {
		int a = -3125;
		
		
		System.out.println("Reverse Int is "+ reverse(a) );

	}

	//3125
	
	//5213
	
	public static int reverse(int x) {
	
		long result =0;
		boolean isNegative= false;
		if(x <0) {
			isNegative=true;
			x *= -1;
		}
			
		while(x >0) {	
		result = (result*10)+(x%10);
		if(result > Integer.MAX_VALUE) return 0;
		x = x/10;
		}
		
		return isNegative==true? (int)result *-1: (int) result;

	}

}
