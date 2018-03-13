
package DynamicProgramming;

public class BuyAndSellStockDP {

	public static void main(String[] args) {
		
		int[] stock = {7,1,5,3,6,4};
		int result = maxprofit(stock);
		System.out.println("Result  "+ result);
	}

	static int maxprofit(int[] stocks) {

		// Start min and profit 
		int min = stocks[0];
		int profit = 0;

		for (int i = 0; i < stocks.length; i++) {
			// Check if this is current min	
			if (stocks[i] < min) {
				min = stocks[i];
			} else {
			// 
				profit = Math.max(stocks[i] - min, profit);
			}

		}
		return profit;

	}

}
