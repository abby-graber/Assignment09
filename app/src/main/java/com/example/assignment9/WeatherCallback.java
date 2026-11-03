package com.example.assignment9;

import com.example.assignment9.models.Weather;

public interface WeatherCallback {
    void onSuccess(Weather weather);
    void onError(String message);
}