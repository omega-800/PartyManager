package com.example.partymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateParty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_party);

        final EditText location = findViewById(R.id.location2);
        final EditText date = findViewById(R.id.date);
        final EditText time = findViewById(R.id.time2);
        final Button create = findViewById(R.id.create);
        final ArrayList<String> people = new ArrayList<String>();
        people.add("a");
        people.add("b");

        final Party party = new Party();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                party.setDate(date.getText().toString());
                party.setTime(time.getText().toString());
                party.setLocation(location.getText().toString());
                party.setPeople(people);

                SaveState saveState = new SaveState();
                saveState.save(party.toString(), CreateParty.super.getApplication());
                System.out.println(saveState.restore(CreateParty.super.getApplication()));

                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                myIntent.putExtra("Party", "1");
                startActivity(myIntent);
            }
        });
    }
}