
package com.example.assignment9;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForecastActivity extends AppCompatActivity {

    public static final String EXTRA_CITY = "city";
    public static final String EXTRA_COUNTRY = "country";
    public static final String EXTRA_LATITUDE = "latitude";
    public static final String EXTRA_LONGITUDE = "longitude";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        setTitle("Weather Forecast");

        String city = getIntent().getStringExtra(EXTRA_CITY);
        String country = getIntent().getStringExtra(EXTRA_COUNTRY);

        double latitude = getIntent().getDoubleExtra(EXTRA_LATITUDE, 0);
        double longitude = getIntent().getDoubleExtra(EXTRA_LONGITUDE, 0);

        if (city == null) {
            city = "Unknown City";
        }

        if (country == null) {
            country = "";
        }

        TextView textViewCity = findViewById(R.id.textViewForecastCity);
        textViewCity.setText(city + ", " + country);
    }
}
