package graph;

public abstract class Graph {
	protected int numberOfVertices;
	protected int numberOfEdges;
	protected boolean hasDirectedEdges;
	protected boolean hasUndirectedEdges;
	protected boolean hasWeightedEdges;
	protected boolean hasUnweightedEdges;

    //================================================================================
    // Essential Implemented Methods
    //================================================================================

	
	public int numberOfVertices() {
		return numberOfVertices;
	}
	
	public int numberOfEdges() {
		return numberOfEdges;
	}
	
	public boolean isDirected() {
		return hasDirectedEdges && !hasUndirectedEdges;
	}
	
	public boolean isUndirected() {
		return !hasDirectedEdges && hasUndirectedEdges;
	}
	
	public boolean isHybrid() {
		return hasDirectedEdges && hasUndirectedEdges;
	}
	
	public boolean isWeighted() {
		return hasWeightedEdges && !hasUnweightedEdges;
	}
	
	public boolean isUnweighted() {
		return !hasWeightedEdges && hasUnweightedEdges;
	}

    //================================================================================
    // Essential Abstract Methods
    //================================================================================
	abstract public Vertex addVertex(Vertex v);
	abstract public boolean contaisVertex(Vertex v);
	abstract public Vertex vertexAt(int i);
	abstract public Edge addEdge(Edge edge);
	abstract public boolean contaisEdge(Vertex u, Vertex v);
			
	//================================================================================
    // Iterable Abstract Methods
    //================================================================================
	abstract public Iterable<Vertex> vertices();
	abstract public Iterable<Vertex> adjacentVertices(Vertex u);
	abstract public Iterable<Edge> edges();
	abstract public Iterable<Edge> edgesIncidentFrom(Vertex u);

	
}