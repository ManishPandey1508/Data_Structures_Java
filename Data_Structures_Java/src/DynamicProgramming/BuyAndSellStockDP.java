/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.*/

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
