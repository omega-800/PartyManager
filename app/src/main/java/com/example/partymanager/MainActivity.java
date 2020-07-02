package com.example.partymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final Party[] partyList = new Party[0];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView myParties = findViewById(R.id.myParties);
        final TextView invitedTo = findViewById(R.id.invitedTo);
        final TextView search = findViewById(R.id.search);
        final Button create = findViewById(R.id.create);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), CreateParty.class);
                startActivity(myIntent);
            }
        });

        Intent PartyIntent = getIntent();
    }
}