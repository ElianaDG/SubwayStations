package subway.stations.webapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import subway.stations.Service;
import subway.stations.ShortestPath;
import subway.stations.SubwayStations;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class PathServlet extends HttpServlet {

    private final Gson gson;
    private final Service service;
    private final List<SubwayStations.Station> stations;
    private final ShortestPath shortestPath;

    public PathServlet() throws IOException {
        service = new Service();
        stations = service.stations();
        shortestPath = new ShortestPath(stations);
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
        SubwayStations.Station origin = shortestPath.getClosestStation(stationACoords);
        SubwayStations.Station destination = shortestPath.getClosestStation(stationBCoords);
        List<SubwayStations.Station> path = shortestPath.dijkstrasAlgorithm(origin, destination);
        String json = gson.toJson(path);

        out.println(json);
    }

}
