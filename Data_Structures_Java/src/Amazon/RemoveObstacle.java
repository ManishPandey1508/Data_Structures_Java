package Amazon;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveObstacle {



	public static void main(String[] args) {
		
		List<List<Integer>> lot = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(1);
		l1.add(1);
		l1.add(1);

		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(0);
		l2.add(1);
		l2.add(1);
		l2.add(1);

		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(0);
		l3.add(1);
		l3.add(0);
		l3.add(1);

		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(1);
		l4.add(1);
		l4.add(9);
		l4.add(1);

		List<Integer> l5 = new ArrayList<Integer>();
		l5.add(0);
		l5.add(0);
		l5.add(1);
		l5.add(1);

		lot.add(l1);
		lot.add(l2);
		lot.add(l3);
		lot.add(l4);
		lot.add(l5);

		System.out.println(removeObstacle(5, 4, lot));
	}

	public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> area) {
		int res = -1;
		boolean[][] visited = new boolean[numRows][numColumns];

		if (!(area.get(0).get(0) == 0)) {

			Queue<List<Integer>> q = new LinkedList<List<Integer>>();
			List r = new ArrayList<Integer>();
		    r.add(0);
			r.add(0);
			r.add(0);

			q.add(r);

			while (!q.isEmpty()) {

				List<Integer> m = q.remove();

				int a = m.get(0);
				int b = m.get(1);

				visited[a][b] = true;

				if (area.get(m.get(0)).get(m.get(1)) == 9) {
					return m.get(2);
				}

				int curDis = m.get(2);

				if (isvalid(a, b + 1, numRows, numColumns)) {
					if (!visited[a][b + 1]) {
						List u = new ArrayList<Integer>();
						u.add(a);
						u.add(b + 1);
						u.add(curDis + 1);
						if (area.get(a).get(b + 1) != 0)
							q.add(u);
					}
				}

				if (isvalid(a + 1, b, numRows, numColumns)) {
					if (!visited[a + 1][b]) {
						List u = new ArrayList<Integer>();
						u.add(a + 1);
						u.add(b);
						u.add(curDis + 1);
						if (area.get(a + 1).get(b) != 0)
							q.add(u);
					}
				}

				if (isvalid(a, b - 1, numRows, numColumns)) {
					if (!visited[a][b - 1]) {
						List u = new ArrayList<Integer>();
						u.add(a);
						u.add(b - 1);
						u.add(curDis + 1);
						if (area.get(a).get(b - 1) != 0)
							q.add(u);
					}
				}

				if (isvalid(a - 1, b, numRows, numColumns)) {
					if (!visited[a - 1][b]) {
						List u = new ArrayList<Integer>();
						u.add(a - 1);
						u.add(b);
						u.add(curDis + 1);
						if (area.get(a - 1).get(b) != 0)
							q.add(u);
					}
				}

			}

		}
		return res;
	}

	private static boolean isvalid(int a, int b, int numRows, int numColumns) {

		if (a >= 0 && b >= 0 && a < numRows && b < numColumns) {
			return true;
		}

		return false;
	}
}
