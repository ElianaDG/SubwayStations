package subway.stations;

import java.util.List;

public class StationNode {

    private final List<StationNode> adjacentStations;
    private int distanceFromOrigin;

    public StationNode(List<StationNode> adjacentStations, int distanceFromOrigin) {
        this.adjacentStations = adjacentStations;
        this.distanceFromOrigin = distanceFromOrigin;
    }

    public List<StationNode> getAdjacentStations() {
        return adjacentStations;
    }

    public void setAdjacentStations(List<StationNode> stationConnections){
        adjacentStations.addAll(stationConnections);
    }

}
