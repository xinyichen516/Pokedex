package com.example.xinyichen.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Question 1
        //Create a recyclerview with a linear layout

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);

        rView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Company> computerCompanies = new ArrayList<>();

        //TODO Question 2
        //add 4 companies: apple, asus, dell, and microsoft

        computerCompanies.add(new Company("Apple", 5f, R.drawable.apple));
        computerCompanies.add(new Company("Asus", 4f, R.drawable.asus));
        computerCompanies.add(new Company("Dell", 4f, R.drawable.dell));
        computerCompanies.add(new Company("Microsoft", 4.5f, R.drawable.microsoft));


        //TODO Question 3
        //set the adapter using the constructor
        RecyclerView.Adapter adapter = new CompaniesAdapter(getApplicationContext(), computerCompanies);
        rView.setAdapter(adapter);

        //TODO Question 3.5??
        //guided row_view layout


    }


}
