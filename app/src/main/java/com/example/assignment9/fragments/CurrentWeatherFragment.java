package com.example.assignment9.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment9.DataService;
import com.example.assignment9.R;

public class CurrentWeatherFragment extends Fragment {

    private DataService.City city;

    private TextView tvCityName;
    private TextView tvTemperature;
    private TextView tvTempMax;
    private TextView tvTempMin;
    private TextView tvDescription;
    private TextView tvHumidity;
    private TextView tvWindSpeed;
    private TextView tvWindDegree;
    private TextView tvCloudiness;

    private ImageView weatherIcon;
    private ProgressBar progressBar;
    private TextView tvError;

    private Button buttonBack;
    private Button buttonForecast;

    public CurrentWeatherFragment() {
        // Required empty constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            city = (DataService.City)
                    getArguments().getSerializable(
                            CitiesFragment.CITY_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_current_weather,
                container,
                false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        tvCityName = view.findViewById(R.id.tvCityName);
        tvTemperature = view.findViewById(R.id.tvTemperature);
        tvTempMax = view.findViewById(R.id.tvTempMax);
        tvTempMin = view.findViewById(R.id.tvTempMin);
        tvDescription = view.findViewById(R.id.tvDescription);
        tvHumidity = view.findViewById(R.id.tvHumidity);
        tvWindSpeed = view.findViewById(R.id.tvWindSpeed);
        tvWindDegree = view.findViewById(R.id.tvWindDegree);
        tvCloudiness = view.findViewById(R.id.tvCloudiness);

        weatherIcon = view.findViewById(R.id.weatherIcon);

        progressBar = view.findViewById(R.id.progressBar);
        tvError = view.findViewById(R.id.tvError);

        buttonBack = view.findViewById(R.id.buttonBack);
        buttonForecast = view.findViewById(R.id.buttonForecast);

        if (city != null) {

            tvCityName.setText(
                    city.getCity() + ", " + city.getCountry()
            );

            // Temporary placeholder values
            // Replace with API data in Part 2

            tvTemperature.setText("--");
            tvTempMax.setText("--");
            tvTempMin.setText("--");
            tvDescription.setText("--");
            tvHumidity.setText("--");
            tvWindSpeed.setText("--");
            tvWindDegree.setText("--");
            tvCloudiness.setText("--");

        } else {

            showError("City information not found.");
        }

        buttonBack.setOnClickListener(v ->
                requireActivity()
                        .getSupportFragmentManager()
                        .popBackStack());

        buttonForecast.setOnClickListener(v -> {

            // Part 3
            // Open ForecastFragment here

        });
    }

    private void showLoading() {

        progressBar.setVisibility(View.VISIBLE);
        tvError.setVisibility(View.GONE);
    }

    private void hideLoading() {

        progressBar.setVisibility(View.GONE);
    }

    private void showError(String message) {

        progressBar.setVisibility(View.GONE);

        tvError.setText(message);

        tvError.setVisibility(View.VISIBLE);
    }
}