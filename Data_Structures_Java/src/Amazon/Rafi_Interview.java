package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Amazon.KClosestDistance.steak_with_d;

public class Rafi_Interview {

	class crate_With_d {
		int x;
		int y;
		int d;
		public crate_With_d(int x,int y) {
			
			this.x = x;
			this.y =y;
			this.d= x*x+y*y;
		
		}
		
	}
	
	
	List<List<Integer>> closestLocation(int totalCrates,List<List<Integer>> allLocations,int truckCapacity){
		if(totalCrates == truckCapacity)
			return allLocations;
		PriorityQueue<crate_With_d> heap = new PriorityQueue<>(new Comparator<crate_With_d>() {

			@Override
			public int compare(crate_With_d o1, crate_With_d o2) {
				// TODO Auto-generated method stub
				return o2.d -o1.d;
			}
		});
		
		for(List<Integer> crateLocation: allLocations) {
			
			int x =crateLocation.get(0);
			int y = crateLocation.get(1);
			crate_With_d temp = new crate_With_d(x, y);
			
			heap.add(temp);
			
			if(heap.size()>truckCapacity)
			{
				heap.poll();
				
			}
			
			
			
		}
		
		List<List<Integer>> result = new ArrayList<>();
		
		while(!heap.isEmpty()) {
			
			List<Integer> tempList = new ArrayList<>();
			crate_With_d tempSteak = heap.remove();
			tempList.add(tempSteak.x);
			tempList.add(tempSteak.y);
			result.add(tempList);
			
		}
		
		return result;
		
	}
	
Pair findOptimalWeights(int numOfContainers, double maxCapacity, List<Double> containersWt) {
	
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
			else if(sum < maxCapacity) {
				diff = Math.min(diff, Math.abs(containersWt.get(low)+containersWt.get(high)));
				pair = new Pair(containersWt.get(low),containersWt.get(high));
				low++;
			}
		}

	return pair;
}

class diff{
	double key;
	double diff;
	
	public diff(double key, double diff) {
		this.key = key;
		this.diff = diff;
	}
}

	
	class Pair{
		double first;
		double second;
		public Pair(double first, double second) {
			this.first =first;
			this.second= second;
		}
	}
	
	
	
}
