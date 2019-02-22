package Super30Problems;

//Implement the function fib(n), which returns the nth number in the Fibonacci sequence, using only O(1) space.

public class FibN {

	public static void main(String[] args) {

		int n = 5;
		
		System.out.println("Fib no of n ="+n+ " is : "+ fib(n));
	}

	public static int fib(int n) {

		int a =0;
		int b=1;
		int c=1;
		int i=2;
		while(i<=n) {
			c=a+b;
			a=b;
			b=c;
			
			i++;
			
		}
		
		return c;	
	}

}
