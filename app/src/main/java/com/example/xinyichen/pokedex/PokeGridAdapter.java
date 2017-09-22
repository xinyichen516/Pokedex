package com.example.xinyichen.pokedex;

import android.content.Context;
import android.content.Intent;
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
 * Created by kadendippe on 9/21/17.
 */

public class PokeGridAdapter extends RecyclerView.Adapter<PokeGridAdapter.CustomViewHolder>{
    Context context;
    ArrayList<Pokedex.Pokemon> pokemonList = new ArrayList<>();

    public PokeGridAdapter(Context context, ArrayList<Pokedex.Pokemon> pokemons) {
        this.context = context;
        this.pokemonList = new ArrayList<Pokedex.Pokemon>(pokemons);
    }

    void setFilter(ArrayList<Pokedex.Pokemon> pokemons) {
        ArrayList<Pokedex.Pokemon> pList = new ArrayList<>();
        pList.addAll(pokemons);
        notifyDataSetChanged();
    }

    @Override
    public PokeGridAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokeGridAdapter.CustomViewHolder holder, int position) {
        Pokedex.Pokemon pokemon = pokemonList.get(position);
        holder.pName.setText(pokemon.name);
        Glide.with(holder.pImg.getContext()).load("http://assets.pokemon.com/assets/cms2/img/pokedex/full/" + pokemon.number + ".png" ).into(holder.pImg);
        holder.pNumber.setText("#" + pokemon.number);
        holder.type.setText(pokemon.species);

        holder.pImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Profile.class);
                intent.putExtra("name", "Pikachu");
                view.getContext().startActivity(intent);
            }
        });
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