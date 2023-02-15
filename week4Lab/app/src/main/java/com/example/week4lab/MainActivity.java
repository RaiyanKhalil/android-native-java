package com.example.week4lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

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
        final TextView result = (TextView) findViewById(R.id.results);
        Button convert = (Button) findViewById(R.id.convertBtn);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if(lbToKg.isChecked()){
                    if(weightEntered <= 500){
                        convertedWeight = weightEntered / conversionRate;
                        result.setText(tenth.format(convertedWeight) + " KG");
                    } else {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                    }
                } else if (kgTolb.isChecked()){
                    if(weightEntered <= 225 ){
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " pounds");
                    } else {
                        Toast.makeText(MainActivity.this, "Kilos must be less than 225", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}