package DynamicProgramming;

import java.util.Arrays;

public class BuySellStockAllPossibleQuestions {

	public static void main(String[] args) {

		// Simple with k ==1
		int[] stocks = { 7, 1, 5, 3, 6, 4 };
		int res = buysellStockSimple(stocks);
		System.out.println("Result atmost 1 transaction       " + res);

		int res2 = buysellStockUnlimitedTransactions(stocks);
		System.out.println("Result with unlimited Transactions " + res2);

		int[] newStocks = { 1, 3, 2, 4, 6, 9 };
		int res3 = buysellStockMax2Transaction(newStocks);
		System.out.println("Result with max Transactions " + res3);

		int[] ArbStocks = { 3, 2, 6, 5, 0, 3 };
		int res4 = buysellStockAribitary(ArbStocks, 2);
		System.out.println("Result with Arbitrary Transactions " + res4);
		
		int[] ccoldownStocks = {1, 2, 3, 0, 2};
		int res5 = buySellStockWithCoolingPeriod(ccoldownStocks);
		System.out.println("Result with Cooldown Period of 1  " + res5);
		
		
		
		int[] feeStocks = {1, 3, 2, 8, 4, 9};
		int res6 = buySellStockWithTransactionFee(feeStocks, 2);
		System.out.println("Result with Transaction fee of 2   :- " + res6);
		

	}
	// T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1]+ price[i]); Profit at i level
	// with K transaction and 0 stock
	// T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0]-price[i]) Profit at i level
	// with
	// K transaction and 1 stock in second argument K-1 because if you have consumed
	// 1 transaction in buy

	// Base cases T[-1][k][0] = T[i][0][0] = 0 (No transaction or no stock yield no
	// profit)
	// T[-1][k][1] = T[i][0][1] = - Integer.MaxInt

	// Basic buy Sell question with just one transaction/ Per day allowed

	static int buysellStockSimple(int[] stocks) {

		int ti10 = 0;
		int ti11 = Integer.MIN_VALUE;

		for (int i = 0; i < stocks.length; i++) {

			ti10 = Math.max(ti10, ti11 + stocks[i]);
			ti11 = Math.max(ti11, -stocks[i]);// T[i-1][0][0] will always be zero because that is base case..
			// also the max profit you can make is either by "Rest" or buy, buying means
			// negative
		}

		return ti10;
	}
	// T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1]+ price[i]); Profit at i level
	// with K transaction and 0 stock
	// T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0]-price[i]) Profit at i level
	// Base cases T[-1][k][0] = T[i][0][0] = 0 (No transaction or no stock yield no
	// profit)
	// T[-1][k][1] = T[i][0][1] = - Integer.MaxInt

	// you can do as many transactions as you wish, but not at the same time..means
	// buy before you can sell
	// K can be anything

	static int buysellStockUnlimitedTransactions(int[] stocks) {

		int t_iko = 0, t_ik1 = Integer.MIN_VALUE;

		for (int stock : stocks) {
			int t_iko_Old = t_iko;
			t_iko = Math.max(t_iko, t_ik1 + stock);

			// If 'k' can be anything thn we can assume k== k-1--> T[i-1][k-1][0] ==
			// T[i-1][k][0]

			t_ik1 = Math.max(t_ik1, t_iko_Old - stock);

			
		}

		return t_iko;

	}

	// K =2
	// Four variables need to be tracked 2 for k =2
	// and two for k = 1
	static int buysellStockMax2Transaction(int[] stocks) {

		int t_i10 = 0, t_i20 = 0;
		int t_i11 = Integer.MIN_VALUE, t_i21 = Integer.MIN_VALUE;

		for (int stock : stocks) {

			t_i20 = Math.max(t_i20, t_i21 + stock);
			t_i21 = Math.max(t_i21, t_i10 - stock);

			t_i10 = Math.max(t_i10, t_i11 + stock);
			t_i11 = Math.max(t_i11, -stock);
		}

		return t_i20;
	}

	// K is arbitrary
	// two possible ranges of 'k', if k is more thn n/2, k's value is insignificant,
	// solution will have the same logic as if k is infinite big
	// if k is less thn n/2 thn we have to look profit for all possible values of k.

	// T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1]+ price[i]); Profit at i level
	// with K transaction and 0 stock
	// T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0]-price[i]) Profit at i level

	static int buysellStockAribitary(int[] stocks, int k) {

		int n = stocks.length;
		if (k >= (n / 2)) {

			int t_10 = 0;
			int t_11 = Integer.MIN_VALUE;

			for (int stock : stocks) {
				int t_10old = t_10;
				t_10 = Math.max(t_10, t_11 + stock);
				t_11 = Math.max(t_11, t_10old - stock);

			}
			return t_10;

		} else {

			int[] t_10k = new int[k + 1];
			int[] t_11k = new int[k + 1];

			Arrays.fill(t_11k, Integer.MIN_VALUE);

			for (int stock : stocks) {
				for (int i = k; i > 0; i--) {
					t_10k[i] = Math.max(t_10k[i], t_11k[i] + stock);
					t_11k[i] = Math.max(t_11k[i], t_10k[i - 1] - stock);
				}

			}

			return t_10k[k];

		}

	}

	// case 5
	// Indefinate Tranaction but Cooldown period of 1
	// T[i][k][0] = Math.max(T[i-1][k][0], T[i-1][k][1]+stock[i])
	// T[i][k][1] = Math.max(T[i-1][k][1], T[i-1][k-1][0] - stock[i])

	static int buySellStockWithCoolingPeriod(int[] stocks) {

		int t_ik0 = 0, pre_tik0 = 0, t_ik1 = Integer.MIN_VALUE;

		for (int stock : stocks) {
			int old_tik0 = t_ik0;
			t_ik0 = Math.max(t_ik0, t_ik1 + stock);
			t_ik1 = Math.max(t_ik1, pre_tik0 - stock);
			pre_tik0 = old_tik0;
		}
		return t_ik0;

	}
	
	
	// case 5
	// Indefinate Tranaction but with Transactions Fee
	// You can apply transaction fww either at Selling or Buying
	
	// T[i][k][0] = Math.max(T[i-1][k][0], T[i-1][k][1]+stock[i])
	// T[i][k][1] = Math.max(T[i-1][k][1], T[i-1][k-1][0] - stock[i])

	static int buySellStockWithTransactionFee(int[] stocks, int fee) {

		int t_ik0 = 0, old_tik0 = 0, t_ik1 = Integer.MIN_VALUE;

		for (int stock : stocks) {
			old_tik0 = t_ik0;
			t_ik0 = Math.max(t_ik0, t_ik1 + stock);
			t_ik1 = Math.max(t_ik1, old_tik0 - stock - fee);
			
		}
		return t_ik0;

	}
	
	
	
	
	

}
