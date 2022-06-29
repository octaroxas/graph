package graph;

public class Vertex implements Comparable<Vertex> {
	public static final int NO_INDEXED = -1;
	protected String name;
	protected Object data; //Poderia usar buckets para adicionar quaisquer grupo de dados
	private int index;
	
	public Vertex(String name, Object data ) {
		this.name = name;
		this.data = data;
		this.index = NO_INDEXED;
	}
	
	public Vertex(String name) {
		this(name, null);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	public boolean isIndexed() {
		return index != NO_INDEXED;
	}
	
	public int index() {
		return index;
	}
	
	public void setIndex(int i) {
		if (i < 0)
			throw new RuntimeException("O índice deve ser maior ou igual a zero!");
		if ( isIndexed() )
			throw new RuntimeException("Este vértice já está indexado, ele deve ser usado sempre neste índice para evitar problemas de indexação quando usado em vários grafos!");
		index = i;
	}

	public String toString() {
		return name;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Vertex v) {
        return ((Comparable<Object>)data).compareTo(v.data);
	}	
}