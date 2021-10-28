package subway.stations;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubwayLines {

    List<Integer> A, B, C, D, E, F, G, J, L, M, N, Q, R, S, W, Z;
    @SerializedName("7 Express")
    List<Integer> sevenExpress;
    @SerializedName("6 Express")
    List<Integer> sixExpress;
    @SerializedName("1")
    List<Integer> one;
    @SerializedName("2")
    List<Integer> two;
    @SerializedName("3")
    List<Integer> three;
    @SerializedName("4")
    List<Integer> four;
    @SerializedName("5")
    List<Integer> five;
    @SerializedName("6")
    List<Integer> six;
    @SerializedName("7")
    List<Integer> seven;

}
