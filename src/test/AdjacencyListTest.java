package test;

import graph.Edge;
import graph.Vertex;
import graph.adjacencylist.AdjacencyList;

public class AdjacencyListTest {
	public static void main(String[] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		AdjacencyList list = new AdjacencyList(v1);
		Edge e1 = new Edge(v1, v2);
		Edge e2 = new Edge(v1, v3);
		list.addEdge(e1);
		list.addEdge(e2);
		
		for(Edge e: list.edges() )
			System.out.println(e);
		
		System.out.println();
		
		for(Vertex v: list.adjacentVertices() )
			System.out.println(v);
		
		
		
		System.out.println("fim");
	}
}
