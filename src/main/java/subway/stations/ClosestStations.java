package subway.stations;

import java.util.ArrayList;
import java.util.List;

public class ClosestStations {

    List<Double> currentLocation;

    public List<SubwayStations.Station> getClosestStations(List<Double> currentCoordinates, SubwayStations subwayStations){

        List<SubwayStations.Station> closestStations = new ArrayList<>();
        List<Double> shortestDistances = new ArrayList<>();
        List<Double> allDistances = new ArrayList<>();

        double distanceFromMe;

        for(int ix = 0; ix < subwayStations.stations.size(); ix++){
            distanceFromMe = distanceFormula(currentCoordinates, subwayStations.stations.get(ix).getCoordinates());
            allDistances.add(distanceFromMe);
        }
        shortestDistances.add(allDistances.get(0));
        shortestDistances.add(allDistances.get(1));
        int stationAIndex = 0;
        int stationBIndex = 0;

        for(int ix = 2; ix < allDistances.size(); ix++){

            if(allDistances.get(ix) < shortestDistances.get(0)){
                shortestDistances.set(1, shortestDistances.get(0));
                shortestDistances.set(0, allDistances.get(ix));
                stationAIndex = ix;
            }
            else if (allDistances.get(ix) < shortestDistances.get(1)){
                shortestDistances.set(1, allDistances.get(ix));
                stationBIndex = ix;
            }
            else if(allDistances.get(ix).equals(shortestDistances.get(0))){
                shortestDistances.set(1, allDistances.get(ix));
                stationBIndex = ix;
            }
        }
        closestStations.add(subwayStations.stations.get(stationAIndex));
        closestStations.add(subwayStations.stations.get(stationBIndex));

        return closestStations;
    }

    public double distanceFormula(List<Double> myCoordinates, List<Double> stationCoordinates){
        double x = stationCoordinates.get(0) - myCoordinates.get(0);
        double y = stationCoordinates.get(1) - myCoordinates.get(1);
        double xSquared = x * x;
        double ySquared = y * y;

        return Math.pow((xSquared + ySquared), 0.5);
    }
}
