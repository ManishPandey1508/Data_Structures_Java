package Math;

//https://www.geeksforgeeks.org/sieve-of-eratosthenes/

public class FindAllPrime {

	public static void main(String[] args) {
		int n = 499979;
		
		System.out.println("Total prime till "+ n +" : "+ countPrimes(n));
	}
	
	
	public static int countPrimes(int n) {

		if (n <= 1)
			return 0;
		int count = 0;
		boolean[] primeStore = new boolean[n];

		for (int i = 2; i < n; i++) {
			if (primeStore[i] == false) {
				count++;
				primeStore[i]=true;		
				for (int p = 2; p * i < n; p++) {
					primeStore[p * i] = true;
				}

			}

		}
		return count;
	}
}
