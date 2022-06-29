package test;


import java.util.LinkedList;
import java.util.List;

import graph.AdjacencyListGraph;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class AdjacencyListGraphTest {	
	public static void main(String[] args) {		
		Graph g = AdjacencyListGraph.graphFromFile("input/cormen_23.1", false);
		//Graph g = AdjacencyListGraph.randomConnectedUndirectedGraph(4, 4);
		
		System.out.println("Graph (Fig-23.1 Pag-625)");		
		System.out.println("Número de vertices: " + g.numberOfVertices() );
		System.out.println("Número de arestas: " + g.numberOfEdges());

		System.out.println("\nVértices");
		List<Vertex> vertices = new LinkedList<>();
		for( Vertex u: g.vertices() ) {
			vertices.add(u);
			System.out.print(u + " ");
		}
		System.out.println();

		System.out.println("\nVértices Adjacentes");
		for( Vertex u: g.vertices() ) {
			System.out.print(u + ":");
			for( Vertex v: g.adjacentVertices(u) )
				System.out.print( " " + v);
			System.out.println();
		}

		System.out.println("\nArestas que incidem do vértice");
		for( Vertex u: g.vertices() ) {
			System.out.print(u + ":");
			for( Edge e: g.edgesIncidentFrom(u) )
				System.out.print( " " + e);
			System.out.println();
		}

		System.out.println("\nArestas");
		for( Edge e: g.edges() )
			System.out.println(e);

		System.out.println("\nAresta Existe?");
		System.out.println( g.contaisEdge( vertices.get(0), vertices.get(1) ) );

		System.out.println("\nRepresentação textual do grafo");
		System.out.println(g);
		
		/*Graph g = new AdjacencyListGraph(5);
		Vertex v0 = g.addVertex( new Vertex("v0", 0) );
		Vertex v1 = g.addVertex( new Vertex("v1", 1) );
		Vertex v2 = g.addVertex( new Vertex("v2", 2) );
		Vertex v3 = g.addVertex( new Vertex("v3", 3) );		
		g.addEdge( new Edge(v0, v1, 10, true) );
		g.addEdge( new Edge(v1, v0, 10, true) );
		g.addEdge( new Edge(v1, v2, 20, true) );
		g.addEdge( new Edge(v1, v3, 30, false) );*/
		
		/*Graph rg = AdjacencyListGraph.randomGraph(4, 4, false);
		System.out.println(rg);*/

	}

}
