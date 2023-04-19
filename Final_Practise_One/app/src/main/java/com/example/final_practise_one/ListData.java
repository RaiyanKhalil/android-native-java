package com.example.final_practise_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListData extends AppCompatActivity {

//    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
//            "WebOS","Ubuntu","Windows7","Max OS X"};

    ArrayList<String> mobileArray;
    SchoolDB dbh;
    //android.widget
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        dbh = new SchoolDB(this);

        Cursor cursor = dbh.getBookList();
        mobileArray = new ArrayList<>();
        while (cursor.moveToNext()) {
            mobileArray.add(cursor.getString(
                    cursor.getColumnIndex("title")));
        }
        listView = findViewById(R.id.bookList);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(
                        this, R.layout.activity_list_view,
                        R.id.listView, mobileArray);
        listView.setAdapter(arrayAdapter);

        final SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        String selectedBookName = parent.getItemAtPosition(position).toString();
                        editor.putString("bookName",selectedBookName);
                        editor.apply();
                        Toast.makeText(ListData.this, "Selected book: " + selectedBookName, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        String selectedBookNames = parent.getItemAtPosition(position).toString();
                        editor.putString("bookName",selectedBookNames);
                        editor.apply();
                        Toast.makeText(ListData.this, "Selected book: " + selectedBookNames, Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        String selectedBookNamez = parent.getItemAtPosition(position).toString();
                        editor.putString("bookName",selectedBookNamez);
                        editor.apply();
                        Toast.makeText(ListData.this, "Selected book: " + selectedBookNamez, Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        });
    }
}