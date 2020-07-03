package com.example.partymanager;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.partymanager.data.Singleton;
import com.example.partymanager.model.Party;

import java.util.ArrayList;

public class CreateParty extends Activity {

    Singleton singleton = Singleton.getInstance( );
    final Party party = new Party();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_party);

        final EditText location = findViewById(R.id.location2);
        final EditText date = findViewById(R.id.date);
        final EditText time = findViewById(R.id.time2);
        final Button create = findViewById(R.id.create);
        final Button contacts = findViewById(R.id.contacts);
        final TextView ppl = findViewById(R.id.people);
        final ArrayList<String> people = new ArrayList<String>();

        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int REQUEST_CODE=1;
                Uri uri = Uri.parse("content://contacts");
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intent, REQUEST_CODE);
        }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                party.setDate(date.getText().toString());
                party.setTime(time.getText().toString());
                party.setLocation(location.getText().toString());
                party.setPeople(people);

                singleton.addParty(party);

                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // check whether the result is ok
        Uri contactData = data.getData();
        Cursor c = getContentResolver().query(contactData, null, null, null, null);
        if (c.moveToFirst()) {
            //int phoneIndex = getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            //String num = c.getString(phoneIndex);
            String num = "0799422442";
            Toast.makeText(CreateParty.this, "Number=" + num, Toast.LENGTH_LONG).show();
            party.addPerson(num);
        }
    }
}