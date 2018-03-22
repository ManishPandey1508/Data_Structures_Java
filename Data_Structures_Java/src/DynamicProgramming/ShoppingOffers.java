package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {

	public static void main(String[] args) {

		List<Integer> price = new ArrayList<>();
		price.add(2);
		price.add(5);

		List<Integer> needs = new ArrayList<>();
		needs.add(3);
		needs.add(2);

		List<List<Integer>> special = new ArrayList<List<Integer>>();

		List<Integer> special1 = new ArrayList<>();
		special1.add(3);
		special1.add(0);
		special1.add(5);

		List<Integer> special2 = new ArrayList<>();
		special2.add(1);
		special2.add(2);
		special2.add(10);

		special.add(special2);
		special.add(special1);
		int res = shoppingOffers(price, special, needs);
		System.out.println(" Minimal Total Cost is   " + res);

	}

	static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		// The idea if to find local mininmum, update the needs and call it recursively
		
		return helper(price, special, needs);
		
	}

	static int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

		int local_min = priceWithoutOffer(price, needs);

		for (int i = 0; i < special.size(); i++) {

			List<Integer> currentOffer = special.get(i);
			List<Integer> temp = new ArrayList<>();

			for (int j = 0; j < needs.size(); j++) {

				if (needs.get(j) < currentOffer.get(j)) {
					temp = null;
					break;
				}
				temp.add(needs.get(j) - currentOffer.get(j));
			}

			if (temp != null) {
				local_min= Math.min(local_min,
						currentOffer.get(currentOffer.size() - 1) + helper(price, special, temp));
			}

		}

		return local_min;
		
	}

	static int priceWithoutOffer(List<Integer> price, List<Integer> needs) {

		int sum = 0;
		for (int i = 0; i < needs.size(); i++) {

			sum += needs.get(i) * price.get(i);

		}

		return sum;
	}

}
