package graphsCities;

import java.util.ArrayList;
import java.util.List;

public class CitiesGraph {
	
	private ArrayList<Vertex> cities;
	
	public void addCity(Vertex city) {
		if(cities == null) {
			cities = new ArrayList<>();
		}
		cities.add(city);
	}

	public ArrayList<Vertex> getCities() {
		return cities;
	}

	public void setCities(ArrayList<Vertex> cities) {
		this.cities = cities;
	}

	public ArrayList<Path> searchPaths(Vertex origen, Vertex destination){
		ArrayList<Path> paths = new ArrayList<>();
		if(!origen.equals(destination)) {
			ArrayList<ArrayList<Vertex>> allPaths = determinePath(origen, destination);
			for (int j = 0; j < allPaths.size(); j++) {
				ArrayList<String> cities = new ArrayList<>();
				double count = 0;
				for (int i = 0; i < allPaths.get(j).size(); i++) {
					cities.add(allPaths.get(j).get(i).getName());
					if (i < allPaths.get(j).size() - 1) {
						count += getDistance(allPaths.get(j).get(i), allPaths.get(j).get(i + 1));
					}
				}
				paths.add(new Path(cities, count));
			}
			return paths;
		}
		ArrayList<String> cities = new ArrayList<>();
		cities.add(origen.getName());
		paths.add(new Path(cities,0)) ;
		return paths;
	}

	public Path shortestPath(Vertex origen, Vertex destination){
		ArrayList<Path> alldisttances= searchPaths(origen, destination);
		int count=0;
		double less= alldisttances.get(0).getDistance();
		for (int i = 0; i <alldisttances.size() ; i++) {
			if(alldisttances.get(i).getDistance()<less){
				less=alldisttances.get(i).getDistance();
				count++;
			}
		}
		return searchPaths(origen,destination).get(count);
	}
	private ArrayList<ArrayList<Vertex>> determinePath(Vertex origin, Vertex destination) {
		ArrayList<ArrayList<Vertex>> allPaths= new ArrayList<>();
		ArrayList<Vertex> path= new ArrayList<>();
		List<Vertex> adjacent = searchAdjacents(origin);
		path.add(origin);
		SearchSubListAdjacents(destination, allPaths, path, adjacent);
		return allPaths;

	}

	private void SearchSubListAdjacents(Vertex destination, ArrayList<ArrayList<Vertex>> allPaths, ArrayList<Vertex> path, List<Vertex> adjacent) {
		for (Vertex vertex: adjacent ) {
			Vertex current = vertex ;
			ArrayList<Vertex> aux = (ArrayList<Vertex>)path.clone();
			if(!aux.contains(current)) {
				aux.add(current);
				determinePath(current, destination, aux, allPaths);
			}
		}
	}


	private void determinePath(Vertex origin, Vertex destination, ArrayList<Vertex> pathCopy, ArrayList<ArrayList<Vertex>> allPaths) {
		if(origin==(destination)){
			allPaths.add(pathCopy);
		}else{
			List<Vertex> adjacent = searchAdjacents(origin);
			if(adjacent!=null){
				SearchSubListAdjacents(destination, allPaths, pathCopy, adjacent);
			}
		}
	}

	private  double getDistance(Vertex origen, Vertex destination){
		List<Edge> adjacents = origen.getEdges();
		for (Edge edge: adjacents) {
			if(edge.getDestination().equals(destination)){
				return edge.getWeigth();
			}
		}return 0;
	}

	private ArrayList<Vertex> searchAdjacents(Vertex origen){
		ArrayList<Vertex> adjacents = new ArrayList<>();
		for (Edge vertex: origen.getEdges()) {
			adjacents.add(vertex.getDestination());
		}
		return adjacents;
	}
	@Override
	public String toString() {
		return "Grafo de ciudad:\n " + cities ;
	}
}