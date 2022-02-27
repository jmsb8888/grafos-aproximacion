package graphsCities;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
	private String name;
	private List<Edge> edges;
	
	
	public Vertex(String name) {
		super();
		this.name = name;
	}

	public void addEdge(Vertex destination , double weigth, boolean bidirectional) {
		if(edges == null) {
			edges = new LinkedList<>();
		}
		if(bidirectional){
			edges.add(new Edge(this, destination,weigth));
		}else{
			if(destination.edges == null) destination.edges = new LinkedList<>();
			destination.edges.add(new Edge(destination, this,weigth));
		}
		if(bidirectional) addEdge(destination, weigth, false);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Edge> getEdges() {
		return edges;
	}


	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public String toString() {
		return "Vertices de " + name + ":\n " + edges +"\n";
	}
	
	

}
