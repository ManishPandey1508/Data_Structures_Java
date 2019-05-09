package PriorityQueue;

import java.util.*;

public class ShortestKPoints {

	public class Point {
		int x;
		int y;
		double distance;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			distance =  Math.sqrt((x * x + y * y));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] kClosest(int[][] points, int k) {

		if (points == null || points.length == 0)
			return null;

		int[][] result = new int[k][2];

		if (k > points.length)
			return result;

		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				// TODO Auto-generated method stub
				return Double.compare(p1.distance, p2.distance);
			}
		});

		for (int i = 0; i < points.length; i++) {
			Point p = new Point(points[i][0], points[i][1]);
			pq.offer(p);

		}
		int count = 0;

		while (count < k) {
			Point p = pq.remove();
			result[count][0] = p.x;
			result[count][1] = p.y;
			count++;
		}

		return result;
	}

}
