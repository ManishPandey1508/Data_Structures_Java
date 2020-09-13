
public class DataBricks {

	public static void main(String[] args) {
	
		
		System.out.println(sum(52134));
	}
	  public static int reverse(int n) 
	    { 
	        int rev = 0; 
	        while (n != 0) { 
	            rev = (rev * 10) + (n % 10); 
	            n /= 10; 
	        } 
	        return rev; 
	    } 
	  
	    // Function to find the sum of the odd 
	    // and even positioned digits in a number 
	    public  static int sum(int n) 
	    { 
	        n = reverse(n); 
	        int sumOdd = 0, sumEven = 0, c = 1; 
	  
	        while (n != 0) { 
	  
	            // If c is even number then it means 
	            // digit extracted is at even place 
	            if (c % 2 == 0) 
	                sumEven += n % 10; 
	            else
	                sumOdd += n % 10; 
	            n /= 10; 
	            c++; 
	        } 
	  
	        System.out.println("Sum odd = " + sumOdd); 
	        System.out.println("Sum even = " + sumEven); 
	        
	       return sumOdd - sumEven;
	        
	       
	    } 
	
}
