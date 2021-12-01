package subway.stations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Service {

    public List<SubwayStations.Station> stations() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        InputStream in = getClass().getClassLoader().getResourceAsStream("SubwayStations.json");
        InputStreamReader reader = new InputStreamReader(in);
        SubwayStations subwayStations = gson.fromJson(reader, SubwayStations.class);
        reader.close();

        List<SubwayStations.Station> stations = subwayStations.stations;

        in = getClass().getClassLoader().getResourceAsStream("SubwayLines.json");
        reader = new InputStreamReader(in);
        SubwayLines subwayLines = gson.fromJson(reader, SubwayLines.class);

        for (SubwayStations.Station station : stations) {
            station.setConnections(subwayLines);
        }
        return stations;
    }
}
