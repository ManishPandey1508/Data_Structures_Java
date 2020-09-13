import java.util.Arrays;
import java.util.List;

public class ActiveFountain {

	public static void main(String[] args) {

		Integer[] input = new Integer[] {2,0,0,0};
		List<Integer> a = Arrays.asList(input);
		System.out.println("Min Fountain Needed " + fountainActivation(a));

	}

	public static int fountainActivation(List<Integer> a) {

		class Interval {
			int start;
			int end;

			public Interval(int start, int end) {
				this.start = start;
				this.end = end;
			}

		}
		int n = a.size();

		Interval[] intervals = new Interval[n];

		for (int i = 0; i < n; i++) {

			int min = Math.max(i+1 - a.get(i), 1);
			int max = Math.min(i+1 + a.get(i), n);
			intervals[i] = new Interval(min, max);
		}

		Interval target = new Interval(1, n);

		if (intervals == null || intervals.length == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (Interval i : intervals) {
			min = Math.min(min, i.start);
			max = Math.max(max, i.end);
		}
		int[] count = new int[max - min + 1];
		for (Interval i : intervals) {
			count[i.start - min] = Math.max(count[i.start - min], i.end - i.start);
		}

		int reach = 0;
		int maxReach = 0;
		int target_start = target.start - min;
		int target_end = target.end - min;
		int i = 0;
		for (; i <= target_start; i++) {
			if (i + count[i] < target_start)
				continue;
			reach = Math.max(reach, i + count[i]);
		}
		int res = 1;
		for (; i < count.length; i++) {
			if (reach >= target_end)
				break;
			maxReach = Math.max(maxReach, i + count[i]);
			if (reach <= i) {
				reach = maxReach;
				res++;
			}
		}
		return reach >= target_end ? res : -1;

	}

}
