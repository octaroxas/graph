package Graph;

import Edge.Edge;
import Vertex.Vertex;

import java.util.ArrayList;

public class Graph {
    ArrayList<Vertex> vertex;
    ArrayList<Edge> edges;

    //constructor
    public Graph(ArrayList<Vertex> vertex, ArrayList<Edge> edges) {
        this.edges = edges;
        this.vertex = vertex;
    }

    public ArrayList<Vertex> getVertex() {
        return vertex;
    }

    public void setVertex(ArrayList<Vertex> vertex) {
        this.vertex = vertex;
    }
}
