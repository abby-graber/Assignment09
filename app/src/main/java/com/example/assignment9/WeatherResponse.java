package com.example.assignment9;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {

    @SerializedName("name")
    public String name;

    @SerializedName("main")
    public Main main;

    @SerializedName("weather")
    public List<WeatherInfo> weather;

    @SerializedName("wind")
    public Wind wind;

    @SerializedName("clouds")
    public Clouds clouds;

    public static class Main {
        @SerializedName("temp")
        public double temp;
        @SerializedName("temp_max")
        public double tempMax;
        @SerializedName("temp_min")
        public double tempMin;
        @SerializedName("humidity")
        public int humidity;
    }

    public static class WeatherInfo {
        @SerializedName("description")
        public String description;
        @SerializedName("icon")
        public String icon;
    }

    public static class Wind {
        @SerializedName("speed")
        public double speed;
        @SerializedName("deg")
        public double deg;
    }

    public static class Clouds {
        @SerializedName("all")
        public int all;
    }
}