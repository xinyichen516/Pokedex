package com.example.xinyichen.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class AdvancedSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
        Pokedex pokedex = new Pokedex();
        ArrayList<Pokedex.Pokemon> pokemons = pokedex.getPokemon();
        ArrayList<String> select_type = new ArrayList<>();

        /* int i = 0;
        while (i < 18) {
            if (i == 0) {
                select_type.add("Select Type(s)");
                i++;
            } else if (!select_type.contains(pokemons.get(i).species)) {
                select_type.add(pokemons.get(i).species);
                i++;
            }
        } */ // Starts to bug

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<SpinnerCheck> listVOs = new ArrayList<>();

        for (int j = 0; j < select_type.size(); j++) {
            SpinnerCheck stateVO = new SpinnerCheck();
            stateVO.setTitle(select_type.get(j));
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }
        SpinnerAdapter myAdapter = new SpinnerAdapter(AdvancedSearch.this, 0,
                listVOs);
        spinner.setAdapter(myAdapter);
    }


}
