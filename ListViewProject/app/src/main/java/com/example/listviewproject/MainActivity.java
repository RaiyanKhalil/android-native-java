package com.example.listviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String[] attractions = {"Canada Place","Capilano","Stanley"};
    int[] images = {R.drawable.canadaplace,R.drawable.capilano,
            R.drawable.stanley};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String,String>> aList =
                new ArrayList<HashMap<String,String>>();

        for(int i=0;i<attractions.length;i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("txt",attractions[i]);
            hashMap.put("images",Integer.toString(images[i]));
            aList.add(hashMap);
        }

        String[] from = {"images","txt"};
        int[] to = {R.id.image,R.id.txtTravel};

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
                aList,R.layout.listview_layout,from,to);

        ListView listView = findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.douglascollege.ca/")));
                        break;
                    case 1:
                        break;
                    case 2:
                        break;

                }

            }
        });


    }
}