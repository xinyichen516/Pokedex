package com.example.xinyichen.pokedex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xinyichen on 9/19/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.CustomViewHolder>{
    Context context;
    ArrayList<Pokedex.Pokemon> pokemonList = new ArrayList<>();
    Pokedex pokedex = new Pokedex();

    public PokedexAdapter(Context context, ArrayList<Pokedex.Pokemon> companies) {
        this.context = context;
        this.companiesList = new ArrayList<Company>(companies);
    }

    @Override
    public CompaniesAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_views, parent, false);
        return new CustomViewHolder(view);
    }
    //TODO Question 6
    //Bind the data to the holder based on the position

    /* YOUR CODE HERE */

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Company company = companiesList.get(position);
        holder.name.setText(company.companyName);
        holder.img.setImageResource(company.imageResId);
        holder.rating.setRating(company.likeCompany);
            /*@Override
            public void onClick(View v) {
            Intent intent = new INtent(context, MainActivity.class);
            Intent.putExtra(Name)
            }*/
    }


    //TODO Question 7
    //Override the item size method

    @Override
    public int getItemCount() {
        return companiesList.size();
    }

    //TODO Question 8
    //Create a CustomViewHolder class that extends the base RecyclerView.ViewHolder
    //Override its constructor class with the following signature:
    //CustomViewHolder(View view) {
    //    super(view);
    //    ...
    //}
    //and create instance variables for the UI elements in the layout file
    //Hint: findViewById is a method of the View class

    /* YOUR CODE HERE */

    class CustomViewHolder extends RecyclerView.ViewHolder {

        RatingBar rating;
        ImageView img;
        TextView name;

        CustomViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.companyName);
            this.rating = (RatingBar) view.findViewById(R.id.companyRating);
            this.img = (ImageView) view.findViewById(R.id.companyPic);
        }

    }
}
