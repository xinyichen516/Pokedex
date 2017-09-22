package com.example.xinyichen.pokedex;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StartScreen extends AppCompatActivity {

    private static int WELCOME_TIMEOUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(StartScreen.this, MainActivity.class);
                startActivity(welcome);
                finish();
            }
        },WELCOME_TIMEOUT);
    }

}
