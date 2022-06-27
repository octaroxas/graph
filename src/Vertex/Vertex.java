package Vertex;

import Edge.Edge;

import java.util.ArrayList;

public class Vertex<TYPE> {
    private TYPE data;
    private ArrayList<Edge<TYPE>> inputEdges;
    private ArrayList<Edge<TYPE>> exitEdges;
    public Vertex(TYPE data){
        this.data = data;
        this.inputEdges = new ArrayList<Edge<TYPE>>();
        this.exitEdges = new ArrayList<Edge<TYPE>>();
    }

    public TYPE getData() {
        return data;
    }

    public void setData(TYPE data) {
        this.data = data;
    }

    public void addInputEdge( Edge<TYPE> edge) {
        this.inputEdges.add(edge);
    }

    public void addExitEdge( Edge<TYPE> edge) {
        this.exitEdges.add(edge);
    }
}
