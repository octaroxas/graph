package graph;

public class DataVertice {
    private Double key;
    private Vertex pi;

    public DataVertice() {
        this.key = Double.POSITIVE_INFINITY;
        this.pi = null;
    }

    public Double getKey() {
        return key;
    }

    public void setKey(Double key) {
        this.key = key;
    }

    public Vertex getPi() {
        return pi;
    }

    public void setPi(Vertex pi) {
        this.pi = pi;
    }
}
