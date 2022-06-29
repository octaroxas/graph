package graph;

public class Edge implements Comparable<Edge> {
	protected Vertex u;
	protected Vertex v;
	protected boolean directed;
	protected double weight;
	protected Object data;
	
	private Edge reverse;
	
	public Edge(Vertex u, Vertex v, double w, boolean directed) {
		if ( !directed && u == v)
			throw new RuntimeException("Em uma aresta não direcionada u deve ser diferente de v");
		this.u = u;
		this.v = v;
		this.weight = w;
		this.directed = directed;
		
		this.reverse = null;
	}
	
	public Edge(Vertex u, Vertex v, boolean directed) {
		this(u, v, Double.NaN, directed);
	}

	public Edge(Vertex u, Vertex v, double w) {
		this(u, v, w, true);
	}
	
	public Edge(Vertex u, Vertex v) {
		this(u, v, true);
	}

	public Vertex u() {
		return u;
	}

	public Vertex v() {
		return v;
	}
		
	public double weight() {
		if (!isWeighted())
			throw new RuntimeException("Esta aresta não é ponderada");
		return weight;
	}
	
	public void setWeight(double weight) {
		if (!isWeighted())
			throw new RuntimeException("Esta aresta não é ponderada");
		if (weight == Double.NaN)
			throw new RuntimeException("Peso inválido!");
		this.weight = weight;
		if (reverse != null)
			reverse.weight = weight;		
	}
	
	public boolean isWeighted() {
		return !Double.isNaN(weight);
	}
	
	public boolean isDirected() {
		return this.directed;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
		if (reverse != null)
			reverse.setData(data);
	}
	
	public void setReverse(Edge reverse) {
		this.reverse = reverse;
	}
	
	public Edge getReverse() {
		return this.reverse;
	}

	public Edge createReverse() {
		if ( isWeighted() )
			return new Edge(v, u, weight, directed);
		else
			return new Edge(v, u, directed);
	}
	
	@Override
	public int compareTo(Edge e) {
		double w1 = this.isWeighted() ? this.weight() : Double.NEGATIVE_INFINITY;
		double w2 = e.isWeighted() ? e.weight() : Double.NEGATIVE_INFINITY;
		if (w1 > w2)
			return 1;
		else if (w1 < w2)
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("(" + u);
		b.append( isDirected() ? "->" : "--");
		b.append(v);
		b.append(isWeighted() ? ", " + weight() : "" );
		b.append(")");
		return b.toString();
	}

}
