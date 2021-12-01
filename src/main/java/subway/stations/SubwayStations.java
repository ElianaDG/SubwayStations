package subway.stations;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class SubwayStations {

    @SerializedName("features")
    List<Station> stations;

    public class Station {

        List<Station> connections;
        int distanceFromSource = 0;
        Station previous;
        Properties properties;
        Geometry geometry;

        public int getObjectId() {
            return Integer.parseInt(properties.objectid);
        }

        public List<Double> getCoordinates() {
            return geometry.coordinates;
        }

        public void addConnection(Station station){
            connections.add(station);
            station.connections.add(this);
        }

        public List<Station> getConnections(){
            return connections;
        }

        public List<Station> setConnections(SubwayLines subwayLines) {

            List<Station> connections = new ArrayList<>();

            addNeighbors(subwayLines.A);
            addNeighbors(subwayLines.B);
            addNeighbors(subwayLines.C);
            addNeighbors(subwayLines.D);
            addNeighbors(subwayLines.E);
            addNeighbors(subwayLines.F);
            addNeighbors(subwayLines.G);
            addNeighbors(subwayLines.J);
            addNeighbors(subwayLines.L);
            addNeighbors(subwayLines.M);
            addNeighbors(subwayLines.N);
            addNeighbors(subwayLines.Q);
            addNeighbors(subwayLines.R);
            addNeighbors(subwayLines.W);
            addNeighbors(subwayLines.Z);
            addNeighbors(subwayLines.sevenExpress);
            addNeighbors(subwayLines.sixExpress);
            addNeighbors(subwayLines.one);
            addNeighbors(subwayLines.two);
            addNeighbors(subwayLines.three);
            addNeighbors(subwayLines.four);
            addNeighbors(subwayLines.five);
            addNeighbors(subwayLines.six);
            addNeighbors(subwayLines.seven);

            return connections;
        }

        private void addNeighbors(List<Integer> lineStationIds) {

            if (lineStationIds.contains(this.getObjectId())) {

                int stationIndex = lineStationIds.indexOf(this.getObjectId());

                if (stationIndex > 0) {
                    int previousStationId = lineStationIds.get(stationIndex - 1);
                    Station previousStation = stations.get(previousStationId - 1);
                    this.connections.add(previousStation);
                }
                if (stationIndex < lineStationIds.size() - 1) {
                    int nextStationId = lineStationIds.get(stationIndex + 1);
                    Station nextStation = stations.get(nextStationId - 1);
                    this.connections.add(nextStation);
                }
            }
        }
    }
}

class Properties {
    String name;
    String objectid;
}

class Geometry {
    List<Double> coordinates;
}

