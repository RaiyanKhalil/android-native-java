package com.example.wk10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    // 12.
    DatabaseHelper dbh;
    Button btnUpdate = findViewById(R.id.btnUpdate);
    EditText idText = findViewById(R.id.editIdDelete);
    EditText newMobile = findViewById(R.id.editNewMobile);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        dbh = new DatabaseHelper(this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            int intId;
            boolean isUpdated;
            @Override
            public void onClick(View view) {
                intId = Integer.parseInt(idText.getText().toString());
                isUpdated = dbh.updateRec(intId, newMobile.getText().toString());
                if(isUpdated){
                    Toast.makeText(DeleteActivity.this, "Is updated", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DeleteActivity.this, "Is NOT updated", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}