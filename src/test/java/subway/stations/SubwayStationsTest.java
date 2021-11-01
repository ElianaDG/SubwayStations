package subway.stations;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubwayStationsTest {

    @Test
    public void getStations() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));

        //when
        SubwayStations stationsList = gson.fromJson(reader, SubwayStations.class);
        reader.close();

        //then
        Assertions.assertNotNull(stationsList.stations.get(0));
        Assertions.assertNotNull(stationsList.stations.get(0).geometry.coordinates.get(1));
        Assertions.assertNotNull(stationsList.stations.get(0).properties.name);
        Assertions.assertNotNull(stationsList.stations.get(0).properties.objectid);
        Assertions.assertNotNull(stationsList.stations.get(0).getCoordinates());
        Assertions.assertNotNull(stationsList.stations.get(0).getName());
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

        SubwayStations.Station station1 = stations.stations.get(416);
        SubwayStations.Station station2 = stations.stations.get(399);
        SubwayStations.Station station3 = stations.stations.get(415);

        //when
        List<SubwayStations.Station> connections = stations.getConnections(subwayLines, station1);
        List<SubwayStations.Station> expectedList = new ArrayList<>(Arrays.asList(station2, station3, station2, station3));

        //then
        Assertions.assertEquals(connections, expectedList);

    }
}
