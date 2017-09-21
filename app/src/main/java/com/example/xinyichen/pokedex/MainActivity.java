package com.example.xinyichen.pokedex;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.xinyichen.pokedex.Pokedex.Pokemon;

import java.util.ArrayList;

import static com.example.xinyichen.pokedex.R.id.fButton;


public class MainActivity extends AppCompatActivity {

    //selects wether the layout is linear or not
    static boolean linearLayout = true;

    RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        rView = (RecyclerView) findViewById(R.id.recyclerView);

        rView.setLayoutManager(new LinearLayoutManager(this));
        Pokedex pokedex = new Pokedex();

        //floating button
        FloatingActionButton layoutButton = (FloatingActionButton) findViewById(R.id.fButton);

        //change the layout and icon when the button is clicked
        layoutButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {
                if(linearLayout){
                    rView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    linearLayout = false;
                } else{
                    rView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                    linearLayout = true;
                }

            }
        });




        ArrayList<Pokedex.Pokemon> pokemonList = pokedex.getPokemon();


        //TODO Question 3
        //set the adapter using the constructor
        RecyclerView.Adapter adapter = new PokemonAdapter(getApplicationContext(), pokemonList);
        rView.setAdapter(adapter);

        //TODO Question 3.5??
        //guided row_view layout


    }


}
