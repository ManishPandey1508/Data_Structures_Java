package Math;

public class Pow {

	public double myPow(double x, int n) {

		long n_long = n;
		return pow(x, n_long);

	}

	public double pow(double x, long n) {

		if (x == 0)
			return 0;
		if (x == 1)
			return 1;
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}

		return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);

	}

}
