package subway.stations;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubwayLines {

    List<String> A, B, C, D, E, F, G, J, L, M, N, Q, R, S, W, Z;
    @SerializedName("7 Express")
    List<String> sevenExpress;
    @SerializedName("6 Express")
    List<String> sixExpress;
    @SerializedName("1")
    List<String> one;
    @SerializedName("2")
    List<String> two;
    @SerializedName("3")
    List<String> three;
    @SerializedName("4")
    List<String> four;
    @SerializedName("5")
    List<String> five;
    @SerializedName("6")
    List<String> six;
    @SerializedName("7")
    List<String> seven;

}
