package Amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ForwardBackwardRoutes {

	
	public static void main(String[] args) {
		List<List<Integer>> forwardRouteList = new ArrayList<List<Integer>>();
		List<Integer> x = new ArrayList<Integer>();
		x.add(1);
		x.add(3000);

		List<Integer> x1 = new ArrayList<Integer>();
		x1.add(2);
		x1.add(5000);

		List<Integer> x2 = new ArrayList<Integer>();
		x2.add(3);
		x2.add(7000);
		List<Integer> x3 = new ArrayList<Integer>();
		x3.add(4);
		x3.add(10000);

		forwardRouteList.add(x);
		forwardRouteList.add(x1);
		forwardRouteList.add(x2);
		forwardRouteList.add(x3);

		List<List<Integer>> returnRouteList = new ArrayList<List<Integer>>();

		List<Integer> x4 = new ArrayList<Integer>();
		x4.add(1);
		x4.add(2000);

		List<Integer> x5 = new ArrayList<Integer>();
		x5.add(2);
		x5.add(3000);

		List<Integer> x6 = new ArrayList<Integer>();
		x6.add(3);
		x6.add(4000);
		
		List<Integer> x7 = new ArrayList<Integer>();
		x7.add(4);
		x7.add(5000);

		returnRouteList.add(x4);
		returnRouteList.add(x5);
		returnRouteList.add(x6);
		returnRouteList.add(x7);
		
		
		System.out.println( new ForwardBackwardRoutes().optimalUtilization(10000, forwardRouteList, returnRouteList));
		
		
	}
	
	List<List<Integer>> optimalUtilization(int maxUtilization, List<List<Integer>> forwardRoutes,
			List<List<Integer>> backwardRoutes) {

		List<List<Integer>> result = new ArrayList<>();

		if (forwardRoutes == null || forwardRoutes.size() == 0 || backwardRoutes == null || backwardRoutes.size() == 0)
			return result;

		PriorityQueue<OptimalAirComponent> maxheap = new PriorityQueue<OptimalAirComponent>(
				new Comparator<OptimalAirComponent>() {

					@Override
					public int compare(OptimalAirComponent o1, OptimalAirComponent o2) {
						// TODO Auto-generated method stub
						return o2.milesSum - o1.milesSum;
					}
				});

		for (List<Integer> forward : forwardRoutes) {
			for (List<Integer> backward : backwardRoutes) {
				int forwardId = forward.get(0);
				int backWardId = backward.get(0);

				int forwardMiles = forward.get(1);
				int backwardMiles = backward.get(1);

				if (forwardMiles + backwardMiles <= maxUtilization) {
					maxheap.add(new OptimalAirComponent(forwardId, backWardId, forwardMiles + backwardMiles));
				}

			}

		}

		int maxMilesCovered = maxheap.peek().milesSum;

		while (!maxheap.isEmpty() && maxheap.peek().milesSum == maxMilesCovered) {

			OptimalAirComponent temp = maxheap.remove();
			List<Integer> tempList = new ArrayList<>();
			tempList.add(temp.forwardrouteId);
			tempList.add(temp.returnRoutId);
			result.add(tempList);
		}

		return result;

	}

	class OptimalAirComponent {

		int forwardrouteId;
		int returnRoutId;
		int milesSum;

		public OptimalAirComponent(int forwardrouteId, int returnRoutId, int milesSum) {

			this.forwardrouteId = forwardrouteId;
			this.returnRoutId = returnRoutId;
			this.milesSum = milesSum;
		}

	}

}
