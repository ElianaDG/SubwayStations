package subway.stations;

import java.util.ArrayList;
import java.util.List;

public class ClosestStations {

    List<Double> currentCoordinates;
    List<Double> destinationCoordinates;

    public List<SubwayStations.Station> getClosestStations(List<Double> currentCoordinates, List<Double> destinationCoordinates, SubwayStations subwayStations){

        List<SubwayStations.Station> closestStations = new ArrayList<>();
        //get(0) is station closest to origin, get(1) is station closest to destination

        double shortestDistance = 10000;
        int closestStation = 0;

        for(int ix = 0; ix < subwayStations.stations.size(); ix++){
            double distanceFromMe = distanceFormula(currentCoordinates, subwayStations.stations.get(ix).getCoordinates());
            if(distanceFromMe < shortestDistance){
                shortestDistance = distanceFromMe;
                closestStation = ix;
            }
        }
        closestStations.add(subwayStations.stations.get(closestStation));

        shortestDistance = 10000;
        closestStation = 0;

        for(int ix = 0; ix < subwayStations.stations.size(); ix++){
            double distanceFromMe = distanceFormula(destinationCoordinates, subwayStations.stations.get(ix).getCoordinates());
            if(distanceFromMe < shortestDistance){
                shortestDistance = distanceFromMe;
                closestStation = ix;
            }
        }
        closestStations.add(subwayStations.stations.get(closestStation));

        return closestStations;
    }

    public double distanceFormula(List<Double> originCoordinates, List<Double> stationCoordinates){
        double x = stationCoordinates.get(0) - originCoordinates.get(0);
        double y = stationCoordinates.get(1) - originCoordinates.get(1);
        double xSquared = x * x;
        double ySquared = y * y;

        return Math.pow((xSquared + ySquared), 0.5);
    }
}
