package subway.stations;

import subway.stations.SubwayStations.Station;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShortestPath {

    List<Double> currentCoordinates;
    List<Double> destinationCoordinates;
    List<Station> closestStations; //get(0) is station closest to origin, get(1) is station closest to destination

    //distance from current node to connecting node is always 1
    public List<Station> dijkstrasAlgorithm(Map map, List<Station> closestStations){
        Station originStation = closestStations.get(0);
        Station destinationStation = closestStations.get(1);
        List<StationNode> visitedStations;
        List<Station> pathList = new ArrayList<>();

        return pathList;
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
