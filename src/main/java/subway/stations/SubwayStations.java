package subway.stations;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SubwayStations {

    List<Feature> features;

    public static class Feature{
        Properties properties;
        Geometry geometry;

        public String getName(){return properties.name;}
        public int getObjectId(){return Integer.parseInt(properties.objectid);}
        public List<Double> getCoordinates(){return geometry.coordinates;}
    }

    public List<String> getConnections(String stationName) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

        SubwayStations stations = gson.fromJson(reader, SubwayStations.class);

        reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
        SubwayLines subwayLines = gson.fromJson(reader, SubwayLines.class);

        reader.close();

        List<String> stationNames = new ArrayList<>();

        for(int ix = 0; ix < stations.features.size(); ix++){
            stationNames.add(stations.features.get(ix).properties.name);
        }

        int stationIndex = stationNames.indexOf(stationName);
        String stationId = stations.features.get(stationIndex).properties.objectid;

        List<String> connections = new ArrayList<>();

        if(subwayLines.A.contains(stationId)){
            int stationIdIndex = subwayLines.A.indexOf(stationId);
            connections.add(subwayLines.A.get(stationIdIndex + 1));
        }
        if(subwayLines.B.contains(stationId)){
            int stationIdIndex = subwayLines.B.indexOf(stationId);
            connections.add(subwayLines.B.get(stationIdIndex + 1));
        }
        if(subwayLines.C.contains(stationId)){
            int stationIdIndex = subwayLines.C.indexOf(stationId);
            connections.add(subwayLines.C.get(stationIdIndex + 1));
        }
        if(subwayLines.D.contains(stationId)){
            int stationIdIndex = subwayLines.D.indexOf(stationId);
            connections.add(subwayLines.D.get(stationIdIndex + 1));
        }

        return connections;
    }

}

class Properties{
    String name;
    String objectid;
}

class Geometry{
    List<Double> coordinates;
}
