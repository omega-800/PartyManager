package com.example.partymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.partymanager.data.Singleton;
import com.example.partymanager.model.Party;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Party> partyList = new ArrayList<Party>();
    Singleton singleton = Singleton.getInstance( );

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

        partyList = singleton.getParties();

        System.out.println(partyList.size() + "  ###################################################################################################");
        for(int i = 1; i < partyList.size(); i++){
            System.out.println(partyList.get(i).getDate());
        }
    }
}