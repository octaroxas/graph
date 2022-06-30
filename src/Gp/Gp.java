package Gp;

import Graph.Graph;

public class Gp {
    public  static void main(String[] args){
        Graph<String> graph = new Graph<String>();

        graph.addVertex("João");
        graph.addVertex("Octa");
        graph.addVertex("Luiz");
        graph.addVertex("Marcos");
        graph.addVertex("Kelly");

        graph.addEdge(2.0,"João", "Kelly");
        graph.addEdge(2.0,"Marcos", "Kelly");
        graph.addEdge(2.0,"Luiz", "Octa");
        graph.addEdge(2.0,"João", "Marcos");
        graph.addEdge(2.0,"Luiz", "Kelly");

        graph.breadthSearch();
        System.out.println("Fim");



    }
}
