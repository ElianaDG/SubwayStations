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
        if(subwayLines.E.contains(stationId)){
            int stationIdIndex = subwayLines.E.indexOf(stationId);
            connections.add(subwayLines.E.get(stationIdIndex + 1));
        }
        if(subwayLines.F.contains(stationId)){
            int stationIdIndex = subwayLines.F.indexOf(stationId);
            connections.add(subwayLines.F.get(stationIdIndex + 1));
        }
        if(subwayLines.G.contains(stationId)){
            int stationIdIndex = subwayLines.G.indexOf(stationId);
            connections.add(subwayLines.G.get(stationIdIndex + 1));
        }
        if(subwayLines.J.contains(stationId)){
            int stationIdIndex = subwayLines.J.indexOf(stationId);
            connections.add(subwayLines.J.get(stationIdIndex + 1));
        }
        if(subwayLines.L.contains(stationId)){
            int stationIdIndex = subwayLines.L.indexOf(stationId);
            connections.add(subwayLines.L.get(stationIdIndex + 1));
        }
        if(subwayLines.M.contains(stationId)){
            int stationIdIndex = subwayLines.M.indexOf(stationId);
            connections.add(subwayLines.M.get(stationIdIndex + 1));
        }
        if(subwayLines.N.contains(stationId)){
            int stationIdIndex = subwayLines.N.indexOf(stationId);
            connections.add(subwayLines.N.get(stationIdIndex + 1));
        }
        if(subwayLines.Q.contains(stationId)){
            int stationIdIndex = subwayLines.Q.indexOf(stationId);
            connections.add(subwayLines.Q.get(stationIdIndex + 1));
        }
        if(subwayLines.R.contains(stationId)){
            int stationIdIndex = subwayLines.R.indexOf(stationId);
            connections.add(subwayLines.R.get(stationIdIndex + 1));
        }
        if(subwayLines.S.contains(stationId)){
            int stationIdIndex = subwayLines.S.indexOf(stationId);
            connections.add(subwayLines.S.get(stationIdIndex + 1));
        }
        if(subwayLines.W.contains(stationId)){
            int stationIdIndex = subwayLines.W.indexOf(stationId);
            connections.add(subwayLines.W.get(stationIdIndex + 1));
        }
        if(subwayLines.Z.contains(stationId)){
            int stationIdIndex = subwayLines.Z.indexOf(stationId);
            connections.add(subwayLines.Z.get(stationIdIndex + 1));
        }
        if(subwayLines.sevenExpress.contains(stationId)){
            int stationIdIndex = subwayLines.sevenExpress.indexOf(stationId);
            connections.add(subwayLines.sevenExpress.get(stationIdIndex + 1));
        }
        if(subwayLines.sixExpress.contains(stationId)){
            int stationIdIndex = subwayLines.sixExpress.indexOf(stationId);
            connections.add(subwayLines.sixExpress.get(stationIdIndex + 1));
        }
        if(subwayLines.one.contains(stationId)){
            int stationIdIndex = subwayLines.one.indexOf(stationId);
            connections.add(subwayLines.one.get(stationIdIndex + 1));
        }
        if(subwayLines.two.contains(stationId)){
            int stationIdIndex = subwayLines.two.indexOf(stationId);
            connections.add(subwayLines.two.get(stationIdIndex + 1));
        }
        if(subwayLines.three.contains(stationId)){
            int stationIdIndex = subwayLines.three.indexOf(stationId);
            connections.add(subwayLines.three.get(stationIdIndex + 1));
        }
        if(subwayLines.four.contains(stationId)){
            int stationIdIndex = subwayLines.four.indexOf(stationId);
            connections.add(subwayLines.four.get(stationIdIndex + 1));
        }
        if(subwayLines.five.contains(stationId)){
            int stationIdIndex = subwayLines.five.indexOf(stationId);
            connections.add(subwayLines.five.get(stationIdIndex + 1));
        }
        if(subwayLines.six.contains(stationId)){
            int stationIdIndex = subwayLines.six.indexOf(stationId);
            connections.add(subwayLines.six.get(stationIdIndex + 1));
        }
        if(subwayLines.seven.contains(stationId)){
            int stationIdIndex = subwayLines.seven.indexOf(stationId);
            connections.add(subwayLines.seven.get(stationIdIndex + 1));
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
