package com.example.partymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateParty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_party);

        final EditText location = findViewById(R.id.location2);
        final EditText date = findViewById(R.id.date);
        final EditText time = findViewById(R.id.time2);
        final Button create = findViewById(R.id.create);
        final String[] people = new String[]{"a", "b"};

        final Party party = new Party();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                party.setDate(date.getText().toString());
                party.setTime(time.getText().toString());
                party.setLocation(location.getText().toString());
                party.setPeople(people);

                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                myIntent.putExtra("Party", (Parcelable) party);
                startActivity(myIntent);
            }
        });
    }
}