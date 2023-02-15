package com.example.week6lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ImageAdapter.ItemClickListener {

    Integer[] animals = {R.drawable.eagle, R.drawable.elephant,
            R.drawable.gorilla, R.drawable.panda, R.drawable.polar
    };
    ImageView pic;
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pic = (ImageView) findViewById(R.id.imgLarge);
        RecyclerView recyclerView = findViewById(R.id.recycleView);

        int numOfColum = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numOfColum));
        adapter = new ImageAdapter(this, animals);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getBaseContext(), "Selected Species" + (position + 1), Toast.LENGTH_SHORT).show();
        pic.setImageResource(adapter.getmData(position));
    }
}