package graph.extendedGraph;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graph.adjacencylist.AdjacencyListNode;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedGraph extends Graph {

    public ExtendedGraph(
            int numberOfVertices,
            int numberOfEdges,
            boolean hasDirectedEdges,
            boolean hasUndirectedEdges,
            boolean hasWeightedEdges,
            boolean hasUnweightedEdges
    ) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = numberOfEdges;
        this.hasDirectedEdges = hasDirectedEdges;
        this.hasUndirectedEdges = hasUndirectedEdges;
        this.hasWeightedEdges = hasWeightedEdges;
        this.hasUnweightedEdges = hasUnweightedEdges;
    }

    ArrayList<Vertex> listVertex = new ArrayList<Vertex>();
    ArrayList<Edge> listEdges = new ArrayList<Edge>();
    @Override
    public Vertex addVertex(Vertex v){
        listVertex.add(v);
        return v;
    }
    @Override
     public boolean contaisVertex(Vertex v){
        if(listVertex.contains(v)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
     public Vertex vertexAt(int i){
        return listVertex.get(i);
//        Vertex v = new Vertex("teste");
//        return v;
    }
    @Override
     public Edge addEdge(Edge edge){
        listEdges.add(edge);
        return edge;
    }
    @Override
     public boolean contaisEdge(Vertex u, Vertex v){
        Edge edge = new Edge(u,v);
        return listEdges.contains(edge);
    }

    //-------------------------------------------------
    @Override
    public Iterable<Vertex> vertices(){
        return listVertex;
    }
    @Override
     public Iterable<Vertex> adjacentVertices(Vertex u){
        return listVertex;
    }
    @Override
     public Iterable<Edge> edges(){
        return listEdges;
    }
    @Override
    public Iterable<Edge> edgesIncidentFrom(Vertex u){
        return listEdges;
    }

    //----Classes iterators ----------------------------

}
