package com.example.partymanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        final RecyclerView rec = findViewById(R.id.recycler);
        //final RecyclerView rec2 = findViewById(R.id.recycler2);

        rec.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec.setLayoutManager(layoutManager);

        MyAdapter mAdapter = new MyAdapter(partyList);
        rec.setAdapter(mAdapter);




        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), CreateParty.class);
                startActivity(myIntent);
            }
        });

        partyList = singleton.getParties();
    }
}