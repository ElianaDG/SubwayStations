package subway.stations;

import java.util.ArrayList;
import java.util.List;

public class ClosestStations {

    List<Double> currentCoordinates;
    List<Double> destinationCoordinates;

    public List<SubwayStations.Station> getClosestStations(List<Double> currentCoordinates, List<Double> destinationCoordinates, SubwayStations subwayStations){

        List<SubwayStations.Station> closestStations = new ArrayList<>();
        //get(0) is station closest to origin, get(1) is station closest to destination

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

    public double distanceFormula(List<Double> xCoordinates, List<Double> yCoordinates){
        double x = yCoordinates.get(0) - xCoordinates.get(0);
        double y = yCoordinates.get(1) - xCoordinates.get(1);
        double xSquared = x * x;
        double ySquared = y * y;

        return Math.pow((xSquared + ySquared), 0.5);
    }
}
