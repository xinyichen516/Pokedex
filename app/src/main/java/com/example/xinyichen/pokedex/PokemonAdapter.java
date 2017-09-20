package com.example.xinyichen.pokedex;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by xinyichen on 9/19/17.
 */

public class PokemonAdapter {
    Context context;
    ArrayList<Pokedex.Pokemon> pokemonList = new ArrayList<>();
    Pokedex pokedex = new Pokedex();

    public CompaniesAdapter(Context context, ArrayList<Pokedex.Pokemon> companies) {
        this.context = context;
        this.companiesList = new ArrayList<Company>(companies);
    }
}
