package test;

import graphsCities.CitiesGraph;
import graphsCities.Vertex;

public class Main {

	public static void main(String[] args) {
		
		CitiesGraph cicitesGraph = new CitiesGraph();
		Vertex tunja = new Vertex("Tunja");
		Vertex paipa = new Vertex("Paipa");
		Vertex duitama = new Vertex("Duitama");
		Vertex sogamoso = new Vertex("Sogamoso");
		Vertex toca = new Vertex("Toca");
		Vertex pesca = new Vertex("Pesca");
		Vertex villaDeLeyva = new Vertex("VillaDeLeyva");
		Vertex santana = new Vertex("Santana");

		sogamoso.addEdge(duitama, 20.3,true);
		sogamoso.addEdge(pesca, 23.8,true);
		pesca.addEdge(toca, 30,true);
		toca.addEdge(tunja, 26.3,true);
		tunja.addEdge(villaDeLeyva, 38.3,true);
		tunja.addEdge(paipa, 45.5,true);
		villaDeLeyva.addEdge(santana, 75.5,true);
		santana.addEdge(paipa, 116.9,true);
		paipa.addEdge(duitama, 13.4,true);

		cicitesGraph.addCity(tunja);
		cicitesGraph.addCity(villaDeLeyva);
		cicitesGraph.addCity(santana);
		cicitesGraph.addCity(paipa);
		cicitesGraph.addCity(duitama);
		cicitesGraph.addCity(sogamoso);
		cicitesGraph.addCity(pesca);
		cicitesGraph.addCity(toca);

		
		/*System.out.println(cicitesGraph.toString());
		System.out.println();
		System.out.println("Para llegar de Sogamoso a Duitama se disponen de los siguientes caminos:");
		System.out.println(cicitesGraph.searchPaths(sogamoso, duitama));
		System.out.println("El camino para mas corto para llegar de Sogamoso a Duitama es: ");
		System.out.println(cicitesGraph.shortestPath( sogamoso, duitama));

		System.out.println("Para llegar de Sogamoso a Sogamoso se disponen de los siguientes caminos:");
		System.out.println(cicitesGraph.searchPaths(sogamoso, sogamoso));
		System.out.println("El camino para mas corto para llegar de Sogamoso a Sogamoso es: ");
		System.out.println(cicitesGraph.shortestPath( sogamoso, sogamoso));*/

		System.out.println("Para llegar de villadeleiva a sogamoso se disponen de los siguientes caminos:");
		System.out.println(cicitesGraph.searchPaths(villaDeLeyva, sogamoso));
		System.out.println("El camino para mas corto para llegar de Sogamoso a Duitama es: ");
		System.out.println(cicitesGraph.shortestPath( villaDeLeyva, sogamoso));
	}

}

