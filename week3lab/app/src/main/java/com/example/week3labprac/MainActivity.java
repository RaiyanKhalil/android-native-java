package com.example.week3labprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicket = 82.23;
    int numberOfTickets;
    double totalCost;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tickets = (EditText) findViewById(R.id.numOfTic);
        final Spinner spinGrp = (Spinner) findViewById(R.id.textGroup);
        Button cost = (Button) findViewById(R.id.cstBtn);

        cost.setOnClickListener(new View.OnClickListener() {
            final TextView results = (TextView) findViewById(R.id.textResult);
            @Override
            public void onClick(View view) {
                // Extract value from text feild
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = costPerTicket * numberOfTickets;
                // Set Decimal Format
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                // Extract Value from Spinner
                groupChoice = spinGrp.getSelectedItem().toString();
                results.setText("Cost for " + groupChoice + " is " + currency.format(totalCost));
            }
        });
    }
}