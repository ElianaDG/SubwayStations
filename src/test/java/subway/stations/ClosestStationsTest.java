package subway.stations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
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
}
