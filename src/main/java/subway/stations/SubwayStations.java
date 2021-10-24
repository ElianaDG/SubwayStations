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
        public List<Double> getCoordinates(){return geometry.coordinates;}
    }
}

class Properties{
    String name;
    String objectid;
}

class Geometry{
    List<Double> coordinates;
}
