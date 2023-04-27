package com.example.myapplication5.Contacts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication5.R;

public class Contacts extends AppCompatActivity {

    private final ActivityResultLauncher<Intent> launcherCreateContact = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::onContactCreated);

    EditText firstname;
    EditText lastname;
    EditText number;
    Button callButton;
    Button addContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Kontakte");
        setContentView(R.layout.contacts);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        number = findViewById(R.id.number);
        callButton = findViewById(R.id.call);
        addContactButton = findViewById(R.id.addContact);


        callButton.setOnClickListener(evt -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + number.getText().toString()));
            startActivity(callIntent);
        });

        addContactButton.setOnClickListener(evt -> {
            Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, firstname.getText().toString() + " " + lastname.getText().toString());
            launcherCreateContact.launch(contactIntent);
        });
    }

    private void onContactCreated(@NonNull ActivityResult result) {
        TextView resultBox = findViewById(R.id.resultbox);

        if (result.getResultCode() == Activity.RESULT_OK)
            resultBox.setText("Kontakt wurde hinzugefügt!");
        else
            resultBox.setText("Hat nicht geklappt : (");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("number", number.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        number.setText(savedInstanceState.getString("number"));
    }
}