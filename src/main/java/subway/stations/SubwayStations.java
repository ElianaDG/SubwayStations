package subway.stations;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SubwayStations {

    List<Feature> features;

    public static class Feature{
        Properties properties;
        Geometry geometry;

        public String getName(){return properties.name;}
        public int getObjectId(){return Integer.parseInt(properties.objectid);}
        //public List<String> getConnections(){return properties.connections;}
        public List<Double> getCoordinates(){return geometry.coordinates;}
    }

//    public void getStations(){
//        try {
//            Gson gson = new Gson();
//            Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
//
//            Feature feature = gson.fromJson(reader, Feature.class);
//            System.out.println(feature.properties.name);
//
//            reader.close();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

            Feature feature = gson.fromJson(reader, Feature.class);
            System.out.println(feature.properties.name);

            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Properties{
    String name;
    String objectid;
    //List<String> connections;
}

class Geometry{
    List<Double> coordinates;
}
