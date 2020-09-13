package Amazon;

import java.util.List;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Test1 {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {

		// Check if codelist is null
		if (codeList == null || codeList.size() == 0)
			return 1;

		if (shoppingCart == null || shoppingCart.size() == 0)
			return 0;

		int i = 0, j = 0;

		for (int k = 0; k < shoppingCart.size(); k++) {

			if (codeList.get(i).get(j).equals(shoppingCart.get(k)) || codeList.get(i).get(j).equals("anything")) {
				j++;

				if (j == codeList.get(i).size()) {
					i++;
					j = 0;
				}

				if (i == codeList.size())
					return 1;
			} else {
				j = 0;
			}
		}
		return 0;

	}

	PairInt IDsOfmovies(int flightDuration, int numMovies, ArrayList<Integer> movieDuration) {

		int[] ans = new int[2];

		int target = flightDuration - 30;
		if (target <= 0)
			return new PairInt(0, 0);

//use a dynamic array list
		List<PairInt> sorted = new ArrayList<>();
		for (int i = 0; i < numMovies; i++) {
			sorted.add(new PairInt(i, movieDuration.get(i)));
		}

		Collections.sort(sorted, (i, j) -> (i.second - j.second));

		int closestSum = 0;

//two pointers
		int left = 0, right = numMovies - 1;

		while (left < right) {

			PairInt leftPair = sorted.get(left);
			PairInt rightPair = sorted.get(right);

			int sum = leftPair.second + rightPair.second;
			if (sum > target) {
				right--;
			} else {
// found duplicates
				if (sum == closestSum) {
					int currentLongestMovie = movieDuration.get(ans[1]);
					if (rightPair.second > currentLongestMovie) {
						// found longer movie
						ans[0] = leftPair.first;
						ans[1] = rightPair.first;
					}
				} else if (sum > closestSum) {
					closestSum = sum;
					ans[0] = leftPair.first;
					ans[1] = rightPair.first;
				}
				left++;
			}
		}
		return new PairInt(ans[0], ans[1]);

	}
	
	class PairInt{
		int first,second;
		public PairInt() {
			// TODO Auto-generated constructor stub
		}
		PairInt(int first, int second){
			
			this.first=first;
			this.second=second;
			
		}
	}
	
}