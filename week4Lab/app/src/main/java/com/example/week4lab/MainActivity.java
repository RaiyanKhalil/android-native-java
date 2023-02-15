package com.example.week4lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate Edit Text & Radio Buttons
        final EditText weight = (EditText) findViewById(R.id.patientWght);
        final RadioButton lbToKg = (RadioButton) findViewById(R.id.radPdToKilo);
        final RadioButton kgTolb = (RadioButton) findViewById(R.id.radKiloToPd);
    }
}