package graph.adjacencylist;

import java.util.Iterator;

import graph.Edge;
import graph.Vertex;

public class AdjacencyList {
	private Vertex ownerVertex;
	private AdjacencyListNode head, tail;
	private int size;
	
	public AdjacencyList(Vertex ownerVertex) {
		this.ownerVertex = ownerVertex;
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public Vertex getOwnerVertex() {
		return ownerVertex;
	}

	public void setOwnerVertex(Vertex ownerVertex) {
		this.ownerVertex = ownerVertex;
	}
	
	public AdjacencyListNode head() {
		return this.head;
	}
	
	public AdjacencyListNode tail() {
		return this.tail;
	}

	public void addEdge(Edge edge) {
		AdjacencyListNode node = new AdjacencyListNode(edge);
		if (head == null) 
			head = tail = node;
		else {
			tail.setNext(node);
			tail = node;
		}
		size++;		
	}
	
	public int size() {
		return size;
	}
	
	public Iterable<Edge> edges() {
		return new EdgeIterator();
	}
	
	public Iterable<Vertex> adjacentVertices() {
		return new AdjacentVerticesIterator();
	}

	public class EdgeIterator implements Iterator<Edge>, Iterable<Edge> {
		private AdjacencyListNode current;
		
		public EdgeIterator() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public Edge next() {
			Edge result = current.getEdge();
			current = current.getNext();
			return result;
		}

		@Override
		public Iterator<Edge> iterator() {
			return this;
		}
	}
	
	public class AdjacentVerticesIterator implements Iterator<Vertex>, Iterable<Vertex> {
		private AdjacencyListNode current;
		
		public AdjacentVerticesIterator() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Vertex next() {
			Vertex result = current.getEdge().v();
			current = current.getNext();
			return result;
		}

		@Override
		public Iterator<Vertex> iterator() {
			return this;
		}
	}
	
	
}

