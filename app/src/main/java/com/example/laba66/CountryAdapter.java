package com.example.laba66;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private final List<Country> countryList;
    private final OnCountryClickListener listener;

    public interface OnCountryClickListener {
        void onCountryClick(Country country);
    }

    public CountryAdapter(List<Country> countryList, OnCountryClickListener listener) {
        this.countryList = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.textViewCountry.setText(country.getName());
        holder.textViewPopulation.setText("Population: " + country.getPopulation());
        holder.imageViewFlag.setImageResource(country.getFlagResId());

        holder.itemView.setOnClickListener(v -> listener.onCountryClick(country));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCountry, textViewPopulation;
        ImageView imageViewFlag;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewCountry = itemView.findViewById(R.id.textViewCountry);
            textViewPopulation = itemView.findViewById(R.id.textViewPopulation);
            imageViewFlag = itemView.findViewById(R.id.imageViewFlag);
        }
    }
}
