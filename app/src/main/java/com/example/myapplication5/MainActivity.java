package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication5.Calculator.Calculator;
import com.example.myapplication5.Contacts.Contacts;
import com.example.myapplication5.Views.ViewTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button navigateToContactsButton = findViewById(R.id.navigateToContacts);
        navigateToContactsButton.setOnClickListener(view -> {
            Intent contactsIntent = new Intent(MainActivity.this, Contacts.class);
            startActivity(contactsIntent);
        });

        Button navigateToCalculatorButton = findViewById(R.id.navigateToCalculator);
        navigateToCalculatorButton.setOnClickListener(view -> {
            Intent calculatorIntent = new Intent(MainActivity.this, Calculator.class);
            MainActivity.this.startActivity(calculatorIntent);
        });

        Button navigateToViewTestButton = findViewById(R.id.navigateToViewTest);
        navigateToViewTestButton.setOnClickListener(view -> {
            Intent calculatorIntent = new Intent(MainActivity.this, ViewTestActivity.class);
            MainActivity.this.startActivity(calculatorIntent);
        });

        Button navigateToNavigatorButton = findViewById(R.id.navigateToNavigator);
        navigateToNavigatorButton.setOnClickListener(view -> {
            Intent calculatorIntent = new Intent(MainActivity.this, MainFragment.class);
            MainActivity.this.startActivity(calculatorIntent);
        });
    }
}