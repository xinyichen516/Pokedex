package com.example.xinyichen.pokedex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

/**
 * Created by xinyichen on 9/19/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.CustomViewHolder>{
    Context context;
    ArrayList<Pokedex.Pokemon> pokemonList = new ArrayList<>();

    public PokemonAdapter(Context context, ArrayList<Pokedex.Pokemon> pokemons) {
        this.context = context;
        this.pokemonList = new ArrayList<Pokedex.Pokemon>(pokemons);
    }

    void setFilter(ArrayList<Pokedex.Pokemon> pokemons) {
        ArrayList<Pokedex.Pokemon> pList = new ArrayList<>();
        pList.addAll(pokemons);
        notifyDataSetChanged();
    }

    @Override
    public PokemonAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_result, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Pokedex.Pokemon pokemon = pokemonList.get(position);
        holder.pName.setText(pokemon.name);
        Glide.with(holder.pImg.getContext()).load("http://assets.pokemon.com/assets/cms2/img/pokedex/full/" + pokemon.number + ".png" ).into(holder.pImg);
        holder.pNumber.setText("#" + pokemon.number);
        holder.type.setText(pokemon.species);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView pNumber;
        ImageView pImg;
        TextView pName;
        TextView type;

        CustomViewHolder(View view) {
            super(view);
            this.pName = (TextView) view.findViewById(R.id.pokemonName);
            this.pNumber = (TextView) view.findViewById(R.id.pokemonNumber);
            this.pImg = (ImageView) view.findViewById(R.id.pokemonImage);
            this.type = (TextView) view.findViewById(R.id.pType);
        }

    }
}
