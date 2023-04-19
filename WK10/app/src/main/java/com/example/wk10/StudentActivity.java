package com.example.wk10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {
    // 5.1.
    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        // 5.2.
        dbh = new DatabaseHelper(this);
        EditText name = findViewById(R.id.txtStudentName);
        EditText studentId = findViewById(R.id.txtStudentId);
        EditText mobile = findViewById(R.id.txtMobile);
        EditText courseId = findViewById(R.id.txtCourseId);

        Button btnAdd = findViewById(R.id.btnAddData);
        // 7.1
        Button btnView = findViewById(R.id.btnView);
        TextView outputData = findViewById(R.id.txtOutput);

        // 9.
        Button btnDeleteGo = findViewById(R.id.btnDeleteGo);

        btnDeleteGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, DeleteActivity.class));
            }
        });



        // 7.2
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = dbh.viewData();
                StringBuilder str = new StringBuilder();
                if(c.getCount() > 0){

                    while(c.moveToNext()){ // while there is still line left
                        str.append("id:  " + c.getString(0));
                        str.append(" / name: " + c.getString(1));
                        str.append(" / student id: " + c.getString(2));
                        str.append(" / mobile: " + c.getString(3));
                        str.append(" / course id: " + c.getString(4));
                        str.append("\n");

                    }
                    outputData.setText(str);
                } // end of endif
                else {
                    Toast.makeText(StudentActivity.this, "There is no data", Toast.LENGTH_SHORT).show();
                }



            }
        });

        // 5.3.
        btnAdd.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View view) {

//                Toast.makeText(StudentActivity.this, "Hi", Toast.LENGTH_SHORT).show();

               isInserted = dbh.addData(
                       name.getText().toString(),
                       studentId.getText().toString(),
                       mobile.getText().toString(),
                       courseId.getText().toString()
               );

               if(isInserted){
                   Toast.makeText(StudentActivity.this, "Is inserted", Toast.LENGTH_SHORT).show();

               } else {
                   Toast.makeText(StudentActivity.this, "Error inserting", Toast.LENGTH_SHORT).show();
               }
            }
        });




    }
}