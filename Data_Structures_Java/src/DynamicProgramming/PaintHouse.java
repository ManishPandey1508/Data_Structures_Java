package DynamicProgramming;


public class PaintHouse {

	public static void main(String[] args) {
		
		int[][] arr = {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println("Result "+ minCost(arr));
	}

	public static int minCost(int[][] costs) {

		if (costs.length == 0)
			return 0;

		int lastR = costs[0][0];
		int lastB = costs[0][1];
		int lastG = costs[0][2];

		for (int i=1;i<costs.length ;i++) {
			
			int currR = Math.min(lastG, lastB) + costs[i][0];
			int currB = Math.min(lastR, lastG) + costs[i][1];
			int currG = Math.min(lastR, lastB) + costs[i][2];

			lastB = currB;
			lastR = currR;
			lastG = currG;
		}

		return Math.min(Math.min(lastG, lastR), lastB);

	}
}
