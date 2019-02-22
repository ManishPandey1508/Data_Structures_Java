package DynamicProgramming;

import java.util.Arrays;

public class Candy {

	public static void main(String[] args) {
		int[] candy = { 1,2,87,87,87,2,1 };
		System.out.println("Total Candies " + candy(candy));
		System.out.println("Total Candies " + candyLinear(candy));

	}

	// O(n^2)
	public static int candy(int[] ratings) {

		if (ratings == null || ratings.length == 0)
			return 0;
		int n = ratings.length;
		int totalCandies = 0;
		int[] candies = new int[n];
		Arrays.fill(candies, 1);

		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < n; i++) {

				if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
					candies[i] = candies[i - 1] + 1;
					flag = true;
				}

				if (i != n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
					candies[i] = candies[i + 1] + 1;
					flag = true;
				}
			}
		}

		for (int candy : candies) {

			totalCandies += candy;

		}

		return totalCandies;
	}

	public static int candyLinear(int[] ratings) {

		if (ratings == null || ratings.length == 0)
			return 0;
		int n = ratings.length;
		int sum = 0;

		int[] leftToRight = new int[n];
		int[] rightToLeft = new int[n];

		Arrays.fill(leftToRight, 1);
		Arrays.fill(rightToLeft, 1);

		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {

				leftToRight[i] = leftToRight[i - 1] + 1;

			}

		}

		for (int i = n-2; i >= 0; i--) {
			if (ratings[i] > ratings[i+1]) {

				rightToLeft[i] = rightToLeft[i + 1] + 1;

			}

		}

		for (int i = 0; i < n; i++) {

			sum += Math.max(leftToRight[i], rightToLeft[i]);

		}

		return sum;
	}

}
