package subway.stations;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SubwayStationsTest {

    @Test
    public void getStations() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

        //when
        SubwayStations stations = gson.fromJson(reader, SubwayStations.class);
        reader.close();

        //then
        Assertions.assertNotNull(stations.features.get(0));
        Assertions.assertNotNull(stations.features.get(0).geometry.coordinates.get(1));
        Assertions.assertNotNull(stations.features.get(0).properties.name);
        Assertions.assertNotNull(stations.features.get(0).properties.objectid);
        Assertions.assertNotNull(stations.features.get(0).getCoordinates());
        Assertions.assertNotNull(stations.features.get(0).getName());
    }

    @Test
    public void getConnections() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

        SubwayStations stations = gson.fromJson(reader, SubwayStations.class);

        reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
        SubwayLines subwayLines = gson.fromJson(reader, SubwayLines.class);

        reader.close();

        //when
        List<String> connections = stations.getConnections("182nd-183rd Sts");

        //then
        Assertions.assertNotNull(connections);
        Assertions.assertEquals("263",connections.get(0));

    }
}
