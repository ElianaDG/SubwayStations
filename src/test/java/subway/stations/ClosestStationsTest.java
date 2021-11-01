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

public class ClosestStationsTest {

    @Test
    public void distanceFormulaTest(){
        //given
        ClosestStations closestStations = new ClosestStations();
        closestStations.currentLocation = new ArrayList<>(Arrays.asList(7.2, 5.3));
        List<Double> bCoordinates = new ArrayList<>(Arrays.asList(3.5, 8.4));

        //when
        double distance = closestStations.distanceFormula(closestStations.currentLocation, bCoordinates);

        //then
        Assertions.assertEquals(4.8270073544588685, distance);
    }

    @Test
    public void getClosestStationsTest() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
        SubwayStations stationsList = gson.fromJson(reader, SubwayStations.class);
        reader.close();
        ClosestStations closestStations = new ClosestStations();
        closestStations.currentLocation = new ArrayList<>(Arrays.asList(-73.99106999861965, 40.73005400028977));

        //when
        List<SubwayStations.Station> actualClosestStations = closestStations.getClosestStations(closestStations.currentLocation, stationsList);
        List<SubwayStations.Station> expectedClosestStations = new ArrayList<>(Arrays.asList(
           stationsList.stations.get(0), stationsList.stations.get(400)
        ));

        //then
        Assertions.assertEquals(expectedClosestStations, actualClosestStations);

    }
}
