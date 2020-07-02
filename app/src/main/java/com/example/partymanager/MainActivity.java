package com.example.partymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Party> partyList = new ArrayList<Party>();

    SaveState saveState = new SaveState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button create = findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), CreateParty.class);
                startActivity(myIntent);
            }
        });

        String partiesJSON = saveState.restore(MainActivity.super.getApplication());

        Gson gson = new Gson();
        Party[] partiesFU = gson.fromJson(partiesJSON, Party[].class);
        for(Party partyy : partiesFU) {
            System.out.println(partyy.toString());
        }

        Intent partyIntent = getIntent();
        System.out.println(partyList.size() + "  ###################################################################################################");
        for(int i = 1; i < partyList.size(); i++){
            System.out.println(partyList.get(i).getDate());
        }
    }
}