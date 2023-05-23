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
            Intent intent = new Intent(MainActivity.this, Contacts.class);
            startActivity(intent);
        });

        Button navigateToCalculatorButton = findViewById(R.id.navigateToCalculator);
        navigateToCalculatorButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Calculator.class);
            MainActivity.this.startActivity(intent);
        });

        Button navigateToViewTestButton = findViewById(R.id.navigateToViewTest);
        navigateToViewTestButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewTestActivity.class);
            MainActivity.this.startActivity(intent);
        });

        Button navigateToNavigatorButton = findViewById(R.id.navigateToNavigator);
        navigateToNavigatorButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainFragment.class);
            MainActivity.this.startActivity(intent);
        });

        Button navigateToBroadcastButton = findViewById(R.id.navigateToBroadcast);
        navigateToBroadcastButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Broadcast.class);
            MainActivity.this.startActivity(intent);
        });

        Button navigateToThreadButton = findViewById(R.id.navigateToThread);
        navigateToThreadButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ThreadActivity.class);
            MainActivity.this.startActivity(intent);
        });

        Button navigateToRESTButton = findViewById(R.id.navigateToRest);
        navigateToRESTButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            MainActivity.this.startActivity(intent);
        });

        Button navigateToFilesButton = findViewById(R.id.navigateToFile);
        navigateToFilesButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FileActivity.class);
            MainActivity.this.startActivity(intent);
        });
    }
}