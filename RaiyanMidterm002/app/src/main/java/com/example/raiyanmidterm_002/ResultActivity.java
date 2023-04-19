package com.example.raiyanmidterm_002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtV = (TextView) findViewById(R.id.resultText);
        Intent intent = getIntent();
        if (intent != null) {
            String data = intent.getStringExtra("orderDetail");
            txtV.setText(data);
        }
    }
}