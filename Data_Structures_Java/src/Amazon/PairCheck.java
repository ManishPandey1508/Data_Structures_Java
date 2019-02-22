package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Amazon.Rafi_Interview.Pair;

public class PairCheck {

	public static void main(String[] args) {
		
		List<Double> temp = new ArrayList<Double>();
		temp.add(1.0);
		temp.add(2.0);
		temp.add(3.0);
		temp.add(4.0);
		temp.add(5.0);
		temp.add(5.5);
		temp.add(4.4);
		temp.add(3.3);
		temp.add(2.2);
		temp.add(1.1);
		
		
		Pair p = findOptimalWeights(10, 10, temp );
		System.out.println("Pair "+ p.first+ ", "+ p.second);

	}

	static Pair findOptimalWeights(int numOfContainers, double maxCapacity, List<Double> containersWt) {
		
		double diff = Double.MAX_VALUE;

		Pair pair = null;
		Collections.sort(containersWt);
		
		int low = 0;
		int high = numOfContainers-1;
		
		
		while(low< high) {
			double sum = containersWt.get(low)+ containersWt.get(high);
			if(sum > maxCapacity ) {
				high--;
			}
			else if(sum <= maxCapacity) {
				diff = Math.min(diff, Math.abs(containersWt.get(low)+containersWt.get(high)));
				pair = new Pair(containersWt.get(low),containersWt.get(high));
				low++;
			}
			else {
				low++;
				high--;
			}
		}

	return pair;
}


	
	static class Pair{
		double first;
		double second;
		public Pair(double first, double second) {
			this.first =first;
			this.second= second;
		}
	}
	
	
	
}
