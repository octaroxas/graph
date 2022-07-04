package graph;

public class Vertex implements Comparable<Vertex> {
	public static final int NO_INDEXED = -1;
	protected String name;
//	protected Object data; //Poderia usar buckets para adicionar quaisquer grupo de dados
	protected  DataVertice data;
	private int index;
	
	public Vertex(String name, DataVertice data ) {
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
	
	public void setData(DataVertice data) {
		this.data = data;
	}
	
	public DataVertice getData() {
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
			throw new RuntimeException("O �ndice deve ser maior ou igual a zero!");
		if ( isIndexed() )
			throw new RuntimeException("Este v�rtice j� est� indexado, ele deve ser usado sempre neste �ndice para evitar problemas de indexa��o quando usado em v�rios grafos!");
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