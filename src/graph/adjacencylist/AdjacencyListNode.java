package graph.adjacencylist;

import graph.Edge;

public class AdjacencyListNode {
	private Edge edge;
	private AdjacencyListNode next;
		
	public AdjacencyListNode(Edge edge, AdjacencyListNode next) {
		this.edge = edge;
		this.next = next;
	}
	
	public AdjacencyListNode(Edge edge) {
		this(edge, null);
	}
	
	public Edge getEdge() {
		return edge;
	}
	
	public void setEdge(Edge edge) {
		this.edge = edge;
	}
	
	public AdjacencyListNode getNext() {
		return next;
	}
	
	public void setNext(AdjacencyListNode next) {
		this.next = next;
	}
}
