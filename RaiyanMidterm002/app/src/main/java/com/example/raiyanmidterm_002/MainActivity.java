package com.example.raiyanmidterm_002;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] orderList = {"About the restaurant", "Display Menu", "Place Order", "Clear Order", "Display Order"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.txtMenu, orderList));


    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.douglascollege.ca/")));
                break;
            case 1:
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, RaiyanShuvo.class));
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}