package Graph;

import Edge.Edge;
import Vertex.Vertex;

import java.util.ArrayList;

public class Graph<TYPE> {
    private ArrayList<Vertex<TYPE>> vertex;
    private ArrayList<Edge<TYPE>> edges;

    //constructor
    public Graph() {
        this.edges = new ArrayList<Edge<TYPE>>();
        this.vertex = new ArrayList<Vertex<TYPE>>();
    }

    public void addVertex(TYPE data) {
        Vertex<TYPE> newVertex = new Vertex<TYPE>(data );
        this.vertex.add(newVertex);
    }

    public void addEdge(Double weight, TYPE start, TYPE end) {
        Vertex<TYPE> vertexStart = findVertex(start);
        Vertex<TYPE> vertexEnd = findVertex(end);

        Edge<TYPE> newEdge = new Edge<TYPE>(weight, vertexStart, vertexEnd);

        vertexStart.addExitEdge(newEdge);
        vertexEnd.addInputEdge(newEdge);

        this.edges.add(newEdge);
    }

    public Vertex<TYPE>  findVertex(TYPE data) {
        Vertex<TYPE> vertexSeeked = null;
        for(int i=0; i < this.vertex.size(); i++) {
           if(this.vertex.get(i).getData().equals(data)) {
                vertexSeeked = this.vertex.get(i);
                break;
           }
        }
        return vertexSeeked;
    }
}
