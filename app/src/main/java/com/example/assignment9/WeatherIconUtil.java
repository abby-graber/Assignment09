package com.example.assignment9;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
public class WeatherIconUtil {
    public static void loadWeatherIcon(
            ImageView imageView,
            String iconCode) {
        String iconUrl =
                "https://openweathermap.org/img/wn/"
                        + iconCode + "@2x.png";
        Glide.with(imageView)
                .load(iconUrl)
                .into(imageView);
    }

}
