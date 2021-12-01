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

public class ShortestPathTest {

    @Test
    public void distanceFormulaTest() throws IOException {
        //given
        Service service = new Service();
        List<SubwayStations.Station> stations = service.stations();
        ShortestPath shortestPath = new ShortestPath(stations);
        List<Double> aCoordinates = Arrays.asList(7.2, 5.3);
        List<Double> bCoordinates = Arrays.asList(3.5, 8.4);

        //when
        double distance = shortestPath.distanceFormula(aCoordinates, bCoordinates);

        //then
        Assertions.assertEquals(4.8270073544588685, distance);
    }

    @Test
    public void getClosestStation() throws IOException {
        //given
        Service service = new Service();
        List<SubwayStations.Station> stations = service.stations();
        ShortestPath shortestPath = new ShortestPath(stations);
        List<Double> coordinates = Arrays.asList(-73.99106999861965, 40.73005400028977);

        //when
        SubwayStations.Station actualClosestStation = shortestPath.getClosestStation(coordinates);
        SubwayStations.Station expectedClosestStation = stations.get(0);

        //then
        Assertions.assertEquals(expectedClosestStation, actualClosestStation);

    }

    @Test
    public void dijkstrasAlgorithm() throws IOException {
        //given
        Service service = new Service();
        List<SubwayStations.Station> stations = service.stations();
        ShortestPath shortestPath = new ShortestPath(stations);

        SubwayStations.Station source = stations.get(15);
        SubwayStations.Station destination = stations.get(98);
        SubwayStations.Station station1 = stations.get(182);
        SubwayStations.Station station2 = stations.get(16);

        //when
        List<SubwayStations.Station> actualPath = shortestPath.dijkstrasAlgorithm(source, destination);
        List<SubwayStations.Station> expectedPath = Arrays.asList(source, station1, station2, destination);

        //then
        Assertions.assertEquals(expectedPath, actualPath);

    }
}
