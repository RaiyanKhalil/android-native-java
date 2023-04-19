package com.example.final_practise_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginStudent extends AppCompatActivity {
    SchoolDB dbh;
    Integer studentID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);

        dbh = new SchoolDB(this);
        TextView stdID = findViewById(R.id.studentID);
        TextView stdPass = findViewById(R.id.studentPass);
        Button btnLogin = findViewById(R.id.loginButton);

        final SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbh.loginUser(
                        Integer.parseInt(stdID.getText().toString()),
                        stdPass.getText().toString());
                if(cursor.getCount() > 0){
                    if (cursor.moveToFirst()){
                        studentID = cursor.getInt(0);
                        Intent intent = new Intent(LoginStudent.this, Second.class);
                        editor.putInt("studentID", studentID);
                        editor.apply();
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(LoginStudent.this, "Please enter valid a ID or Password.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}