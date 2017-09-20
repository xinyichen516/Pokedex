package com.example.xinyichen.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.xinyichen.pokedex.Pokedex.Pokemon;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Question 1
        //Create a recyclerview with a linear layout

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerView);

        rView.setLayoutManager(new LinearLayoutManager(this);
        Pokedex pokedex = new Pokedex();

        ArrayList<Pokedex.Pokemon> pokemonList = pokedex.getPokemon();


        //TODO Question 3
        //set the adapter using the constructor
        RecyclerView.Adapter adapter = new PokemonAdapter(getApplicationContext(), pokemonList);
        rView.setAdapter(adapter);

        //TODO Question 3.5??
        //guided row_view layout


    }


}
