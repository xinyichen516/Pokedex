package com.example.xinyichen.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Set;

public class AdvancedSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
        Pokedex pokedex = new Pokedex();
        ArrayList<Pokedex.Pokemon> pokemons = pokedex.getPokemon();
        String[] select_type = {"Select Type(s)", "Normal", "Water", "Fire", "Grass", "Ice", "Electric",
                "Fighting", "Poison", "Flying", "Ground", "Bug", "Psychic", "Rock", "Dark", "Ghost", "Dragon", "Steel", "Fairy"};

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<SpinnerCheck> listVOs = new ArrayList<>();

        for (int j = 0; j < select_type.length; j++) {
            SpinnerCheck stateVO = new SpinnerCheck();
            stateVO.setTitle(select_type[j]);
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }
        SpinnerAdapter myAdapter = new SpinnerAdapter(AdvancedSearch.this, 0,
                listVOs);
        spinner.setAdapter(myAdapter);
    }


}
