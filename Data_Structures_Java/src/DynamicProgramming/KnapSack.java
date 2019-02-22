package DynamicProgramming;

// Value[]={60,100,120}

// Weigh[]t = {10,20,30}
//W=50
//Answer : 220

public class KnapSack {

	public int maxValue(int[] value, int[] weight, int w) {

		int result = 0;

		if (w == 0)
			return 0;

		if (value.length != weight.length)
			return 0;

		result = knapsackHelper(value, weight, w, 0);

		return result;
	}

	private int knapsackHelper(int[] value, int[] weight, int w, int i) {
		if (i >= weight.length)
			return 0;

		if (weight[i] > w)
			return 0;

		int includeCurrentWeight = value[i] + knapsackHelper(value, weight, w - weight[i], i + 1);
		int dontIncludeCurrentWeight = knapsackHelper(value, weight, w, i + 1);
		
		return Math.max(includeCurrentWeight, dontIncludeCurrentWeight);

	}

}
