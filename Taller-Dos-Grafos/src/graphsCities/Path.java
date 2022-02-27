package graphsCities;

import java.util.ArrayList;

public class Path {
    private ArrayList<String> cities;
    private double distance;

    public Path(ArrayList<String> name, double distance) {
        this.cities = name;
        this.distance = distance;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void setCities(ArrayList<String> cities) {
        this.cities = cities;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Camino encontrado: " +
                "{" + cities +" "+
                ", distance=" + distance +
                '}'+"\n";
    }
}
