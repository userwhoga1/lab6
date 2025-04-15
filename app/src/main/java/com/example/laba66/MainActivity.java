package com.example.laba66;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("Vietnam", "98,000,000", R.drawable.vn));
        countryList.add(new Country("United States", "320,000,000", R.drawable.usa));
        countryList.add(new Country("Russia", "142,000,000", R.drawable.russia));

        CountryAdapter adapter = new CountryAdapter(countryList, country -> {
            String message = "Selected: " + country.getName() + " (Population: " + country.getPopulation() + ")";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();


        });



        recyclerView.setAdapter(adapter);
    }
}
