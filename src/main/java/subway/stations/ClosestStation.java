package subway.stations;

import subway.stations.SubwayStations.Station;
import java.util.ArrayList;
import java.util.List;

public class ClosestStation {

    public Station getClosestStation( List<Double> coordinates, SubwayStations subwayStations){

        Station station;

        double shortestDistance = Double.MAX_VALUE;
        int closestStation = 0;

        for(int ix = 0; ix < subwayStations.stations.size(); ix++){
            double distance = distanceFormula(coordinates, subwayStations.stations.get(ix).getCoordinates());
            if(distance < shortestDistance){
                shortestDistance = distance;
                closestStation = ix;
            }
        }
        station = subwayStations.stations.get(closestStation);

        return station;
    }

    public double distanceFormula(List<Double> fromCoordinates, List<Double> toCoordinates){
        double dx = toCoordinates.get(0) - fromCoordinates.get(0);
        double dy = toCoordinates.get(1) - fromCoordinates.get(1);
        double dxSquared = dx * dx;
        double dySquared = dy * dy;

        return Math.pow((dxSquared + dySquared), 0.5);
    }
}
