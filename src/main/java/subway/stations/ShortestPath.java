package subway.stations;

import java.util.*;

public class ShortestPath {

    private List<SubwayStations.Station> stations;

    public ShortestPath(List<SubwayStations.Station> stations){
        this.stations = stations;
    }

    public SubwayStations.Station getClosestStation(List<Double> coordinates){

        double shortestDistance = Double.MAX_VALUE;
        SubwayStations.Station closestStation = null;

        for(SubwayStations.Station station : stations){
            double distance = distanceFormula(coordinates, station.getCoordinates());
            if(distance < shortestDistance){
                shortestDistance = distance;
                closestStation = station;
            }
        }

        return closestStation;
    }

    public double distanceFormula(List<Double> fromCoordinates, List<Double> toCoordinates){
        double dx = toCoordinates.get(0) - fromCoordinates.get(0);
        double dy = toCoordinates.get(1) - fromCoordinates.get(1);
        double dxSquared = dx * dx;
        double dySquared = dy * dy;

        return Math.pow((dxSquared + dySquared), 0.5);
    }

    public List<SubwayStations.Station> dijkstrasAlgorithm(SubwayStations.Station source, SubwayStations.Station destination) {

        Set<SubwayStations.Station> unvisitedStations = new HashSet<>();

        for(SubwayStations.Station station : stations){
            station.distanceFromSource = Integer.MAX_VALUE;
           // station.connections = station.getConnections(lines, station);
            unvisitedStations.add(station);
        }
        SubwayStations.Station currentSource = source;
        currentSource.distanceFromSource = 0;
        while (!(currentSource.connections.contains(destination))) {
            for(SubwayStations.Station station : currentSource.connections){
                if(unvisitedStations.contains(station)){
                    station.distanceFromSource = currentSource.distanceFromSource + 1;
                    station.previous = currentSource;
                }
            }
            unvisitedStations.remove(currentSource);
            int comparator = currentSource.distanceFromSource + 2;

            for(SubwayStations.Station station : unvisitedStations){
                int thisDistance = station.distanceFromSource;
                if (thisDistance < comparator) {
                    currentSource = station;
                }
            }
        }

        return getPath(source, destination, currentSource);
    }

    private List<SubwayStations.Station> getPath(SubwayStations.Station source, SubwayStations.Station destination, SubwayStations.Station currentSource) {
        List<SubwayStations.Station> path = new ArrayList<>();
        path.add(destination);
        path.add(currentSource);
        SubwayStations.Station currentStation = currentSource;

        while(!(currentStation.previous == null)){
            path.add(currentStation.previous);
            currentStation = currentStation.previous;
        }
        Collections.reverse(path);
        return path;
    }

}
