package com.example.assignment9;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private WeatherService service = ApiClient.getWeatherService();

    public void getCurrentWeather(double lat, double lon, final WeatherCallback callback) {

        Call<WeatherResponse> call = service.getCurrentWeather(
                lat,
                lon,
                "imperial",
                ApiClient.API_KEY
        );

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    callback.onError("Error " + response.code());
                    return;
                }

                WeatherResponse r = response.body();
                Weather w = new Weather();

                w.setCityName(r.name);

                if (r.main != null) {
                    w.setTemp(r.main.temp);
                    w.setTempMax(r.main.tempMax);
                    w.setTempMin(r.main.tempMin);
                    w.setHumidity(r.main.humidity);
                }

                if (r.weather != null && r.weather.size() > 0) {
                    w.setDescription(r.weather.get(0).description);
                    w.setIcon(r.weather.get(0).icon);
                }

                if (r.wind != null) {
                    w.setWindSpeed(r.wind.speed);
                    w.setWindDegree(r.wind.deg);
                }

                if (r.clouds != null) {
                    w.setCloudiness(r.clouds.all);
                }

                callback.onSuccess(w);
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                callback.onError("Request failed: " + t.getMessage());
            }
        });
    }
}