package com.example.assignment9;

public interface WeatherCallback {
    void onSuccess(Weather weather);
    void onError(String message);
}