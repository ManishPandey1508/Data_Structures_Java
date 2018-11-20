package Amazon;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestDistance {

	
	
	public static void main(String[] args) {
	
		KClosestDistance kd = new KClosestDistance();
		List<List<Integer>> steaks = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		temp.add(2);
		steaks.add(temp);
		
		List<Integer> temp1 = new ArrayList<Integer>();
		temp1.add(3);
		temp1.add(4);
		steaks.add(temp1);
		
		List<Integer> temp2 = new ArrayList<Integer>();
		temp2.add(1);
		temp2.add(-1);
		steaks.add(temp2);
		
		List<List<Integer>> result = kd.nearestKSteakHouse(3, steaks, 2);
	System.out.println(result.toArray());
		
	}
	
	class steak_with_d {
		int x;
		int y;
		int d;
		public steak_with_d(int x,int y) {
			
			this.x = x;
			this.y =y;
			this.d= x*x+y*y;
		
		}
		
	}
	
	public List<List<Integer>> nearestKSteakHouse(int totalSteakHouse,List<List<Integer>>  steaks, int noOfSteakHouse){
		
		if(totalSteakHouse == noOfSteakHouse)
			return steaks;
		PriorityQueue<steak_with_d> heap = new PriorityQueue<>(new Comparator<steak_with_d>() {

			@Override
			public int compare(steak_with_d o1, steak_with_d o2) {
				// TODO Auto-generated method stub
				return o2.d -o1.d;
			}
		});
		
		for(List<Integer> steakhouse: steaks) {
			
			int x =steakhouse.get(0);
			int y = steakhouse.get(1);
			steak_with_d temp = new steak_with_d(x, y);
			heap.add(temp);
			if(heap.size()>noOfSteakHouse)
			{
				heap.poll();
				
			}
			
			
			
		}
		
		List<List<Integer>> result = new ArrayList<>();
		
		while(!heap.isEmpty()) {
			
			List<Integer> tempList = new ArrayList<>();
			steak_with_d tempSteak = heap.remove();
			tempList.add(tempSteak.x);
			tempList.add(tempSteak.y);
			result.add(tempList);
			
		}
		
		return result;
		
	}
	
	
}
