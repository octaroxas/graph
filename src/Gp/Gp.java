package Gp;

import Graph.Graph;

public class Gp {
    public  static void main(String[] args){
        Graph<String> graph = new Graph<String>();

        graph.addVertex("João");
        graph.addVertex("Lorenzo");
        graph.addVertex("Creuza");
        graph.addVertex("Créber");
        graph.addVertex("Cráudio");

        graph.addEdge(2.0,"João", "Lorenzo");
        graph.addEdge(2.0,"Lorenzo", "Créber");
        graph.addEdge(2.0,"Créber", "Creuza");
        graph.addEdge(2.0,"João", "Creuza");
        graph.addEdge(2.0,"Cráudio", "Lorenzo");
        graph.addEdge(2.0,"Cráudio", "João");

        System.out.println("Fim");

    }
}
