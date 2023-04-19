package com.example.final_practise_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddBook extends AppCompatActivity {

    SchoolDB dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        dbh = new SchoolDB(this);
        TextView bookName = findViewById(R.id.bookName);
        TextView bookAuthor = findViewById(R.id.bookAuthor);
        Button addBookToDB = findViewById(R.id.addBookToDB);

        addBookToDB.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View v) {
                isInserted = dbh.addBookData(
                        bookName.getText().toString(),
                        bookAuthor.getText().toString()
                );
                if (isInserted){
                    Toast.makeText(AddBook.this,"data added",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddBook.this,"data not added",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}