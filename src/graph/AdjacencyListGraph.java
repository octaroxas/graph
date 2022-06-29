package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Random;

import graph.adjacencylist.AdjacencyList;
import graph.adjacencylist.AdjacencyListNode;

public class AdjacencyListGraph extends Graph {
	protected AdjacencyList[] adj;

	//================================================================================
	// Essential Methods
	//================================================================================

	public AdjacencyListGraph(int maxVertices) {
		numberOfVertices = 0;
		numberOfEdges = 0;
		adj = new AdjacencyList[maxVertices];
		hasDirectedEdges = false;
		hasUndirectedEdges = false;
		hasWeightedEdges = false;
		hasUnweightedEdges = false;
	}

	private int index(Vertex v) {
		return v.index();
	}

	@Override
	public Vertex addVertex(Vertex v) {
		if (numberOfVertices == adj.length)
			throw new RuntimeException("O grafo está cheio");
		if ( !v.isIndexed() ) 
			v.setIndex(numberOfVertices);
		if (adj[v.index()] != null) {
			if (adj[v.index()].getOwnerVertex() == v)
				throw new RuntimeException("Este vértice já existe no grafo");
			else
				throw new RuntimeException("O índice deste vértice já está ocupado por outro vértice neste grafo");
		}
		adj[v.index()] = new AdjacencyList(v);
		numberOfVertices++;
		return v;
	}

	@Override
	public Vertex vertexAt(int i) {
		return adj[i].getOwnerVertex();
	}

	@Override
	public boolean contaisVertex(Vertex v) {
		return v == adj[v.index()].getOwnerVertex();
	}

	@Override
	public Edge addEdge( Edge edge ) {
		Vertex u = edge.u;
		Vertex v = edge.v;
		if ( !contaisVertex(u) || !contaisVertex(v) )
			throw new RuntimeException("Algum dos vértices da aresta " + edge + " não está no grafo");

		adj[index(u)].addEdge(edge);
		if (!edge.isDirected()) {
			Edge e2 = edge.createReverse(); //edge.isWeighted() ? new Edge(v, u, edge.weight(), false) : new Edge(v, u, false);
			edge.setReverse(e2);
			e2.setReverse(edge);
			adj[index(v)].addEdge(e2);
		}
		numberOfEdges++;
		if (edge.isDirected())
			hasDirectedEdges = true;
		else
			hasUndirectedEdges = true;
		if (edge.isWeighted())
			hasWeightedEdges = true;
		else
			hasUnweightedEdges = true;
		return edge;
	}

	@Override
	public boolean contaisEdge(Vertex u, Vertex v) {
		for( Vertex i: adj[index(u)].adjacentVertices() )
			if ( i == v )
				return true;
		return false;
	}	

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for( Vertex u: vertices() ) {
			s.append("[" + u + "]--|-->" );
			//for( Vertex v: adj[index(u)].adjacentVertices() )
			for(Edge e: edgesIncidentFrom(u))
				if (e.isDirected() || e.u.index() < e.v.index())
					s.append("[" + e.v + "" + (e.isWeighted()?";w="+e.weight:"") + "]->" );
			s.append("\n");
		}
		if (s.length()>0)
			s.delete(s.length()-1, s.length());
		return s.toString();
	}

	//================================================================================
	// Additional Methods
	//================================================================================
	
	public static AdjacencyListGraph randomConnectedUndirectedGraph(int numberOfVertices, int numberOfEdges) {
		int maxEdges = (numberOfVertices*numberOfVertices-numberOfVertices)/2;
		int minEdges = numberOfVertices - 1;
		if (numberOfEdges > maxEdges)
			throw new RuntimeException("A quantidade de arestas não pode ser maior que (V^2-V)/2");
		if (numberOfEdges < minEdges)
			throw new RuntimeException("A quantidade de arestas deve ser pelo menos V-1");
		
		AdjacencyListGraph g  = new AdjacencyListGraph(numberOfVertices);
		for(int i=0; i<numberOfVertices; i++)
			g.addVertex( new Vertex(String.valueOf(i)) );
		for(int i=0; i<numberOfVertices-1; i++)
			g.addEdge( new Edge(g.vertexAt(i), g.vertexAt(i+1), 0, false) );
		
		Edge edges[] = new Edge[maxEdges-minEdges];
		int i=0;
		for(int u=0; u<numberOfVertices; u++)
			for(int v=u+2; v<numberOfVertices; v++)
				edges[i++] = new Edge(g.vertexAt(u), g.vertexAt(v), 0, false);
		
		i = edges.length;
		Random rand = new Random();
		numberOfEdges -= numberOfVertices-1; 
		while(numberOfEdges-- > 0) {
			int r = rand.nextInt(i);
			g.addEdge(edges[r]);
			edges[r] = edges[--i];
		}
		return g;
	}

	public static AdjacencyListGraph randomGraph(int numberOfVertices, int numberOfEdges, boolean directed) {
		int maxEdges = directed ? (numberOfVertices*numberOfVertices) : ((numberOfVertices*numberOfVertices-numberOfVertices)/2);
		if (numberOfEdges > maxEdges)
			throw new RuntimeException("A quantidade de arestas especificada supera o máximo permitido");
		AdjacencyListGraph g  = new AdjacencyListGraph(numberOfVertices);
		for(int i=0; i<numberOfVertices; i++)
			g.addVertex( new Vertex(String.valueOf(i)) );
		Edge edges[] = new Edge[maxEdges];
		
		int i=0;
		for(int u=0; u<numberOfVertices; u++)
			for(int v=(directed?0:u+1); v<numberOfVertices; v++)
				edges[i++] = new Edge(g.vertexAt(u), g.vertexAt(v), 0, directed);
		
		i = edges.length;
		Random rand = new Random();
		while(numberOfEdges-- > 0) {
			int r = rand.nextInt(i);
			g.addEdge(edges[r]);
			edges[r] = edges[--i];
		}
		return g;
	} 
	
	public static AdjacencyListGraph graphFromFile(String fileName, boolean directed) {
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			String line = file.readLine();
			int numberOfVertices = Integer.parseInt(line); 
			AdjacencyListGraph graph = new AdjacencyListGraph(numberOfVertices);
			Vertex vertices[] = new Vertex[numberOfVertices];
			for( int i=0; i<numberOfVertices; i++) {
				Vertex v = new Vertex(Character.toString((char)('a'+i)), null);
				graph.addVertex(v);
				vertices[i] = v;
			}
			while ( (line = file.readLine()) != null ) {
				String[] uv = line.split(" ");
				Vertex u = vertices[Integer.parseInt(uv[0])];
				Vertex v = vertices[Integer.parseInt(uv[1])];
				if ( uv.length > 2 )
					graph.addEdge( new Edge(u, v, Double.parseDouble(uv[2]), directed) );
				else
					graph.addEdge( new Edge(u, v, directed) );
			}
			file.close();
			return graph;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//================================================================================
	// Iterable Methods
	//================================================================================

	@Override
	public Iterable<Vertex> vertices() {
		return new VertexIterator();
	}

	@Override
	public Iterable<Vertex> adjacentVertices(Vertex u) {
		return adj[index(u)].adjacentVertices();
	}

	@Override
	public Iterable<Edge> edges() {
		return new EdgeIterator();
	}

	@Override
	public Iterable<Edge> edgesIncidentFrom(Vertex u) {
		return adj[index(u)].edges();
	}


	//================================================================================
	// Iterable Subclasses
	//================================================================================

	public class VertexIterator implements Iterator<Vertex>, Iterable<Vertex> {
		protected int iu;

		public VertexIterator() {
			iu = 0;
		}

		@Override
		public boolean hasNext() {
			return iu < numberOfVertices;
		}

		@Override
		public Vertex next() {
			return adj[iu++].getOwnerVertex();
		}

		@Override
		public Iterator<Vertex> iterator() {
			return this;
		}
	}

	public class EdgeIterator implements Iterator<Edge>, Iterable<Edge> {
		private int index;
		private AdjacencyListNode node;

		public EdgeIterator() {
			index = 0;
			node = null;
		}

		@Override
		public boolean hasNext() {			
			do {
				if (node!=null)
					node = node.getNext();
				while (node==null && index<numberOfVertices())
					node = adj[index++].head();				
			} while( node!=null &&
					!node.getEdge().isDirected() && 
					index(node.getEdge().u) > index(node.getEdge().v) );
			return node != null;
		}

		@Override
		public Edge next() {
			return node.getEdge();
		}

		@Override
		public Iterator<Edge> iterator() {
			return this;
		}

	}

	/*@Override
	public void exportToDotFile( String fileName ) {
		StringBuilder s = new StringBuilder();
		String rel;
		if ( isDirected() ) {
			s.append("digraph Graph1 {\n");
			rel = "->";
		} else {
			s.append("strict graph Graph1 {\n");
			rel = "--";
		}
		for( Vertex u: this.vertices() )
			for( Vertex v: this.adjacentVertices(u) )
				s.append("\t" + u + rel + v + ";\n");
		s.append("}");

		PrintWriter file = null;
		try {
			file = new PrintWriter(fileName);
			file.print(s.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			file.close();
		}
	}*/

}