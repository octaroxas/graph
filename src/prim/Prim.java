package prim;

import graph.DataVertice;
import graph.Graph;
import graph.Vertex;

public class Prim {

    public void graphIsWeighted() {

    }

    public void graphIsConnected() {

    }

    public void graphIsNotDireted() {

    }

    public void primMethod(Graph graph, Vertex root) {
        //inicializar os valores do pesos do grafo com infinito e predecossor nulo
        Graph g = graph;
        intializeGraphValues(g);
        listVertexValues(g);
        System.out.println("Root key:"+root.getData().getKey()+" Root pi:"+root.getData().getPi());

    }

    public void listVertexValues(Graph g){
        System.out.println("Valores do grafo inicializado!");
        for (Vertex v: g.vertices()){
            System.out.println("Key: "+v.getData().getKey()+", PI: "+v.getData().getPi());
        }
    }

    public Graph intializeGraphValues(Graph graph){
        Graph g = graph;

        for (Vertex v: g.vertices()){
            DataVertice data = new DataVertice();
            data.setKey(Double.POSITIVE_INFINITY);
            data.setPi(null);
            v.setData(data);
        }
        return g;
    }
}
