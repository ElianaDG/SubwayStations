package subway.stations;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SubwayStations {

    @SerializedName("features")
    List<Station> stations;

    public static class Station {
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

    public List<String> getConnections(String stationName) throws IOException {
        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
        SubwayLines subwayLines = gson.fromJson(reader, SubwayLines.class);

        reader.close();

        List<String> stationNames = new ArrayList<>();

        for (Station station : stations) {
            stationNames.add(station.properties.name);
        }

        int stationIndex = stationNames.indexOf(stationName);
        String stationId = stations.get(stationIndex).properties.objectid;

        List<String> connections = new ArrayList<>();

        addNeighbors(stationId, connections, subwayLines.A);
        addNeighbors(stationId, connections, subwayLines.B);
        addNeighbors(stationId, connections, subwayLines.C);
        addNeighbors(stationId, connections, subwayLines.D);
        addNeighbors(stationId, connections, subwayLines.E);
        addNeighbors(stationId, connections, subwayLines.F);
        addNeighbors(stationId, connections, subwayLines.G);
        addNeighbors(stationId, connections, subwayLines.J);
        addNeighbors(stationId, connections, subwayLines.L);
        addNeighbors(stationId, connections, subwayLines.M);
        addNeighbors(stationId, connections, subwayLines.N);
        addNeighbors(stationId, connections, subwayLines.Q);
        addNeighbors(stationId, connections, subwayLines.R);
        addNeighbors(stationId, connections, subwayLines.S);
        addNeighbors(stationId, connections, subwayLines.W);
        addNeighbors(stationId, connections, subwayLines.Z);
        addNeighbors(stationId, connections, subwayLines.sevenExpress);
        addNeighbors(stationId, connections, subwayLines.sixExpress);
        addNeighbors(stationId, connections, subwayLines.one);
        addNeighbors(stationId, connections, subwayLines.two);
        addNeighbors(stationId, connections, subwayLines.three);
        addNeighbors(stationId, connections, subwayLines.four);
        addNeighbors(stationId, connections, subwayLines.five);
        addNeighbors(stationId, connections, subwayLines.six);
        addNeighbors(stationId, connections, subwayLines.seven);

        return connections;
    }

    private void addNeighbors(String stationId, List<String> connections, List<String> a) {
        if (a.contains(stationId)) {
            int stationIdIndex = a.indexOf(stationId);
            if (stationIdIndex < a.size() - 1) {
                connections.add(a.get(stationIdIndex + 1));
            }
            if (stationIdIndex > 0) {
                connections.add(a.get(stationIdIndex - 1));
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
