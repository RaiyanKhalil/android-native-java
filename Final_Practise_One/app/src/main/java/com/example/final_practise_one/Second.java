package com.example.final_practise_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Second extends AppCompatActivity {
    SchoolDB dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dbh = new SchoolDB(this);

        Button addG = findViewById(R.id.addGrade);
        Button findBook = findViewById(R.id.findBook);
        Button displayInfo = findViewById(R.id.displayInfo);
        Button logOut = findViewById(R.id.logout);

        addG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second.this, AddGrade.class);
                startActivity(intent);
            }
        });

        findBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second.this, ListData.class);
                startActivity(intent);
            }
        });

        final SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        displayInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String filename = "example.txt";
                    String content = "";


                    Cursor cursor = dbh.getInnerJoin(sharedPref.getInt("studentID", 0));
                    if (cursor.moveToFirst()) {
                        do {
                            String firstName = cursor.getString(cursor.getColumnIndex("name"));
                            String lastName = cursor.getString(cursor.getColumnIndex("course_id"));
                            String grade = cursor.getString(cursor.getColumnIndex("marks"));
                            content = firstName + " " + lastName + " got a grade of " + grade;
//                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        } while (cursor.moveToNext());
                    }
                    FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                    writer.write(content);
                    writer.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}