import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Okta {

	public int[] solution(String[] customers, int numWindows, int queueSize) {
		// build windows Priority Queue
		PriorityQueue<Window> windows = new PriorityQueue<Window>();

		for (int i = 0; i < numWindows; i++) {
			windows.add(new Window(i));
		}

		// Build customer list out of customer array 
		List<Customer> customersList = new LinkedList<>();
		for (String c : customers) {
			String[] line = c.split(",");
			customersList.add(new Customer(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
		}

		// build customer queue
		List<Customer> queue = new LinkedList<>();

		int lastTime = -1;
		for (Customer customer : customersList) {
			assignWindowToCustomer(windows, lastTime, queue, customer.getArrtime());
			lastTime = customer.getArrtime();
			if (queue.size() < queueSize) {
				queue.add(customer);
			
			} else {
			
			}
		}

		// process the left people in queue
		assignWindowToCustomer(windows, lastTime, queue, Integer.MAX_VALUE);

		int[] ret = new int[numWindows + 1];
		int sum = 0;
		for (Window window : windows) {
			ret[window.getWindowIndex() + 1] = window.getServedPeople();
			sum += window.getServedPeople();
		}
		ret[0] = sum;
		return ret;
		
	}

	
	private void assignWindowToCustomer(PriorityQueue<Window> windows, int leastTime, List<Customer> queue, int time) {
		
		Iterator<Customer> iter = queue.iterator();
		while (windows.peek().getAvaTime() <= time) {
			if (!iter.hasNext()) {
				break;
			}
			Customer customer = iter.next();
			//
			if (customer.getArrtime() + customer.getTolTime() >= windows.peek().getAvaTime()) {
				Window window = windows.poll();
				
				int startTime = leastTime;
				if (window.getAvaTime() > startTime) {
					startTime = window.getAvaTime();
				}
				window.serve(customer, startTime);
				windows.add(window);
			} else {
				//Do Nothing 
			}

			iter.remove();
		}
	
		queue.removeIf(c -> c.getArrtime() + c.getTolTime() <= time);
	}

	public static void main(String[] args) {
		Okta okta = new Okta();
		System.out.println(
				Arrays.toString(okta.solution(new String[] { "1,5,10", "2,5,10", "3,5,10", "4,5,10" }, 2, 10)));
	}
}

class Customer {
	public int getArrtime() {
		return arrTime;
	}

	public int getServTime() {
		return servTime;
	}

	public int getTolTime() {
		return tolTime;
	}

	private int arrTime;
	private int servTime;
	private int tolTime;

	public Customer(int aT, int sT, int tT) {
		this.arrTime = aT;
		this.servTime = sT;
		this.tolTime = tT;
	}

	@Override
	public String toString() {
		return this.arrTime + " " + this.servTime + " " + this.tolTime;
	}
}

class Window implements Comparable<Window> {

	private int availableTime;
	private int index;
	private int servedCount;

	public Window(int index) {
		this.index = index;
		this.availableTime = -1;
		this.servedCount = 0;
	}

	@Override
	public String toString() {
		return this.getWindowIndex() + " " + this.getAvaTime() + " " + this.getServedPeople();
	}

	public int getAvaTime() {
		return availableTime;
	}

	public int getWindowIndex() {
		return index;
	}

	public void serve(Customer customer, int time) {
		this.availableTime = time + customer.getServTime();
		servedCount++;
		
	}

	public int getServedPeople() {
		return servedCount;
	}

	
	@Override
	public int compareTo(Window o) {
		if (this.getAvaTime() != o.getAvaTime()) {
			return this.getAvaTime() - o.getAvaTime();
		} else {
			return this.getWindowIndex() - o.getWindowIndex();
		}
	}
}
