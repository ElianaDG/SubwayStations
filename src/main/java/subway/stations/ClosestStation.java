package subway.stations;

import subway.stations.SubwayStations.Station;
import java.util.List;

public class ClosestStation {

    public Station getClosestStation( List<Double> coordinates, SubwayStations subwayStations){

        double shortestDistance = Double.MAX_VALUE;
        Station closestStation = null;

        for(Station station : subwayStations.stations){
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
}
