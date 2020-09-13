package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {

	

	Set<Vertex> vertices;
	
	public Graph() {	
		vertices = new HashSet<Vertex>();
	}
	
	public boolean addEdge(Vertex src, Vertex dest, int weight) {
		return src.getEdges().add(new Edge(dest, weight));
	}
	
	public boolean addVertex(Vertex v) {
		return vertices.add(v);
	}
	
	public void printGraph() {
		
		for(Vertex v: vertices) {
			System.out.println("From vertex: " + v.getName());
			for(Edge e: v.getEdges()) {
				
				System.out.println(" to vertex: " + e.getDest().getName() + " with weight " + e.getWeight());
			}
			System.out.println(" ");
		}	
	}
	
	public Set<Vertex> getVertices() {
		return vertices;
	}
}

class Vertex {

	String name;
	List<Edge> edges;

	public Vertex(String n) {
		name = n;
		edges = new LinkedList<Edge>();
	}

	public String getName() {
		return name;
	}

	public List<Edge> getEdges() {
		return edges;
	}

}
class Edge {

	Vertex dest;
	int weight;

	public Edge(Vertex d, int w) {
		dest = d;
		weight = w;
	}

	public Edge(Vertex d) {
		dest = d;
		weight = 0;
	}

	public Vertex getDest() {
		return dest;
	}

	public int getWeight() {
		return weight;
	}
}