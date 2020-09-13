package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopLogicalSort {

	public static void topoLogicalSort(Graph g) {

		
		List<Vertex> visited = new ArrayList<>();

		Stack<Vertex> stack = new Stack<>();

	
		
		for (Vertex v : g.getVertices()) {

			if (visited.contains(v)) {
				continue;
			}

			topsortutil(v, visited, stack);
		}

		while(!stack.isEmpty()) {
			System.out.print(stack.pop().name);
			System.out.print(" --> ");
		}
		
	}

	public static void topsortutil(Vertex v, List<Vertex> visited, Stack<Vertex> stack) {

		visited.add(v);

		for (Edge e : v.getEdges()) {
			if (visited.contains(e.dest))
				continue;
			topsortutil(e.dest, visited, stack);
		}
		stack.add(v);

	}

	public static void main(String[] args) {

		Graph g = new Graph();
		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");

		g.addVertex(v0);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);

		v5.getEdges().add(new Edge(v0));
		v4.getEdges().add(new Edge(v0));
		v4.getEdges().add(new Edge(v1));
		v5.getEdges().add(new Edge(v2));
		v2.getEdges().add(new Edge(v3));
		v3.getEdges().add(new Edge(v1));
		
		topoLogicalSort(g);
	}

}
