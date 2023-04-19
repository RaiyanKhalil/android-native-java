package com.example.final_practise_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddStudent extends AppCompatActivity {
    SchoolDB dbh;
    String selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        dbh = new SchoolDB(this);
        TextView stdName = findViewById(R.id.stdName);
        TextView stdEmail = findViewById(R.id.stdEmail);
        TextView stdPNumber = findViewById(R.id.stdContact);
        TextView stdPass = findViewById(R.id.stdPassword);
        CalendarView calendarView = findViewById(R.id.dob);
        Button regStudent = findViewById(R.id.regStd);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            }
        });


        regStudent.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View v) {

                isInserted = dbh.addStudentData(
                        stdName.getText().toString(),
                        stdEmail.getText().toString(),
                        stdPNumber.getText().toString(),
                        selectedDate,
                        stdPass.getText().toString()
                );
                if (isInserted){
                    Toast.makeText(AddStudent.this,"data added",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddStudent.this,"data not added",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}