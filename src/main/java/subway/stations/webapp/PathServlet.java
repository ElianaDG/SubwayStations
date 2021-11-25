package subway.stations.webapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import subway.stations.ClosestStation;
import subway.stations.SubwayLines;
import subway.stations.SubwayStations;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class PathServlet extends HttpServlet {

    private final ClosestStation closestStation;
    private final SubwayStations subwayStations;
    private final SubwayLines subwayLines;
    private final Gson gson;

    public PathServlet() throws IOException {
        closestStation = new ClosestStation();
        subwayStations = new SubwayStations();
        subwayLines = new SubwayLines();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();

        double lat1 = Double.parseDouble(request.getParameter("lat1"));
        double lon1 = Double.parseDouble(request.getParameter("lon1"));
        double lat2 = Double.parseDouble(request.getParameter("lat2"));
        double lon2 = Double.parseDouble(request.getParameter("lon2"));
        List<Double> stationACoords = Arrays.asList(lat1, lon1);
        List<Double> stationBCoords = Arrays.asList(lat2, lon2);
        SubwayStations.Station origin = closestStation.getClosestStation(stationACoords, subwayStations);
        SubwayStations.Station destination = closestStation.getClosestStation(stationBCoords, subwayStations);
        List<SubwayStations.Station> shortestPath = subwayStations.dijkstrasAlgorithm(origin, destination, subwayLines);
        String json = gson.toJson(shortestPath);

        out.println(json);
    }

}
