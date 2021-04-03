package com.example.a1851050194_vothikimyen_bai8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        insert.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();
                Boolean checkInsert = db.insterUserDate( nameTXT,contactTXT,dobTXT);
                if(checkInsert)
                    Toast.makeText( MainActivity.this,"New entry insert",Toast.LENGTH_SHORT ).show();
                else
                    Toast.makeText( MainActivity.this," No new entry insert",Toast.LENGTH_SHORT ).show();
            }
        } );
        update.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();
                Boolean checkUpdate = db.updateUserDate( nameTXT,contactTXT,dobTXT);
                if(checkUpdate)
                    Toast.makeText( MainActivity.this,"New entry update",Toast.LENGTH_SHORT ).show();
                else
                    Toast.makeText( MainActivity.this," No new entry update",Toast.LENGTH_SHORT ).show();
            }
        } );



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