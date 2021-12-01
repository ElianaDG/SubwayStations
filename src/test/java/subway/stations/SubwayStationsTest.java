package subway.stations;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SubwayStationsTest {

    @Test
    public void getStations() throws IOException {
        //given
        Service service = new Service();
        List<SubwayStations.Station> stations = service.stations();

        //then
        Assertions.assertNotNull(stations.get(0));
        Assertions.assertNotNull(stations.get(0).getCoordinates().get(1));
        Assertions.assertNotNull(stations.get(0).properties.name);
        Assertions.assertNotNull(stations.get(0).getObjectId());
        Assertions.assertNotNull(stations.get(0).getCoordinates());
    }

    @Test
    public void getConnections() throws IOException {
        //given
        Service service = new Service();
        List<SubwayStations.Station> stations = service.stations();

        SubwayStations.Station station1 = stations.get(416);
        SubwayStations.Station station2 = stations.get(399);
        SubwayStations.Station station3 = stations.get(415);

        //when
        List<SubwayStations.Station> actualList = station1.getConnections();
        List<SubwayStations.Station> expectedList = Arrays.asList(station2, station3, station2, station3);

        //then
        Assertions.assertEquals(actualList, expectedList);
    }

}
