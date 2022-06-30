package Graph;

import Edge.Edge;
import Vertex.Vertex;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.sql.BatchUpdateException;
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

    public void breadthSearch() {
        ArrayList<Vertex<TYPE>> marked = new ArrayList<Vertex<TYPE>>();
        ArrayList<Vertex<TYPE>> fila = new ArrayList<Vertex<TYPE>>();

        Vertex<TYPE> current = this.vertex.get(0);
        marked.add(current);
        System.out.println(current.getData());
        fila.add(current);

        while (fila.size() > 0) {
            Vertex<TYPE> visited = fila.get(0);
            for(int i = 0; i < visited.getExitEdges().size(); i++){
                Vertex<TYPE> next = visited.getExitEdges().get(i).getEnd();

                if(!marked.contains(next)){
                    marked.add(next);
                    System.out.println(next.getData());
                    fila.add(next);
                }
            }
            fila.remove(0);
        }
    }
}
