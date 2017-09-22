package com.example.xinyichen.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.xinyichen.pokedex.Pokedex.Pokemon;
import com.example.xinyichen.pokedex.Pokedex;

import java.util.ArrayList;
import java.util.Collections;


public class Results extends AppCompatActivity implements SearchView.OnQueryTextListener{

    //selects whether the layout is linear or not
    boolean linearLayout = true;
    Toolbar toolbar;
    RecyclerView rView;
    ArrayList<Pokemon> pokemonList;
    PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        ArrayList<String> types = intent.getStringArrayListExtra("types");
        String HP = intent.getStringExtra("HP");
        String AP = intent.getStringExtra("AP");
        String DP = intent.getStringExtra("DP");
        String random = intent.getStringExtra("Random");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setTitle("");
        toolbar.setSubtitle("");

        rView = (RecyclerView) findViewById(R.id.recyclerView);

        rView.setLayoutManager(new LinearLayoutManager(this));
        Pokedex pokedex = new Pokedex();


        //floating button
        FloatingActionButton layoutButton = (FloatingActionButton) findViewById(R.id.fButton);

        //change the layout and icon when the button is clicked
        layoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(linearLayout){
                    rView.setLayoutManager(new LinearLayoutManager(Results.this));
                    linearLayout = false;
                } else{
                    rView.setLayoutManager(new GridLayoutManager(Results.this, 2));
                    linearLayout = true;
                }

            }
        });

        pokemonList = pokedex.getPokemon();

        pokemonList = filterPokemons(pokemonList, types, HP, AP, DP, random);


        adapter = new PokemonAdapter(getApplicationContext(), pokemonList);
        rView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
        for (Pokemon p : pokemonList) {
            String name = p.name.toLowerCase();
            if (name.contains(newText)) {
                pokemonArrayList.add(p);
            }
        }
        adapter.setFilter(pokemonArrayList);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.filterButton:
                Intent intent = new Intent(getApplicationContext(), AdvancedSearch.class);
                startActivity(intent);

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public ArrayList<Pokemon> filterPokemons (ArrayList<Pokemon> pokeList, ArrayList<String> typeList, String HP, String AP, String DP, String random) {
        ArrayList<Pokemon> results = new ArrayList<>();
        int health = Integer.parseInt(HP);
        int attack = Integer.parseInt(AP);
        int defense = Integer.parseInt(DP);
        if (random.equals("true")) {
            Collections.shuffle(pokemonList);
            for (int i = 0; i < 20; i++) {
                results.add(pokemonList.get(i));
            } return results;
        }
        for (int i = 0; i < pokeList.size(); i++){
            Pokemon currPokemon = pokeList.get(i);
            if (typeList == null) {
                if (Integer.parseInt(currPokemon.hp) >= health && Integer.parseInt(currPokemon.attack) > attack && Integer.parseInt(currPokemon.defense) >= defense) {
                    results.add(currPokemon);
                }
            } else {
                for (String type:currPokemon.types) {
                    for (String listTypes : typeList) {
                        if (listTypes.equals(type) && Integer.parseInt(currPokemon.hp) >= health && Integer.parseInt(currPokemon.attack) > attack && Integer.parseInt(currPokemon.defense) >= defense) {
                            results.add(currPokemon);
                        }
                    }
                }
            }
        }
        return results;
    }
}