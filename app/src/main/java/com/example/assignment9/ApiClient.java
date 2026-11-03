package com.example.assignment9;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://api.openweathermap.org/";
    public static final String API_KEY = "ac717cf7f1536a82e65f6924bb32cf3f";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static WeatherService getWeatherService() {
        return getClient().create(WeatherService.class);
    }
}