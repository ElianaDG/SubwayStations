package subway.stations;

import java.util.List;

public class StationNode {

    private final List<StationNode> adjacentStations;
    private int distanceFromOrigin;
    private List<StationNode> visitedStations;

    public StationNode(List<StationNode> adjacentStations) {
        this.adjacentStations = adjacentStations;
    }

    public List<StationNode> getAdjacentStations() {
        return adjacentStations;
    }

    public void setAdjacentStations(List<StationNode> stationConnections){
        adjacentStations.addAll(stationConnections);
    }

}
