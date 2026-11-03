package com.example.assignment9.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignment9.CitiesAdapter;
import com.example.assignment9.DataService;
import com.example.assignment9.R;

public class CitiesFragment extends Fragment {

    private RecyclerView recyclerView;
    private CitiesAdapter adapter;

    public CitiesFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_cities,
                container,
                false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        recyclerView =
                view.findViewById(R.id.recyclerViewCities);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

        adapter = new CitiesAdapter(
                DataService.cities,
                city -> {

                    Toast.makeText(
                            getContext(),
                            city.getCity(),
                            Toast.LENGTH_SHORT
                    ).show();

                    /*
                     Part 2 Navigation

                     Bundle bundle = new Bundle();
                     bundle.putSerializable("city", city);

                     CurrentWeatherFragment fragment =
                             new CurrentWeatherFragment();

                     fragment.setArguments(bundle);

                     requireActivity()
                             .getSupportFragmentManager()
                             .beginTransaction()
                             .replace(R.id.fragmentContainerView, fragment)
                             .addToBackStack(null)
                             .commit();
                     */
                });

        recyclerView.setAdapter(adapter);
    }
}