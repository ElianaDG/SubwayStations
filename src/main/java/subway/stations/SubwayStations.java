package subway.stations;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class SubwayStations {

    @SerializedName("features")
    List<Station> stations;

    public static class Station {

        List<Station> connections;
        int distanceFromSource = 0;
        Station previous;
        Properties properties;
        Geometry geometry;

        public String getName() {
            return properties.name;
        }

        public int getObjectId() {
            return Integer.parseInt(properties.objectid);
        }

        public List<Double> getCoordinates() {
            return geometry.coordinates;
        }
    }

    public List<Station> dijkstrasAlgorithm(Station source, Station destination) {

        Set<Station> unvisitedStations = new HashSet<>();

        Station currentSource = source;
        int shortestDistance = Integer.MAX_VALUE;

        while (!(currentSource.connections.contains(destination))) {
            unvisitedStations.addAll(currentSource.connections);

            for (Station station : currentSource.connections) {
                station.distanceFromSource = currentSource.distanceFromSource + 1;
                int thisDistance = station.distanceFromSource;
                if (thisDistance < shortestDistance) {
                    shortestDistance = thisDistance;
                    station.previous = currentSource;
                }
            }

            for (Station station : unvisitedStations) {
                int thisDistance = station.distanceFromSource;
                if (thisDistance == shortestDistance) {
                    currentSource = station;
                }
                if (thisDistance < shortestDistance) {
                    shortestDistance = thisDistance;
                    currentSource = station;
                }
            }
            unvisitedStations.remove(currentSource);
        }

        List<Station> path = new ArrayList<>();
        path.add(destination);

        List<Station> destinationConnections = destination.connections;
        Station lastStationInPath = destination;

        for (Station station : destinationConnections) {
            if (station.distanceFromSource == shortestDistance) {
                lastStationInPath = station;
            }
        }

        reversePath(source, path, lastStationInPath);

        return path;
    }

    private void reversePath(Station source, List<Station> path, Station lastStationInPath) {
        Station currentStation = lastStationInPath;
        path.add(currentStation);

        while (!(currentStation.equals(source))) {
            currentStation = currentStation.previous;
            path.add(currentStation);
        }

        path.add(source);

        Collections.reverse(path);
    }

    public List<Station> getConnections(SubwayLines subwayLines, Station station) {

        List<Station> connections = new ArrayList<>();

        addNeighbors(station, connections, subwayLines.A);
        addNeighbors(station, connections, subwayLines.B);
        addNeighbors(station, connections, subwayLines.C);
        addNeighbors(station, connections, subwayLines.D);
        addNeighbors(station, connections, subwayLines.E);
        addNeighbors(station, connections, subwayLines.F);
        addNeighbors(station, connections, subwayLines.G);
        addNeighbors(station, connections, subwayLines.J);
        addNeighbors(station, connections, subwayLines.L);
        addNeighbors(station, connections, subwayLines.M);
        addNeighbors(station, connections, subwayLines.N);
        addNeighbors(station, connections, subwayLines.Q);
        addNeighbors(station, connections, subwayLines.R);
        addNeighbors(station, connections, subwayLines.S);
        addNeighbors(station, connections, subwayLines.W);
        addNeighbors(station, connections, subwayLines.Z);
        addNeighbors(station, connections, subwayLines.sevenExpress);
        addNeighbors(station, connections, subwayLines.sixExpress);
        addNeighbors(station, connections, subwayLines.one);
        addNeighbors(station, connections, subwayLines.two);
        addNeighbors(station, connections, subwayLines.three);
        addNeighbors(station, connections, subwayLines.four);
        addNeighbors(station, connections, subwayLines.five);
        addNeighbors(station, connections, subwayLines.six);
        addNeighbors(station, connections, subwayLines.seven);

        return connections;
    }

    private void addNeighbors(Station station, List<Station> connections, List<Integer> lineStationIds) {

        if (lineStationIds.contains(station.getObjectId())) {

            int stationIndex = lineStationIds.indexOf(station.getObjectId());

            if (stationIndex > 0) {
                int previousStationId = lineStationIds.get(stationIndex - 1);
                Station previousStation = stations.get(previousStationId - 1);
                connections.add(previousStation);
            }
            if (stationIndex < lineStationIds.size() - 1) {
                int nextStationId = lineStationIds.get(stationIndex + 1);
                Station nextStation = stations.get(nextStationId - 1);
                connections.add(nextStation);
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
