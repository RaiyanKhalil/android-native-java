package com.example.final_practise_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Raiyan300358160 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        Raiyan300358160.this,
                        MainActivity.class);
                startActivity(intent);
            }
        };

        Timer opening = new Timer();
        opening.schedule(task, 2000);
    }
}