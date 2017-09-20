package com.example.xinyichen.pokedex;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xinyichen.pokedex.Pokedex.Pokemon;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //need and intent that tells you what pokemon you are on, an index
        //for now, just gonna use abomasnow
        int pokeIndex = 0;

        //so I can use getPokemon()
        Pokedex p = new Pokedex();

        //pokemon arraylist
        ArrayList<Pokemon> pokeList = p.getPokemon();

        //current pokemon
        final Pokemon pokemon = pokeList.get(pokeIndex);

        //picture
        ImageView Image = (ImageView) findViewById(R.id.imageView);

        //set picture with glide library
        Context context = getApplicationContext();
        Glide.with(context)
                .load("http://assets.pokemon.com/assets/cms2/img/pokedex/full/" + pokemon.number + ".png" )
                .into(Image);

        //name
        TextView name = (TextView) findViewById(R.id.name);
        //settin name text
        name.setText(pokemon.name);

        //stats
        TextView stats = (TextView) findViewById(R.id.Stats);
        //setting stats text
        stats.setText("Number : " + pokemon.number +
                "/nAttack: " + pokemon.attack +
                "/nDefense: " + pokemon.defense +
                "/nHp: " + pokemon.hp +
                "/n species: " + pokemon.species);

       //websearch button
        Button webButton = (Button) findViewById(R.id.button);



        //creating websearch onclick intent
        webButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String URL = "http://www.google.com/#q=" + pokemon.name;
                Uri uri = Uri.parse(URL);
                //websearch intent
                Intent webSearch = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(webSearch);
            }
        });

    }

    //https://tutorialwing.com/android-glide-library-tutorial-example/ glide library tutorial









}
