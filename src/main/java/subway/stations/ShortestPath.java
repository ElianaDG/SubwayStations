package subway.stations;

import subway.stations.SubwayStations.Station;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortestPath {

    List<Double> currentCoordinates;
    List<Double> destinationCoordinates;

    public void dijkstrasAlgorithm(Station source, Station destination){
        //get current source
        Set<Station> visitedStations = new HashSet<>();
        Set<Station> unvisitedStations = new HashSet<>();
        Station currentSource = source;
        int shortestTotalDistance = Integer.MAX_VALUE;
        //start loop here
        while(!currentSource.connections.contains(destination)){
            unvisitedStations.addAll(currentSource.connections);
            visitedStations.add(currentSource);
            //get connections of source
            List<Station> connections = source.connections;
            for (Station station : connections) {
                station.previous = currentSource;   //set parent of station for path tracing
                station.distanceFromSource++;
                int thisDistance = station.distanceFromSource;
                if (thisDistance < shortestTotalDistance) {
                    shortestTotalDistance = thisDistance;
                }
            }
            //check which station has the shortest distance
            int shortestDistanceInSet = Integer.MAX_VALUE;
            //get station with shortest distance
            for (Station station : unvisitedStations) {
                int thisDistance = station.distanceFromSource;
                if (thisDistance < shortestDistanceInSet) {
                    shortestDistanceInSet = thisDistance;
                    currentSource = station;
                }
            }
            unvisitedStations.remove(currentSource);
            //repeat until connections list contains the destination station
        }
    }

    public List<Station> getClosestStations(List<Double> currentCoordinates, List<Double> destinationCoordinates, SubwayStations subwayStations){

        List<SubwayStations.Station> closestStations = new ArrayList<>();

        double shortestDistanceToOrigin = 10000;
        double shortestDistanceToDestination = 10000;
        int closestStationToOrigin = 0;
        int closestStationToDestination = 0;

        for(int ix = 0; ix < subwayStations.stations.size(); ix++){
            double distance = distanceFormula(currentCoordinates, subwayStations.stations.get(ix).getCoordinates());
            if(distance < shortestDistanceToOrigin){
                shortestDistanceToOrigin = distance;
                closestStationToOrigin = ix;
            }
            distance = distanceFormula(destinationCoordinates, subwayStations.stations.get(ix).getCoordinates());
            if(distance < shortestDistanceToDestination){
                shortestDistanceToDestination = distance;
                closestStationToDestination = ix;
            }
        }
        closestStations.add(subwayStations.stations.get(closestStationToOrigin));
        closestStations.add(subwayStations.stations.get(closestStationToDestination));

        return closestStations;
    }

    public double distanceFormula(List<Double> fromCoordinates, List<Double> toCoordinates){
        double x = toCoordinates.get(0) - fromCoordinates.get(0);
        double y = toCoordinates.get(1) - fromCoordinates.get(1);
        double xSquared = x * x;
        double ySquared = y * y;

        return Math.pow((xSquared + ySquared), 0.5);
    }
}
