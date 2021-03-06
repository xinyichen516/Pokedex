package com.example.xinyichen.pokedex;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.xinyichen.pokedex.Pokedex.Pokemon;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements android.support.v7.widget.SearchView.OnQueryTextListener{

    //selects whether the layout is linear or not
    boolean linearLayout = true;
    Toolbar toolbar;
    RecyclerView rView;
    ArrayList<Pokedex.Pokemon> pokemonList;
    PokemonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setTitle("");
        toolbar.setSubtitle("");

        rView = (RecyclerView) findViewById(R.id.recyclerView);

        rView.setLayoutManager(new LinearLayoutManager(this));
        Pokedex pokedex = new Pokedex();

        //floating button
        final FloatingActionButton layoutButton = (FloatingActionButton) findViewById(R.id.fButton);

        //change the layout and icon when the button is clicked
        layoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(linearLayout){
                    rView.setAdapter(new PokeGridAdapter(getApplicationContext(), pokemonList));
                    rView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                    linearLayout = false;
                    layoutButton.setImageResource(R.drawable.ic_list);

                } else{
                    rView.setAdapter(new PokemonAdapter(getApplicationContext(), pokemonList));
                    rView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    linearLayout = true;
                    layoutButton.setImageResource(R.drawable.ic_dashboard);
                }

            }
        });

        pokemonList = pokedex.getPokemon();

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
}
