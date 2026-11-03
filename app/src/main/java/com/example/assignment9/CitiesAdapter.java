package com.example.assignment9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CitiesAdapter
        extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {

    public interface OnCityClickListener {
        void onCityClick(DataService.City city);
    }

    private ArrayList<DataService.City> cities;
    private OnCityClickListener listener;

    public CitiesAdapter(ArrayList<DataService.City> cities,
                         OnCityClickListener listener) {
        this.cities = cities;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cities, parent, false);

        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull CityViewHolder holder,
            int position) {

        DataService.City city = cities.get(position);

        holder.cityName.setText(
                city.getCity() + ", " + city.getCountry()
        );

        holder.itemView.setOnClickListener(v ->
                listener.onCityClick(city));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    static class CityViewHolder extends RecyclerView.ViewHolder {

        TextView cityName;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);

            cityName = itemView.findViewById(R.id.textViewCity);
        }
    }
}