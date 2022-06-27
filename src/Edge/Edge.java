package Edge;

import Vertex.Vertex;

public class Edge<TYPE> {

    private Double data;
    private Vertex<TYPE> start;
    private Vertex<TYPE> end;

    public Edge(Double data, Vertex<TYPE> start, Vertex<TYPE> end ) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public Vertex<TYPE> getStart() {
        return start;
    }

    public void setStart(Vertex<TYPE> start) {
        this.start = start;
    }

    public Vertex<TYPE> getEnd() {
        return end;
    }

    public void setEnd(Vertex<TYPE> end) {
        this.end = end;
    }
}
