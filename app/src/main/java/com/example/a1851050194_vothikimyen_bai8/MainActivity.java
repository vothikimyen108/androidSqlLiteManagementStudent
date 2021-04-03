package com.example.a1851050194_vothikimyen_bai8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, contact, dob;
    Button insert, update, delete,view;
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        anhXa();
        db = new DBhelper( this );

    }

    private void anhXa() {
        name = findViewById( R.id.editTextName );
        contact = findViewById( R.id.editTextTextContact );
        dob = findViewById( R.id.editTextBirthDay);
        insert = findViewById( R.id.buttonInsert );
        update = findViewById( R.id.buttonUpdate);
        delete = findViewById( R.id.buttonDelete );
    }
}