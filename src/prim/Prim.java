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

    public void primMethod(Graph graph) {
        //inicializar os valores do pesos do grafo com infinito e predecossor nulo


    }

    public void listVertexValues(Graph g){
        System.out.println("Valores do grafo inicializado \n");
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
