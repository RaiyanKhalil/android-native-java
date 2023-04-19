package com.example.raiyanmidterm_002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class RaiyanShuvo extends AppCompatActivity {
    double chickenSandwich = 6.99;
    double peanutButter = 6.99;
    double cSoup = 5.99;
    double grilledCheese = 4.99;
    double milk = 0.99;
    double juice = 1.99;
    double soda = 1.35;
    double coffee = 1.35;
    String grpChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiyan_shuvo);

        CheckBox checkBox = (CheckBox) findViewById(R.id.water);
        RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton milk = (RadioButton) findViewById(R.id.milk);
        RadioButton juice = (RadioButton) findViewById(R.id.juice);
        RadioButton soda = (RadioButton) findViewById(R.id.soda);
        RadioButton coffee = (RadioButton) findViewById(R.id.coffee);
        final Spinner spinGrp = (Spinner) findViewById(R.id.spinner);
        EditText edText = (EditText) findViewById(R.id.sInstruction);
        Button cost = (Button) findViewById(R.id.orderBtn);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String spinnerText = spinGrp.getSelectedItem().toString();
//                String radText = grp.get
                String spOrder = edText.getText().toString();

                String totalVal = spinnerText + spOrder;
                Intent intent = new Intent(RaiyanShuvo.this, ResultActivity.class);
                intent.putExtra("orderDetail", totalVal);
                startActivity(intent);
            }
        });
    }
}