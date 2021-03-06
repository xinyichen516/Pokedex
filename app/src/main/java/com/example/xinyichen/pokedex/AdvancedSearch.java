package com.example.xinyichen.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.ArrayList;

public class AdvancedSearch extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        String[] select_type = {"Select Type(s)", "Normal", "Water", "Fire", "Grass", "Ice", "Electric",
                "Fighting", "Poison", "Flying", "Ground", "Bug", "Psychic", "Rock", "Dark", "Ghost", "Dragon", "Steel", "Fairy"};

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        final ArrayList<SpinnerCheck> checkmarkList = new ArrayList<>();

        for (int j = 0; j < select_type.length; j++) {
            SpinnerCheck stateVO = new SpinnerCheck();
            stateVO.setTitle(select_type[j]);
            stateVO.setSelected(false);
            checkmarkList.add(stateVO);
        }
        final SpinnerAdapter myAdapter = new SpinnerAdapter(AdvancedSearch.this, 0, checkmarkList);
        spinner.setAdapter(myAdapter);

        final TextView minHealthP = (TextView) findViewById(R.id.hPointsVal);
        final TextView minAttackP = (TextView) findViewById(R.id.aPointsVal);
        final TextView minDefenseP = (TextView) findViewById(R.id.dPointsVal);

        SeekBar healthSeekBar=(SeekBar) findViewById(R.id.hPSeek);
        SeekBar attackSeekBar=(SeekBar) findViewById(R.id.aPSeek);
        SeekBar defenseSeekBar=(SeekBar) findViewById(R.id.dPSeek);// initiate the progress bar

        healthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int healthpVal = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                healthpVal = progress;
                minHealthP.setText(healthpVal + " Points");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        attackSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int attackpVal = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                attackpVal = progress;
                minAttackP.setText(attackpVal + " Points");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        defenseSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int defensepVal = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                defensepVal = progress;
                minDefenseP.setText(defensepVal + " Points");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        ImageButton startFilter = (ImageButton) findViewById(R.id.filterButton);
        startFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> types = myAdapter.getList();
                String hP = minHealthP.getText().toString().split(" ")[0];
                String aP = minAttackP.getText().toString().split(" ")[0];
                String dP = minDefenseP.getText().toString().split(" ")[0];
                Intent myIntent = new Intent(getApplicationContext(), Results.class);
                myIntent.putExtra("types", types);
                myIntent.putExtra("HP", hP);
                myIntent.putExtra("AP", aP);
                myIntent.putExtra("DP", dP);
                myIntent.putExtra("Random", "false");
                startActivity(myIntent);
            }
        });

        ImageButton randomFilter = (ImageButton) findViewById(R.id.randomButton);
        randomFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> types = null;
                Intent myIntent = new Intent(getApplicationContext(), Results.class);
                myIntent.putExtra("types", types);
                myIntent.putExtra("HP", "0");
                myIntent.putExtra("AP", "0");
                myIntent.putExtra("DP", "0");
                myIntent.putExtra("Random", "true");
                startActivity(myIntent);
            }
        });


    }

}
