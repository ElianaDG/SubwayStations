package subway.stations;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SubwayStations {

    List<Station> stations;

    public static class Station {
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

        for(int ix = 0; ix < stations.stations.size(); ix++){
            stationNames.add(stations.stations.get(ix).properties.name);
        }

        int stationIndex = stationNames.indexOf(stationName);
        String stationId = stations.stations.get(stationIndex).properties.objectid;

        List<String> connections = new ArrayList<>();

        if(subwayLines.A.contains(stationId)){
            int stationIdIndex = subwayLines.A.indexOf(stationId);
            if(stationIdIndex < subwayLines.A.size() - 1){
                connections.add(subwayLines.A.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.A.get(stationIdIndex - 1));
            }
        }
        if(subwayLines.B.contains(stationId)){
            int stationIdIndex = subwayLines.B.indexOf(stationId);
            if(stationIdIndex < subwayLines.B.size() - 1){
                connections.add(subwayLines.B.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.B.get(stationIdIndex - 1));
            }
        }
        if(subwayLines.C.contains(stationId)){
            int stationIdIndex = subwayLines.C.indexOf(stationId);
            if(stationIdIndex < subwayLines.C.size() - 1){
                connections.add(subwayLines.C.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.C.get(stationIdIndex - 1));
            }        }
        if(subwayLines.D.contains(stationId)){
            int stationIdIndex = subwayLines.D.indexOf(stationId);
            if(stationIdIndex < subwayLines.D.size() - 1){
                connections.add(subwayLines.D.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.D.get(stationIdIndex - 1));
            }        }
        if(subwayLines.E.contains(stationId)){
            int stationIdIndex = subwayLines.E.indexOf(stationId);
            if(stationIdIndex < subwayLines.E.size() - 1){
                connections.add(subwayLines.E.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.E.get(stationIdIndex - 1));
            }        }
        if(subwayLines.F.contains(stationId)){
            int stationIdIndex = subwayLines.F.indexOf(stationId);
            if(stationIdIndex < subwayLines.F.size() - 1){
                connections.add(subwayLines.F.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.F.get(stationIdIndex - 1));
            }        }
        if(subwayLines.G.contains(stationId)){
            int stationIdIndex = subwayLines.G.indexOf(stationId);
            if(stationIdIndex < subwayLines.G.size() - 1){
                connections.add(subwayLines.G.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.G.get(stationIdIndex - 1));
            }        }
        if(subwayLines.J.contains(stationId)){
            int stationIdIndex = subwayLines.J.indexOf(stationId);
            if(stationIdIndex < subwayLines.J.size() - 1){
                connections.add(subwayLines.J.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.J.get(stationIdIndex - 1));
            }        }
        if(subwayLines.L.contains(stationId)){
            int stationIdIndex = subwayLines.L.indexOf(stationId);
            if(stationIdIndex < subwayLines.L.size() - 1){
                connections.add(subwayLines.L.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.L.get(stationIdIndex - 1));
            }        }
        if(subwayLines.M.contains(stationId)){
            int stationIdIndex = subwayLines.M.indexOf(stationId);
            if(stationIdIndex < subwayLines.M.size() - 1){
                connections.add(subwayLines.M.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.M.get(stationIdIndex - 1));
            }        }
        if(subwayLines.N.contains(stationId)){
            int stationIdIndex = subwayLines.N.indexOf(stationId);
            if(stationIdIndex < subwayLines.N.size() - 1){
                connections.add(subwayLines.N.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.N.get(stationIdIndex - 1));
            }        }
        if(subwayLines.Q.contains(stationId)){
            int stationIdIndex = subwayLines.Q.indexOf(stationId);
            if(stationIdIndex < subwayLines.Q.size() - 1){
                connections.add(subwayLines.Q.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.Q.get(stationIdIndex - 1));
            }        }
        if(subwayLines.R.contains(stationId)){
            int stationIdIndex = subwayLines.R.indexOf(stationId);
            if(stationIdIndex < subwayLines.R.size() - 1){
                connections.add(subwayLines.R.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.R.get(stationIdIndex - 1));
            }        }
        if(subwayLines.S.contains(stationId)){
            int stationIdIndex = subwayLines.S.indexOf(stationId);
            if(stationIdIndex < subwayLines.S.size() - 1){
                connections.add(subwayLines.S.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.S.get(stationIdIndex - 1));
            }        }
        if(subwayLines.W.contains(stationId)){
            int stationIdIndex = subwayLines.W.indexOf(stationId);
            if(stationIdIndex < subwayLines.W.size() - 1){
                connections.add(subwayLines.W.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.W.get(stationIdIndex - 1));
            }        }
        if(subwayLines.Z.contains(stationId)){
            int stationIdIndex = subwayLines.Z.indexOf(stationId);
            if(stationIdIndex < subwayLines.Z.size() - 1){
                connections.add(subwayLines.Z.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.Z.get(stationIdIndex - 1));
            }        }
        if(subwayLines.sevenExpress.contains(stationId)){
            int stationIdIndex = subwayLines.sevenExpress.indexOf(stationId);
            if(stationIdIndex < subwayLines.sevenExpress.size() - 1){
                connections.add(subwayLines.sevenExpress.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.sevenExpress.get(stationIdIndex - 1));
            }        }
        if(subwayLines.sixExpress.contains(stationId)){
            int stationIdIndex = subwayLines.sixExpress.indexOf(stationId);
            if(stationIdIndex < subwayLines.sixExpress.size() - 1){
                connections.add(subwayLines.sixExpress.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.sixExpress.get(stationIdIndex - 1));
            }        }
        if(subwayLines.one.contains(stationId)){
            int stationIdIndex = subwayLines.one.indexOf(stationId);
            if(stationIdIndex < subwayLines.one.size() - 1){
                    connections.add(subwayLines.one.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.one.get(stationIdIndex - 1));
            }        }
        if(subwayLines.two.contains(stationId)){
            int stationIdIndex = subwayLines.two.indexOf(stationId);
            if(stationIdIndex < subwayLines.two.size() - 1){
                connections.add(subwayLines.two.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.two.get(stationIdIndex - 1));
            }        }
        if(subwayLines.three.contains(stationId)){
            int stationIdIndex = subwayLines.three.indexOf(stationId);
            if(stationIdIndex < subwayLines.three.size() - 1){
                connections.add(subwayLines.three.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.three.get(stationIdIndex - 1));
            }        }
        if(subwayLines.four.contains(stationId)){
            int stationIdIndex = subwayLines.four.indexOf(stationId);
            if(stationIdIndex < subwayLines.four.size() - 1){
                connections.add(subwayLines.four.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.four.get(stationIdIndex - 1));
            }        }
        if(subwayLines.five.contains(stationId)){
            int stationIdIndex = subwayLines.five.indexOf(stationId);
            if(stationIdIndex < subwayLines.five.size() - 1){
                connections.add(subwayLines.five.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.five.get(stationIdIndex - 1));
            }        }
        if(subwayLines.six.contains(stationId)){
            int stationIdIndex = subwayLines.six.indexOf(stationId);
            if(stationIdIndex < subwayLines.six.size() - 1){
                connections.add(subwayLines.six.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.six.get(stationIdIndex - 1));
            }        }
        if(subwayLines.seven.contains(stationId)){
            int stationIdIndex = subwayLines.seven.indexOf(stationId);
            if(stationIdIndex < subwayLines.seven.size() - 1){
                connections.add(subwayLines.seven.get(stationIdIndex + 1));
            }
            if(stationIdIndex > 0){
                connections.add(subwayLines.seven.get(stationIdIndex - 1));
            }        }

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
