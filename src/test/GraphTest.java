package test;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graph.extendedGraph.ExtendedGraph;
import prim.Prim;

public class GraphTest {
    public static void main(String[] args){

        Graph graph = new ExtendedGraph(
                4,
                5,
                false,
                true,
                true,
                false
        );

        Vertex v1 = new Vertex("Octacilio");
        Vertex v2 = new Vertex("Lucas");
        Vertex v3 = new Vertex("Jorge");
        Vertex v4 = new Vertex("Roxas");

        Edge e1 = new Edge(v1, v2, 3);
        Edge e2 = new Edge(v1, v3, 4);
        Edge e3 = new Edge(v4, v2, 7);
        Edge e4 = new Edge(v3, v4, 9);
        Edge e5 = new Edge(v1, v4, 12);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        Prim prim = new Prim();
        prim.intializeGraphValues(graph);
        prim.listVertexValues(graph);

//        for(Vertex v: graph.vertices()) {
//            System.out.println(v.getName());
//        }

        System.out.println("Grafo gerado");




    }
}
