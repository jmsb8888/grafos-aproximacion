package graphsCities;

public class Edge {

	private Vertex origin;
	private Vertex destination;
	private double weigth;
	
	public Edge(Vertex origin, Vertex destination, double weigth) {
		this.origin = origin;
		this.destination = destination;
		this.weigth = weigth;
	}

	public Vertex getOrigin() {
		return origin;
	}

	public void setOrigin(Vertex origin) {
		this.origin = origin;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	@Override
	public String toString() {
		return "origin=" + origin.getName() + ", destination=" + destination.getName() + ", weigth=" + weigth +"\n";
	}
	
	
	
}
