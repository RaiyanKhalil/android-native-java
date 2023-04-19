package com.example.final_practise_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddGrade extends AppCompatActivity {
    SchoolDB dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);

        dbh = new SchoolDB(this);
        TextView student_Id = findViewById(R.id.std_ID);
        TextView course_Id = findViewById(R.id.course_ID);
        TextView course_grade = findViewById(R.id.enter_Grade);
        Button add_grade = findViewById(R.id.btn_add_grade);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        student_Id.setText(String.valueOf(sharedPreferences.getInt("studentID", 0)));

        add_grade.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View v) {
                isInserted = dbh.addGrade(
                        Integer.parseInt(student_Id.getText().toString()),
                        course_Id.getText().toString(),
                        course_grade.getText().toString()
                );
                if (isInserted){
                    Toast.makeText(AddGrade.this,"data added",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddGrade.this,"data not added",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}